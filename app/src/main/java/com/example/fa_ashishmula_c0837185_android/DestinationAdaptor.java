package com.example.fa_ashishmula_c0837185_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DestinationAdaptor extends ArrayAdapter {
    Context mContext;
    int layoutRes;
    List<Destinations> places;
    DBHelper mDatabase;

    public DestinationAdaptor(Context mContext, int layoutRes, List<Destinations> places, DBHelper mDatabase) {
        super(mContext, layoutRes, places);
        this.mContext = mContext;
        this.layoutRes = layoutRes;
        this.places = places;
        this.mDatabase = mDatabase;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        TextView tvaddress = v.findViewById(R.id.txtAddress);
        TextView tvlat = v.findViewById(R.id.txtLat);
        TextView tvlng = v.findViewById(R.id.txtLong);
        TextView tvDate = v.findViewById(R.id.txtDate);

        final Destinations fav_place = places.get(position);
        tvaddress.setText(fav_place.getAddress());
        tvlat.setText(String.valueOf(fav_place.getLatitude()));
        tvlng.setText(String.valueOf(fav_place.getLongitude()));
        tvDate.setText(fav_place.getDate());
        return v;

    }
}