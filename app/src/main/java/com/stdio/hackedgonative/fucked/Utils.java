// 
// Decompiled by Procyon v0.5.36
// 

package com.stdio.hackedgonative.fucked;

import org.json.JSONObject;
import android.util.Log;
import android.graphics.Color;

public class Utils
{
    private static final String a;
    
    public static Integer parseColor(final String colorString) {
        if (colorString == null) {
            return null;
        }
        try {
            return Color.parseColor(colorString);
        }
        catch (IllegalArgumentException ex) {
            Log.e(Utils.a, "Bad color string:" + colorString, (Throwable)ex);
            return null;
        }
    }
    
    public static String optString(final JSONObject json, final String key) {
        if (json == null || key == null) {
            return null;
        }
        if (json.isNull(key)) {
            return null;
        }
        return json.optString(key, (String)null);
    }
    
    static {
        a = Utils.class.getName();
    }
}
