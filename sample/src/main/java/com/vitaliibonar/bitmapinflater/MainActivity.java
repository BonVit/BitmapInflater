package com.vitaliibonar.bitmapinflater;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.vitaliibonar.bitmapinflater.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Bitmap bitmap = BitmapInflater.createBitmapFromSettings(ViewSettings.newSettings()
                .setHeight(ViewSettings.WRAP_CONTENT)
                .setWidth(ViewSettings.WRAP_CONTENT)
                .setBitmapConfig(Bitmap.Config.ARGB_8888)
                .setLayoutRes(R.layout.activity_main)
                .setViewGroup(new LinearLayout(this))
        );
        bitmap.getWidth();
    }
}
