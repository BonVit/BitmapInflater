package com.vitaliibonar.bitmapinflater.sample.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(DataBindingUtil.setContentView(this, getLayoutRes()));
        onActivityCreate(savedInstanceState);
    }

    protected void onActivityCreate(Bundle savedInstanceState) {

    }

    protected abstract void setBinding(ViewDataBinding binding);

    @LayoutRes
    protected abstract int getLayoutRes();
}
