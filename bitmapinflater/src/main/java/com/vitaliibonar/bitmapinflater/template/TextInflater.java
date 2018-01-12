package com.vitaliibonar.bitmapinflater.template;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.vitaliibonar.bitmapinflater.BitmapInflater;
import com.vitaliibonar.bitmapinflater.R;
import com.vitaliibonar.bitmapinflater.ViewSettings;
import com.vitaliibonar.bitmapinflater.databinding.InflaterTextBinding;
import com.vitaliibonar.bitmapinflater.template.inflaterinterface.BuilderInterface;
import com.vitaliibonar.bitmapinflater.template.inflaterinterface.InflaterInterface;

/**
 * Created by vitaliibonar on 1/12/18.
 */

public class TextInflater implements InflaterInterface {

    private Context context;

    private Bitmap.Config bitmapConfig = Bitmap.Config.ARGB_8888;
    private int width = ViewSettings.WRAP_CONTENT;
    private int height = ViewSettings.WRAP_CONTENT;

    private String text = "";

    //padding
    private int paddingBottom = 0;
    private int paddingTop = 0;
    private int paddingLeft = 0;
    private int paddingRight = 0;

    private int textSize = 0;

    public TextInflater(Context context) {
        this.context = context;
    }

    @Override
    public Bitmap makeBitmap() {
        return BitmapInflater.createBitmapFromSettings(ViewSettings.newSettings()
                .setContext(context)
                .setBitmapConfig(bitmapConfig)
                .setWidth(width)
                .setHeight(height)
                .setLayoutRes(getLayoutRes())
                .setCallbacks(new ViewSettings.Callbacks() {
                    @Override
                    public void configView(View v) {
                        InflaterTextBinding binding = DataBindingUtil.bind(v);
                        binding.inflaterTextTextView.setText(text);
                        binding.inflaterTextTextView.setTextSize(textSize);
                    }
                }));
    }

    @Override
    public @LayoutRes int getLayoutRes() {
        return R.layout.inflater_text;
    }

    public class Builder implements BuilderInterface {
        private TextInflater textInflater;

        private Builder(Context context) {
            textInflater = new TextInflater(context);
        }

        @Override
        public BuilderInterface newBuilder(Context context) {
            return new Builder(context);
        }

        @Override
        public InflaterInterface build() {
            return textInflater;
        }
    }
}
