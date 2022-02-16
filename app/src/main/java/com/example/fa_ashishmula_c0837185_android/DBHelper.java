package com.example.fa_ashishmula_c0837185_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PlacesDatabase";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_NAME = "FavoritePlaces";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_DATE = "date";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID +" INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT," +
                COLUMN_ADDRESS + " varchar(200) NOT NULL," +
                COLUMN_LONGITUDE + " varchar(200) NOT NULL," +
                COLUMN_LATITUDE + " varchar(200) NOT NULL," +
                COLUMN_DATE + " double NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);


    }

    boolean addFavPlace(String address, double latitude , double longitude ,String date){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADDRESS, address);
        cv.put(String.valueOf(COLUMN_LATITUDE), latitude);
        cv.put(String.valueOf(COLUMN_LONGITUDE), longitude);
        cv.put(COLUMN_DATE, date);

        return   sqLiteDatabase.insert(TABLE_NAME, null, cv) != -1;
    }

    Cursor getAllPlaces(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    boolean updatePlaces(int id,String address,double latitude , double longitude,String date){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADDRESS, address);
        cv.put(String.valueOf(COLUMN_LATITUDE), latitude);
        cv.put(String.valueOf(COLUMN_LONGITUDE), longitude);
        cv.put(COLUMN_DATE, date);
        return sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;

    }
    boolean deletePlaces(int id){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();

        return sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID +"=?", new String[]{String.valueOf(id)}) > 0;
    }
}
