package com.vitaliibonar.bitmapinflater.sample;

import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vitaliibonar.bitmapinflater.BitmapInflater;
import com.vitaliibonar.bitmapinflater.ViewSettings;
import com.vitaliibonar.bitmapinflater.sample.base.BaseActivity;
import com.vitaliibonar.bitmapinflater.sample.databinding.ActivityMapBinding;

public class ActivityMap extends BaseActivity {

    private ActivityMapBinding mBinding;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding.activityMapMapView.onCreate(savedInstanceState);

        mBinding.activityMapMapView.getMapAsync(mOnMapReadyCallback);

        mBinding.activityMapButton.setOnClickListener(mOnAddMarkerClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.activityMapMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.activityMapMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.activityMapMapView.onDestroy();
    }

    private View.OnClickListener mOnAddMarkerClickListener = view -> {
        if (mGoogleMap != null) {
            LatLng position = mGoogleMap.getCameraPosition().target;
            mGoogleMap.addMarker(new MarkerOptions()
                    .position(position)
                    .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmap(mBinding.activityMapEditText.getText().toString()))));
        }
    };

    private OnMapReadyCallback mOnMapReadyCallback = googleMap -> mGoogleMap = googleMap;

    @Override
    protected void setBinding(ViewDataBinding binding) {
        mBinding = (ActivityMapBinding) binding;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_map;
    }

    private Bitmap getMarkerBitmap(String text) {
        return BitmapInflater.createBitmapFromSettings(ViewSettings.newSettings()
                .setContext(this)
                .setLayoutRes(R.layout.custom_marker)
                .setCallbacks(new ViewSettings.Callbacks() {
                    @Override
                    public void configView(View v) {
                        TextView textView = v.findViewById(R.id.custom_marker_text_view);
                        textView.setText(text);
                    }

                    @Override
                    public void measureView(int[] size) {

                    }
                }));
    }
}
