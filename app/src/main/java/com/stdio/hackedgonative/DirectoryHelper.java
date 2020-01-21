package com.stdio.hackedgonative;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;

import java.io.File;

public class DirectoryHelper extends ContextWrapper {

    public static final String ROOT_DIRECTORY_NAME = "/Download";

    private DirectoryHelper(Context context) {
        super(context);
        createFolderDirectories();
    }

    public static void createDirectory(Context context) {
        new DirectoryHelper(context);
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    private void createFolderDirectories() {
        if (isExternalStorageAvailable())
            createDirectory();
    }

    private void createDirectory() {
        if (!isDirectoryExists()) {
            File file = new File(Environment.getExternalStorageDirectory(), DirectoryHelper.ROOT_DIRECTORY_NAME);
            //noinspection ResultOfMethodCallIgnored
            file.mkdir();
        }
    }

    private boolean isDirectoryExists() {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + DirectoryHelper.ROOT_DIRECTORY_NAME);
        return file.isDirectory() && file.exists();
    }
}
