package com.vitaliibonar.bitmapinflater;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by vitaliibonar on 1/8/18.
 */

public class BitmapInflater {

    public static Bitmap createBitmapFromView(View view, Bitmap.Config bitmapConfig) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), bitmapConfig);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    public static Bitmap createBitmapFromLayoutRes(Context context, @LayoutRes int layoutRes, int width, int height, Bitmap.Config bitmapConfig) {
        View v = inflateView(context, layoutRes);
        measureView(context, v, width, height, null);
        return createBitmapFromView(v, bitmapConfig);
    }

    public static Bitmap createBitmapFromLayoutRes(Context context, @LayoutRes int layoutRes, int width, int height, Bitmap.Config bitmapConfig, ViewSettings.Callbacks callbacks) {
        View v = inflateView(context, layoutRes);
        if (callbacks != null) {
            callbacks.configView(v);
        }
        measureView(context, v, width, height, callbacks);
        return createBitmapFromView(v, bitmapConfig);
    }

    public static Bitmap createBitmapFromSettings(ViewSettings settings) {
        return createBitmapFromLayoutRes(settings.getContext(), settings.getLayoutRes(), settings.getWidth(), settings.getHeight(), settings.getBitmapConfig(), settings.getCallbacks());
    }

    private static View inflateView(Context context, @LayoutRes int layoutRes) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup viewGroup = new LinearLayout(context);
        return inflater.inflate(layoutRes, viewGroup);
    }

    private static void measureView(Context context, View v, int width, int height, ViewSettings.Callbacks callbacks) {
        if (width < -1 || height < -1) {
            throw new IllegalArgumentException();
        }

        width = makeMeasureSpec(context, width);
        height = makeMeasureSpec(context, height);

        v.measure(width, height);
        if (callbacks != null) {
            int[] size = {v.getMeasuredWidth(), v.getMeasuredHeight()};
            callbacks.measureView(size);
            size[0] = makeMeasureSpec(context, size[0]);
            size[1] = makeMeasureSpec(context, size[1]);
            v.measure(size[0], size[1]);
        }
        v.getRootView().layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    }

    private static int makeMeasureSpec(Context context, int value) {
        if (value == ViewSettings.WRAP_CONTENT) {
            value = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().heightPixels, View.MeasureSpec.AT_MOST);
        } else {
            value = View.MeasureSpec.makeMeasureSpec(value, View.MeasureSpec.EXACTLY);
        }
        return value;
    }
}