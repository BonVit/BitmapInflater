package com.vitaliibonar.bitmapinflater.template;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.vitaliibonar.bitmapinflater.R;
import com.vitaliibonar.bitmapinflater.template.base.BaseInflaterBuilder;
import com.vitaliibonar.bitmapinflater.template.base.BaseViewInflater;

/**
 * Created by vitaliibonar on 1/12/18.
 */

public class TextInflater extends BaseViewInflater {

    //text
    private String text = "";

    //padding
    private int paddingBottom = 0;
    private int paddingTop = 0;
    private int paddingLeft = 0;
    private int paddingRight = 0;

    //background
    @ColorRes
    private int backgroundColor = 0;
    @DrawableRes
    private Integer backgroundDrawable = null;

    //text style
    private int textSize = 14;
    @ColorRes
    private int textColor = R.color.colorBlack;
    private Typeface textTypeface = null;
    private boolean textAllCaps = false;
    @StyleRes
    private int textStyle = 0;

    public TextInflater(Context context) {
        super(context);
    }

    @Override
    protected void configView(View v) {
        TextView textView = v.findViewById(R.id.inflater_text_text_view);

        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(viewSettings.getContext().getResources().getColor(textColor));
        textView.setAllCaps(textAllCaps);
        if (textTypeface != null) {
            textView.setTypeface(textTypeface);
        }
        textView.setBackgroundColor(viewSettings.getContext().getResources().getColor(backgroundColor));
        if (backgroundDrawable != null) {
            textView.setBackgroundResource(backgroundDrawable);
        }
        textView.setTextAppearance(viewSettings.getContext(), textStyle);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
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

    public boolean isTextAllCaps() {
        return textAllCaps;
    }

    public void setTextAllCaps(boolean textAllCaps) {
        this.textAllCaps = textAllCaps;
    }

    public Integer getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(Integer textStyle) {
        this.textStyle = textStyle;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable(Integer backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }

    @Override
    public @LayoutRes
    int getLayoutRes() {
        return R.layout.inflater_text;
    }

    public static class Builder extends BaseInflaterBuilder {
        private TextInflater textInflater;

        private Builder(Context context) {
            textInflater = new TextInflater(context);
        }

        public static Builder newBuilder(Context context) {
            return new Builder(context);
        }

        @Override
        public TextInflater build() {
            return textInflater;
        }

        public Builder setText(String text) {
            this.textInflater.setText(text);
            return this;
        }

        public Builder setPaddingBottom(int paddingBottom) {
            this.textInflater.setPaddingBottom(paddingBottom);
            return this;
        }

        public Builder setPaddingTop(int paddingTop) {
            this.textInflater.setPaddingTop(paddingTop);
            return this;
        }

        public Builder setPaddingLeft(int paddingLeft) {
            this.textInflater.setPaddingLeft(paddingLeft);
            return this;
        }

        public Builder setPaddingRight(int paddingRight) {
            this.textInflater.setPaddingRight(paddingRight);
            return this;
        }

        public Builder setPadding(int padding) {
            this.textInflater.setPaddingBottom(padding);
            this.textInflater.setPaddingTop(padding);
            this.textInflater.setPaddingRight(padding);
            this.textInflater.setPaddingLeft(padding);
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textInflater.setTextSize(textSize);
            return this;
        }

        public Builder setTextColor(@ColorRes int textColor) {
            this.textInflater.setTextColor(textColor);
            return this;
        }

        public Builder setTextTypeface(Typeface textTypeface) {
            this.textInflater.setTextTypeface(textTypeface);
            return this;
        }

        public Builder setTextAllCaps(boolean textAllCaps) {
            this.textInflater.setTextAllCaps(textAllCaps);
            return this;
        }

        public Builder setTextStyle(@StyleRes int textStyle) {
            this.textInflater.setTextStyle(textStyle);
            return this;
        }

        public Builder setWidth(int width) {
            this.textInflater.setWidth(width);
            return this;
        }

        public Builder setHeight(int height) {
            this.textInflater.setHeight(height);
            return this;
        }

        public Builder setBitmapConfig(Bitmap.Config bitmapConfig) {
            this.textInflater.setBitmapConfig(bitmapConfig);
            return this;
        }

        public Builder setBackgroundColor(@ColorRes int backgroundColor) {
            this.textInflater.setBackgroundColor(backgroundColor);
            return this;
        }

        public Builder setBackgroundDrawable(@DrawableRes Integer backgroundDrawable) {
            this.textInflater.setBackgroundDrawable(backgroundDrawable);
            return this;
        }
    }
}
