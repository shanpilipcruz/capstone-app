package com.example.capstoneproject;

import android.content.Context;

public final class Utils {

    public static int resolveStringToResId(Context context, CharSequence text) {
        if (context.getString(R.string.top_activities).contentEquals(text)) return R.string.top_activities;
        else if (context.getString(R.string.top_bars_nightlife).contentEquals(text)) return R.string.top_bars_nightlife;
        else if (context.getString(R.string.top_places).contentEquals(text)) return R.string.top_places;
        else if (context.getString(R.string.top_restaurants).contentEquals(text)) return R.string.top_restaurants;
        else return 0;
    }
}
