package com.vitaliibonar.bitmapinflater.template;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vitaliibonar.bitmapinflater.R;
import com.vitaliibonar.bitmapinflater.ViewSettings;
import com.vitaliibonar.bitmapinflater.template.base.BaseInflaterBuilder;
import com.vitaliibonar.bitmapinflater.template.base.BaseViewInflater;

/**
 * Created by vitaliibonar on 1/14/18.
 */

public class CircleTextInflater extends BaseViewInflater {

    private String text = "";

    //padding
    private int padding = 0;

    //background
    @ColorRes
    private int backgroundColor = 0;

    //text style
    private int textSize = 14;
    @ColorRes
    private int textColor = R.color.colorBlack;
    private Typeface textTypeface = null;
    @StyleRes
    private int textStyle = 0;

    public CircleTextInflater(Context context) {
        super(context);
    }

    @Override
    protected ViewSettings.Callbacks callbacks() {
        return new ViewSettings.Callbacks() {
            @Override
            public void configView(View v) {
                ViewGroup rootView = v.findViewById(R.id.inflater_circle_root_view);
                TextView textView = v.findViewById(R.id.inflater_circle_text_view);

                textView.setPadding(padding, padding, padding, padding);
                textView.setText(text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
                textView.setTextColor(viewSettings.getContext().getResources().getColor(textColor));
                if (textTypeface != null) {
                    textView.setTypeface(textTypeface);
                }
                textView.setTextAppearance(viewSettings.getContext(), textStyle);

                ((GradientDrawable) rootView.getBackground()).setColor(viewSettings.getContext().getResources().getColor(backgroundColor));
                textView.setTextColor(viewSettings.getContext().getResources().getColor(R.color.colorText));
            }

            @Override
            public void measureView(int[] size) {
                size[0] = Math.max(size[0], size[1]);
                size[1] = size[0];
            }
        };
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.inflater_circle_text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public Typeface getTextTypeface() {
        return textTypeface;
    }

    public void setTextTypeface(Typeface textTypeface) {
        this.textTypeface = textTypeface;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(int textStyle) {
        this.textStyle = textStyle;
    }

    public static class Builder extends BaseInflaterBuilder {
        private CircleTextInflater circleTextInflater;

        private Builder(Context context) {
            circleTextInflater = new CircleTextInflater(context);
        }

        public static CircleTextInflater.Builder newBuilder(Context context) {
            return new CircleTextInflater.Builder(context);
        }

        @Override
        public BaseViewInflater build() {
            return circleTextInflater;
        }

        public CircleTextInflater.Builder setText(String text) {
            this.circleTextInflater.setText(text);
            return this;
        }

        public CircleTextInflater.Builder setPadding(int padding) {
            this.circleTextInflater.setPadding(padding);
            return this;
        }

        public CircleTextInflater.Builder setTextSize(int textSize) {
            this.circleTextInflater.setTextSize(textSize);
            return this;
        }

        public CircleTextInflater.Builder setTextColor(@ColorRes int textColor) {
            this.circleTextInflater.setTextColor(textColor);
            return this;
        }

        public CircleTextInflater.Builder setTextTypeface(Typeface textTypeface) {
            this.circleTextInflater.setTextTypeface(textTypeface);
            return this;
        }

        public CircleTextInflater.Builder setTextStyle(@StyleRes int textStyle) {
            this.circleTextInflater.setTextStyle(textStyle);
            return this;
        }

        public CircleTextInflater.Builder setWidth(int width) {
            this.circleTextInflater.setWidth(width);
            return this;
        }

        public CircleTextInflater.Builder setHeight(int height) {
            this.circleTextInflater.setHeight(height);
            return this;
        }

        public CircleTextInflater.Builder setBitmapConfig(Bitmap.Config bitmapConfig) {
            this.circleTextInflater.setBitmapConfig(bitmapConfig);
            return this;
        }

        public CircleTextInflater.Builder setBackgroundColor(@ColorRes int backgroundColor) {
            this.circleTextInflater.setBackgroundColor(backgroundColor);
            return this;
        }
    }
}
