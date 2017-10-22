package com.dubhacks.maycontain;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.List;
import java.util.Locale;

public class PlaceInfoActivity extends AppCompatActivity {
    private String api_key = "AIzaSyCHSmgCI0fQE2Trb0Tu5pm7aQgbcL6Tzrw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);
        final String searchTerm = getIntent().getStringExtra("placeName");
    }
}
