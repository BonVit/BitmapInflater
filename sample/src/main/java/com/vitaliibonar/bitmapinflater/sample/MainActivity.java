package com.vitaliibonar.bitmapinflater.sample;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.vitaliibonar.bitmapinflater.sample.base.BaseActivity;
import com.vitaliibonar.bitmapinflater.sample.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        super.onActivityCreate(savedInstanceState);

        mBinding.activityMainCircleTextButton.setOnClickListener(mOnCircleTextButtonClickListener);
    }

    private View.OnClickListener mOnCircleTextButtonClickListener = view -> startActivity(new Intent(MainActivity.this, CircleTextActivity.class));

    @Override
    protected void setBinding(ViewDataBinding binding) {
        mBinding = (ActivityMainBinding) binding;
    }

    @Override
    @LayoutRes
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}
