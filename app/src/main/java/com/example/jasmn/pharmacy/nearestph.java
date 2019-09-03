package com.example.jasmn.pharmacy;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class nearestph extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
      double latitude,longitude;
    pharmacy p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8;
    ArrayList<pharmacy> pharmacies=new ArrayList<>();
    ArrayList<pharmacy>newlist=new ArrayList<>();
    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearestph);
        recyclerView=findViewById(R.id.recyclerView);
        p_1=new pharmacy("صيدلية المنوفية","048 2223203",R.mipmap.meno,30.558322, 31.010482);
        p_2=new pharmacy("صيدليات الاجزاخانه","64 جمال عبد الناصر، قسم شبين الكوم، شبين الكوم، المنوفية",R.mipmap.ag, 30.560001, 31.010536);
        p_3=new pharmacy("صيدليات علام","048 2232562",R.mipmap.dd , 30.563969, 31.004509);
        p_4=new pharmacy("El Ezaby Pharmacy","048 2328954",R.mipmap.ezapy, 30.559883, 31.008066);
        p_5=new pharmacy("صيدلية الاندلس","048 2238211",R.mipmap.dd, 30.552943, 31.004337);
        p_6=new pharmacy("صيدلية النصر","048 2220413",R.mipmap.dd, 30.555032, 31.003081);
        p_7=new pharmacy("صيدلية الشيخ","جمال عبد الناصر، قسم شبين الكوم، شبين الكوم، المنوفية",R.mipmap.dd, 30.559154, 31.010098);
        p_8=new pharmacy("Agglan Pharmacy","البتانون، شبين الكوم، المنوفية",R.mipmap.dd,  30.615146, 30.986998);

        Collections.addAll(pharmacies,p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8);


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] perm={Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this,perm,1);
        }
        else{
            locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED ){
            try {
                locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        else{
            finish();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        try {

            Location location1=new Location(LocationManager.GPS_PROVIDER);
            Iterator<pharmacy> iterator = pharmacies.iterator();
            while (iterator.hasNext()){
                pharmacy next = iterator.next();
                location1.setLongitude(next.getLongtitude());
                location1.setLatitude(next.getLatitude());
                float distance = location.distanceTo(location1);
                next.setDistance(distance/100);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(pharmacies);
        adapter=new Adapter(pharmacies,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

}
