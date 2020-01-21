// 
// Decompiled by Procyon v0.5.36
// 

package com.stdio.hackedgonative.fucked;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class IOUtils
{
    private static final String a;
    
    public static void copy(final InputStream in, final OutputStream out) throws IOException {
        final byte[] array = new byte[1024];
        int read;
        while ((read = in.read(array)) > 0) {
            out.write(array, 0, read);
        }
    }
    
    public static void close(final Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        }
        catch (IOException ex) {
            Log.e(IOUtils.a, ex.toString());
        }
    }
    
    static {
        a = IOUtils.class.getName();
    }
}
