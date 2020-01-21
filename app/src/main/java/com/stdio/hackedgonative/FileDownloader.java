package com.stdio.hackedgonative;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.stdio.hackedgonative.fucked.AppConfig;

import java.io.File;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by weiyin on 6/24/14.
 */
public class FileDownloader implements DownloadListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private enum DownloadLocation {
        PUBLIC_DOWNLOADS, PRIVATE_INTERNAL
    }

    private static final String TAG = DownloadListener.class.getName();
    private static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".fileprovider";
    public MainActivity context;
    private ProgressDialog progressDialog;
    private String lastDownloadedUrl;
    private DownloadLocation defaultDownloadLocation;
    private Map<String, DownloadManager.Request> pendingExternalDownloads;

    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 666;

    FileDownloader(MainActivity context) {
        this.context = context;
        this.pendingExternalDownloads = new HashMap<>();

        AppConfig appConfig = AppConfig.getInstance(this.context);
        if (appConfig.downloadToPublicStorage) {
            this.defaultDownloadLocation = DownloadLocation.PUBLIC_DOWNLOADS;
        } else {
            this.defaultDownloadLocation = DownloadLocation.PRIVATE_INTERNAL;
        }
    }

    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        if (context != null) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    context.showWebview();
                }
            });
        }

        lastDownloadedUrl = url;

        // try to guess mimetype
        if (mimetype == null || mimetype.equalsIgnoreCase("application/force-download") ||
                mimetype.equalsIgnoreCase("application/octet-stream")) {
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            String extension = MimeTypeMap.getFileExtensionFromUrl(url);
            if (extension != null && !extension.isEmpty()) {
                String guessedMimeType = mimeTypeMap.getMimeTypeFromExtension(extension);
                if (guessedMimeType != null) {
                    mimetype = guessedMimeType;
                }
            }
        }

        if (this.defaultDownloadLocation == DownloadLocation.PUBLIC_DOWNLOADS) {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                try {
                    Uri uri = Uri.parse(url);
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.addRequestHeader("User-Agent", userAgent);

                    // set cookies
                    CookieManager cookieManager = CookieManager.getInstance();
                    String cookie = cookieManager.getCookie(url);
                    if (cookie != null) {
                        request.addRequestHeader("Cookie", cookie);
                    }

                    request.allowScanningByMediaScanner();
                    String guessedName = LeanUtils.guessFileName(url, contentDisposition, mimetype);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessedName);
                    request.setMimeType(mimetype);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    enqueueBackgroundDownload(url, request);

                } catch (Exception e) {
                    Log.e(TAG, e.getMessage(), e);
                    Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }

                return;
            } else {
                Log.w(TAG, "External storage is not mounted. Downloading internally.");
            }
        }

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_GRANTED ) {
            DownloadFileParams param = new DownloadFileParams(url, userAgent, mimetype, contentLength);
            new DownloadFileTask(this, context).execute(param);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            } else {
                Toast toast = Toast.makeText(context, "Вы не предоставили доступ к памяти", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }

    private String folder;

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                folder = Environment.getExternalStorageDirectory() + File.separator + context.getResources().getString(R.string.download_path);

                File directory = new File(folder);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

            }
        }
    }

    private void enqueueBackgroundDownload(String url, DownloadManager.Request request) {
        this.pendingExternalDownloads.put(url, request);
        this.context.getExternalStorageWritePermission();
    }

    public void gotExternalStoragePermissions(boolean granted) {
        if (granted) {
            Toast.makeText(this.context, R.string.starting_download, Toast.LENGTH_SHORT).show();

            DownloadManager downloadManager = (DownloadManager) this.context.getSystemService(Context.DOWNLOAD_SERVICE);
            if (downloadManager == null) {
                Log.e(TAG, "Error getting system download manager");
                return;
            }
            for (DownloadManager.Request request : this.pendingExternalDownloads.values()) {
                downloadManager.enqueue(request);
            }
            this.pendingExternalDownloads.clear();
        }
    }

    private class DownloadFileParams {
        public String url;
        public String userAgent;
        public String mimetype;
        public long contentLength;

        private DownloadFileParams(String url, String userAgent, String mimetype, long contentLength) {
            this.url = url;
            this.userAgent = userAgent;
            this.mimetype = mimetype;
            this.contentLength = contentLength;
        }
    }

    private static class DownloadFileResult {
        public File file;
        public String mimetype;

        private DownloadFileResult(File file, String mimetype) {
            this.file = file;
            this.mimetype = mimetype;
        }
    }

    private static class DownloadFileTask extends AsyncTask<DownloadFileParams, Integer, DownloadFileResult> {
        private WeakReference<FileDownloader> fileDownloaderReference;
        private Exception exception;
        private Context mContext;

        DownloadFileTask(FileDownloader fileDownloader, Context mContext) {
            this.fileDownloaderReference = new WeakReference<>(fileDownloader);
            this.mContext = mContext;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected DownloadFileResult doInBackground(DownloadFileParams... params) {

            FileDownloader fileDownloader = fileDownloaderReference.get();
            if (fileDownloader == null) return null;

            HttpURLConnection connection;
            URL url;
            DownloadFileParams param = params[0];
            try {
                url = new URL(param.url);
            } catch (MalformedURLException e) {
                exception = e;
                return null;
            }

            if (param.contentLength > 0) publishProgress(0);

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setInstanceFollowRedirects(true);
                connection.setRequestProperty("User-Agent", param.userAgent);

                connection.connect();
                if (connection.getResponseCode() < 400) {

                    mContext.startService(DownloadService.getDownloadService(mContext, url.toString(), DirectoryHelper.ROOT_DIRECTORY_NAME.concat("/")));
                    mContext.registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                    mContext.registerReceiver(onNotificationClick, new IntentFilter(DownloadManager.ACTION_NOTIFICATION_CLICKED));

                    return null;
                }

            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }

            return null;
        }

        BroadcastReceiver onComplete = new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                mContext.unregisterReceiver(onComplete);

            }
        };

        BroadcastReceiver onNotificationClick=new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                mContext.unregisterReceiver(onNotificationClick);
            }
        };

        @Override
        protected void onProgressUpdate(Integer... values) {
        }

        @Override
        protected void onPostExecute(DownloadFileResult result) {
            FileDownloader fileDownloader = fileDownloaderReference.get();
            if (fileDownloader == null) return;

            if (exception != null) {
                Log.e(TAG, exception.getMessage(), exception);
                Toast.makeText(fileDownloader.context, exception.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }

            if (result != null && result.file != null) {
                Uri content;
                try {
                    content = FileProvider.getUriForFile(fileDownloader.context, AUTHORITY, result.file);
                } catch (IllegalArgumentException e) {
                    Log.e(TAG, "Unable to get content url from FileProvider", e);
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(content, result.mimetype);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                try {
                    fileDownloader.context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    String message = fileDownloader.context.getResources().getString(R.string.file_handler_not_found);
                    Toast.makeText(fileDownloader.context, message, Toast.LENGTH_LONG).show();
                }
            }
        }

        @Override
        protected void onCancelled(DownloadFileResult downloadFileResult) {
            FileDownloader fileDownloader = fileDownloaderReference.get();
            if (fileDownloader == null) return;

            Toast.makeText(fileDownloader.context, R.string.download_canceled, Toast.LENGTH_SHORT).show();
        }
    }

    public String getLastDownloadedUrl() {
        return lastDownloadedUrl;
    }
}
