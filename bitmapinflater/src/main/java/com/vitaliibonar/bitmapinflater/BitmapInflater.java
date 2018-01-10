package com.vitaliibonar.bitmapinflater;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public static Bitmap createBitmapFromLayoutRes(ViewGroup parent, @LayoutRes int layoutRes, int width, int height, Bitmap.Config bitmapConfig) {
        View v = inflateView(parent, layoutRes);
        measureView(parent, v, width, height);
        return createBitmapFromView(v, bitmapConfig);
    }


    public static Bitmap createBitmapFromLayoutRes(ViewGroup parent, @LayoutRes int layoutRes, int width, int height, Bitmap.Config bitmapConfig, ViewSettings.Callbacks callbacks) {
        View v = inflateView(parent, layoutRes);
        measureView(parent, v, width, height);
        if (callbacks != null) {
            callbacks.configView(v);
        }
        return createBitmapFromView(v, bitmapConfig);
    }

    public static Bitmap createBitmapFromSettings(ViewSettings settings) {
        return createBitmapFromLayoutRes(settings.getViewGroup(), settings.getLayoutRes(), settings.getWidth(), settings.getHeight(), settings.getBitmapConfig(), settings.getCallbacks());
    }

    private static View inflateView(ViewGroup parent, @LayoutRes int layoutRes) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(layoutRes, parent);
    }

    private static void measureView(ViewGroup parent, View v, int width, int height) {
        if (width == ViewSettings.MATCH_PARENT) {
            width = parent.getWidth();
        }
        if (height == ViewSettings.MATCH_PARENT) {
            height = parent.getHeight();
        }
        v.measure(makeMeasureSpec(width), makeMeasureSpec(height));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    }

    private static int makeMeasureSpec(int value) {
        if (value < -3) {
            throw new IllegalArgumentException();
        }
        if (value == ViewSettings.WRAP_CONTENT) {
            return View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.EXACTLY);
        }
        return View.MeasureSpec.makeMeasureSpec(value, View.MeasureSpec.EXACTLY);
    }

}