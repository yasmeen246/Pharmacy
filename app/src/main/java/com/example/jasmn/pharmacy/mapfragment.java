package com.example.jasmn.pharmacy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class mapfragment extends AppCompatActivity  {
       TextView time_;
        GoogleMap map;
        nearestph nearestph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapfragment);
//        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
//        mapFragment.getMapAsync(this);
//        nearestph=new nearestph();
//        double latitude = nearestph.latitude;
//        double longitude = nearestph.longitude;
//        Intent intent=new Intent();
//
//        String lat = intent.getStringExtra("lat");
//        String aLong = intent.getStringExtra("long");
//
//        String origin="origin="+latitude+","+longitude;
//        String distination="distination="+lat+","+aLong;
//        String url="https://maps.googleapis.com/maps/api/directions/json?"+origin+"&"+distination+"mode=walking";
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        map=googleMap;
    }
}
