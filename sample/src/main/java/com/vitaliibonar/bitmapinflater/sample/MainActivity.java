package com.vitaliibonar.bitmapinflater.sample;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

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
                .setHeight(100)
                .setWidth(100)
                .setBitmapConfig(Bitmap.Config.ARGB_8888)
                .setLayoutRes(R.layout.activity_main)
                .setViewGroup(new LinearLayout(this))
        );
        bitmap.getWidth();
    }
}
