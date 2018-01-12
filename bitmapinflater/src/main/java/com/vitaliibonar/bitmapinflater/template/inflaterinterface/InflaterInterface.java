package com.vitaliibonar.bitmapinflater.template.inflaterinterface;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;

/**
 * Created by vitaliibonar on 1/12/18.
 */

public interface InflaterInterface {
    @LayoutRes int getLayoutRes();
    Bitmap makeBitmap();
}
