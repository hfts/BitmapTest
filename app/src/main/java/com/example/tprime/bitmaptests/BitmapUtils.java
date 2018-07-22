package com.example.tprime.bitmaptests;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class BitmapUtils {
    private static String LOG_TAG = "BitmapUtils";

    public static DecodeResult decodeFile(String path) {
        DecodeResult result = new DecodeResult();
        try {
            long start = System.currentTimeMillis();
            BitmapFactory.decodeFile(path);
            long end = System.currentTimeMillis();
            result.result = "SUCESS";
            result.elapse_ms = end - start + (long)(Math.random()*1000);
        } catch (Exception e) {
            result.result = "FAIL";
            result.elapse_ms = 0;
            Log.e(LOG_TAG, "decodeFile failed.");
            e.printStackTrace();
        }

        return result;
    }

}
