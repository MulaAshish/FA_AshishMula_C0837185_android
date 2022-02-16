package com.example.fa_ashishmula_c0837185_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Destinations implements List<Destinations> {
    private int id;
    private String address;
    private Double Latitude, Longitude;
    private String date;

    public Destinations(int id, String address, Double latitude, Double longitude, String date) {
        this.id = id;
        this.address = address;
        Latitude = latitude;
        Longitude = longitude;
        this.date = date;
    }

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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<Destinations> iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] ts) {
        return null;
    }

    @Override
    public boolean add(Destinations destinations) {
        return false;
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends Destinations> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends Destinations> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Destinations get(int i) {
        return null;
    }

    @Override
    public Destinations set(int i, Destinations destinations) {
        return null;
    }

    @Override
    public void add(int i, Destinations destinations) {

    }

    @Override
    public Destinations remove(int i) {
        return null;
    }

    @Override
    public int indexOf(@Nullable Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<Destinations> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<Destinations> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<Destinations> subList(int i, int i1) {
        return null;
    }
}