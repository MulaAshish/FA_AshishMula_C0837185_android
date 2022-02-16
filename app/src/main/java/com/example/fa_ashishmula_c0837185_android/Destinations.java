package com.example.fa_ashishmula_c0837185_android;

public class Destinations {
    int id;
    String address;
    Double Latitude,Longitude;
    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Destinations(int id, String address, Double latitude, Double longitude, String date) {
        this.id = id;
        this.address = address;
        Latitude = latitude;
        Longitude = longitude;
        this.date = date;
    }
}
