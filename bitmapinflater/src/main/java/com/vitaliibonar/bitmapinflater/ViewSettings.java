package com.vitaliibonar.bitmapinflater;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

public class ViewSettings {
    public static final int WRAP_CONTENT = -1;
    public static final int MATCH_PARENT = -2;

    private int width;
    private int height;
    private @LayoutRes int layoutRes;
    private ViewGroup viewGroup;
    private Bitmap.Config bitmapConfig;
    private Callbacks callbacks;

    public static ViewSettings newSettings() {
        return new ViewSettings();
    }

    private ViewSettings() {
    }

    public int getWidth() {
        return width;
    }

    public ViewSettings setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public ViewSettings setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public ViewSettings setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
        return this;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public ViewSettings setViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        return this;
    }

    public Bitmap.Config getBitmapConfig() {
        return bitmapConfig;
    }

    public ViewSettings setBitmapConfig(Bitmap.Config bitmapConfig) {
        this.bitmapConfig = bitmapConfig;
        return this;
    }

    public Callbacks getCallbacks() {
        return callbacks;
    }

    public ViewSettings setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
        return this;
    }

    public interface Callbacks {
        void configView(View v);
    }
}
