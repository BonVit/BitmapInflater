package com.vitaliibonar.bitmapinflater.sample;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vitaliibonar.bitmapinflater.BitmapInflater;
import com.vitaliibonar.bitmapinflater.ViewSettings;
import com.vitaliibonar.bitmapinflater.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Bitmap bitmap = BitmapInflater.createBitmapFromSettings(ViewSettings.newSettings()
                .setHeight(ViewSettings.WRAP_CONTENT)
                .setWidth(ViewSettings.WRAP_CONTENT)
                .setLayoutRes(R.layout.activity_main)
                .setContext(this)
        );
        bitmap.getWidth();
    }
}
