package com.example.jasmn.pharmacy;

import android.support.annotation.NonNull;

public class pharmacy implements Comparable {
    String ph_name;

    String phone;
    int picture;
    double longtitude;
    double latitude;
    Float distance;

    public pharmacy(String ph_name, String phone, int picture, double latitude, double longtitude) {
        this.ph_name = ph_name;
        this.phone = phone;
        this.picture = picture;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getPh_name() {
        return ph_name;
    }

    public void setPh_name(String ph_name) {
        this.ph_name = ph_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Float distance1 = ((pharmacy) o).getDistance();

        return (int) (this.distance - distance1);
    }
}
