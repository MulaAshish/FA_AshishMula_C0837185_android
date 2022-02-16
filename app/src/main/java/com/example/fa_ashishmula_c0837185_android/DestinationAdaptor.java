package com.example.fa_ashishmula_c0837185_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DestinationAdaptor extends ArrayAdapter {
    private static final String TAG = "DestinationAdapter";
    Context mContext;
    int layoutRes;
    List<Destinations> places;
    DBHelper mDatabase;
    Destinations fav_place;

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

        fav_place = places.get(position);
        System.out.println("print" + fav_place.getAddress());
        tvaddress.setText(fav_place.getAddress());
        tvlat.setText(String.valueOf(fav_place.getLatitude()));
        tvlng.setText(String.valueOf(fav_place.getLongitude()));
        tvDate.setText(fav_place.getDate());
        v.findViewById(R.id.btnEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePlaces(fav_place);
            }

            private void updatePlaces(Destinations destinations) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                View view1 = layoutInflater.inflate(R.layout.update_places, null);
                builder.setView(view1);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                final EditText Address = view1.findViewById(R.id.edt_address);
                final EditText latitude = view1.findViewById(R.id.edt_lat);
                final EditText longitude = view1.findViewById(R.id.edt_long);
                final EditText Date = view1.findViewById(R.id.edt_date);


                Address.setText(destinations.getAddress());
                latitude.setText(String.valueOf(destinations.getLatitude()));
                longitude.setText(String.valueOf(destinations.getLongitude()));
                view1.findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String address = Address.getText().toString().trim();
                        String Latitude = latitude.getText().toString().trim();
                        String Longitude = longitude.getText().toString().trim();
                        String date = Date.getText().toString().trim();


                        if (address.isEmpty()) {
                            Address.setError("address name cannot be empty");
                            Address.requestFocus();
                            return;
                        }

                        if (Latitude.isEmpty()) {
                            latitude.setError("lat field cannot be empty");
                            latitude.requestFocus();
                            return;
                        }
                        if (Longitude.isEmpty()) {
                            longitude.setError("long field cannot be empty");
                            longitude.requestFocus();
                            return;
                        }
                        if (date.isEmpty()) {
                            Date.setError("date field cannot be empty");
                            Date.requestFocus();
                            return;
                        }
                        if (mDatabase.updatePlaces(destinations.getId(), address, Double.parseDouble(Latitude), Double.parseDouble(Longitude), date))

                            loadPlaces();
                        alertDialog.dismiss();
                    }

                });
            }
        });
        v.findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePlaces(fav_place);
            }

            private void deletePlaces(final Destinations destinations) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Are You Sure");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mDatabase.deletePlaces(destinations.getId()))
                            loadPlaces();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "The Places (" + destinations.getAddress() + ") is not deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        Log.d(TAG,"getView" + getCount());
        return v;



    }
    @Override
    public int getCount() {
        return places.size();

    }

    private void loadPlaces() {
        Cursor cursor = mDatabase.getAllPlaces();
        fav_place.clear();
        if (cursor.moveToFirst()) {
            do {
                fav_place.add(new Destinations(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3),
                        cursor.getString(4)
                ));
            } while (cursor.moveToNext());
            cursor.close();
        }
        notifyDataSetChanged();
    }
}


