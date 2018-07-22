package com.example.tprime.bitmaptests;

import android.graphics.Bitmap;

public class ImageTypeListItem {
    public Bitmap mBitmap;
    public String mFunName;
    public String mResult;

    ImageTypeListItem(Bitmap bitmap, String name, String result) {
        this.mBitmap = bitmap;
        this.mFunName = name;
        this.mResult = result;
    }
}
