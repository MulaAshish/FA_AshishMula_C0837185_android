package com.example.fa_ashishmula_c0837185_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    DBHelper mDB;
    List<Destinations>destinations;
    ListView placesList;
    DestinationAdaptor destinationAdaptor;


com.google.android.material.floatingactionbutton.FloatingActionButton addPlace;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placesList=findViewById(R.id.lv_List);
        mDB=new DBHelper(this);
        destinations=new ArrayList<>();
        displayFavDestinations();
        addPlace=findViewById(R.id.addPlace);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);

            }
        });
    }

    private void displayFavDestinations() {
        Cursor cursor = mDB.getAllPlaces();
        if(cursor.moveToFirst()){
            do {
                destinations.add(new Destinations(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3),
                        cursor.getString(4)
                ));


            }while (cursor.moveToNext());
            cursor.close();
            destinationAdaptor = new DestinationAdaptor(this, R.layout.list_layout_activity, destinations, mDB);
            placesList.setAdapter(destinationAdaptor);
        }
    }



}

