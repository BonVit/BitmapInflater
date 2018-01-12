package com.vitaliibonar.bitmapinflater.template.inflaterinterface;

import android.content.Context;

/**
 * Created by vitaliibonar on 1/12/18.
 */

public interface BuilderInterface {
    BuilderInterface newBuilder(Context context);
    InflaterInterface build();
}
