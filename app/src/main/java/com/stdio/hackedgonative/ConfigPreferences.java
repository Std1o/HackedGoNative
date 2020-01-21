package com.stdio.hackedgonative;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

public class ConfigPreferences {
    private static final String INITIAL_URL_KEY = "io.gonative.android.initialUrl";

    private Context context;
    private SharedPreferences sharedPreferences;

    public ConfigPreferences(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        if (this.sharedPreferences == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        }
        return this.sharedPreferences;
    }

    public String getInitialUrl() {
        SharedPreferences preferences = getSharedPreferences();
        String url = preferences.getString(INITIAL_URL_KEY, null);
        return processUrl(url);
    }

    private void setInitialUrl(String url) {
        url = processUrl(url);

        SharedPreferences preferences = getSharedPreferences();
        if (url == null || url.length() == 0) {
            preferences.edit().remove(INITIAL_URL_KEY).apply();
            return;
        } else {
            preferences.edit().putString(INITIAL_URL_KEY, url).apply();
        }
    }

    public void handleUrl(Uri uri) {
        if (!"gonative".equals(uri.getScheme()) || !"config".equals(uri.getHost())) return;

        if ("/set".equals(uri.getPath())) {
            String initialUrl = uri.getQueryParameter("initialUrl");
            if (initialUrl != null) {
                setInitialUrl(initialUrl);
            }
        }
    }

    private String processUrl(String url) {
        if (url == null || url.length() == 0) {
            return null;
        }

        // if protocol is not specified, add http://
        if (url.indexOf("://") == -1) {
            return "http://" + url;
        } else {
            return url;
        }
    }
}
