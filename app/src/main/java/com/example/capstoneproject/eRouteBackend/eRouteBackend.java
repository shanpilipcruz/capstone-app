package com.example.capstoneproject.eRouteBackend;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class eRouteBackend extends eRouteDBObject {

    public eRouteBackend(Context context) {
        super(context);
    }

    public String[] getAllSpinnerContent(){

        String query = "Select * from eroute";
        Cursor c = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if(c.moveToFirst()){
            do{
                String word = c.getString(c.getColumnIndexOrThrow("location"));
                spinnerContent.add(word);
            }while(c.moveToNext());
        }
        c.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }
}