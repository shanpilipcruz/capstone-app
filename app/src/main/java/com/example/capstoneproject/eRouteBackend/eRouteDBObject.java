package com.example.capstoneproject.eRouteBackend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class eRouteDBObject {

    private static eRouteDatabase dbHelper;
    private SQLiteDatabase db;

    public eRouteDBObject(Context context) {
        dbHelper = new eRouteDatabase(context);
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection() {
        return this.db;
    }

    public void closeDbConnection() {
        if (this.db != null) {
            this.db.close();
        }
    }
}
