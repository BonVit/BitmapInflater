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
        measureView(context, v, width, height);
        return createBitmapFromView(v, bitmapConfig);
    }

    public static Bitmap createBitmapFromLayoutRes(Context context, @LayoutRes int layoutRes, int width, int height, Bitmap.Config bitmapConfig, ViewSettings.Callbacks callbacks) {
        View v = inflateView(context, layoutRes);
        if (callbacks != null) {
            callbacks.configView(v);
        }
        measureView(context, v, width, height);
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

    private static void measureView(Context context, View v, int width, int height) {
        if (width < -1 || height < -1) {
            throw new IllegalArgumentException();
        }

        if (width == ViewSettings.WRAP_CONTENT) {
            width = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels, View.MeasureSpec.AT_MOST);
        } else {
            width = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        }

        if (height == ViewSettings.WRAP_CONTENT) {
            height = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().heightPixels, View.MeasureSpec.AT_MOST);
        } else {
            height = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        }

        v.measure(width, height);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    }
}