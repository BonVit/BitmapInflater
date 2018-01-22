package com.vitaliibonar.bitmapinflater.sample;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.vitaliibonar.bitmapinflater.sample.base.BaseActivity;
import com.vitaliibonar.bitmapinflater.sample.databinding.ActivityCircleTextBinding;
import com.vitaliibonar.bitmapinflater.template.CircleTextInflater;

public class CircleTextActivity extends BaseActivity {

    private ActivityCircleTextBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding.activityCircleTextButton.setOnClickListener(mOnGetImageButtonClickListener);
    }

    private View.OnClickListener mOnGetImageButtonClickListener = view -> mBinding.activityCircleTextImageView.setImageBitmap(
            CircleTextInflater.Builder.newBuilder(this)
                    .setBackgroundColor(R.color.colorPrimary)
                    .setPadding(40)
                    .setText(mBinding.activityCircleTextEditText.getText().toString())
                    .setTextColor(R.color.colorAccent)
                    .setTextSize(100)
                    .build()
                    .makeBitmap());

    @Override
    protected void setBinding(ViewDataBinding binding) {
        mBinding = (ActivityCircleTextBinding) binding;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_circle_text;
    }
}
