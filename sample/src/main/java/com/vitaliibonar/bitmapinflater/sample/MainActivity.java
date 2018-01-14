package com.vitaliibonar.bitmapinflater.sample;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vitaliibonar.bitmapinflater.ViewSettings;
import com.vitaliibonar.bitmapinflater.sample.databinding.ActivityMainBinding;
import com.vitaliibonar.bitmapinflater.template.TextInflater;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Bitmap bitmap = TextInflater.Builder.newBuilder(this)
                .setWidth(ViewSettings.WRAP_CONTENT)
                .setHeight(ViewSettings.WRAP_CONTENT)
                .setText("Test text")
                .setTextSize(80)
                .setTextColor(R.color.colorPrimary)
                .setPadding(0)
                .setBackgroundColor(R.color.colorAccent)
                .build()
                .makeBitmap();

        Log.d("TestBitmap", bitmap.toString());
    }
}
