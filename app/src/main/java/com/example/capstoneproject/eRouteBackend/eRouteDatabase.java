package com.example.capstoneproject.eRouteBackend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class eRouteDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAMES = "jeepcode.db";
    private static final int DATABASE_VERSION = 1;

    public eRouteDatabase(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    public eRouteDatabase (Context context, String name, String storageDirectory, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, storageDirectory, factory, version);
    }
}