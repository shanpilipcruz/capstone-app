package com.example.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.capstoneproject.fragments.ActivitiesActivity_ListFragment;

public class ActivitiesActivity_ListActivity extends AppCompatActivity {
    private static final String EXTRA_SECTION_TITLE = "om.example.android.tourfc.attraction_type";

    public static Intent newIntent(Context packageContext, int sectionTitle) {
        Intent intent = new Intent(packageContext, ActivitiesActivity_ListActivity.class);
        intent.putExtra(EXTRA_SECTION_TITLE, sectionTitle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_activities_activity_fragment);
        int attractionType = getIntent().getIntExtra(EXTRA_SECTION_TITLE, 0);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = ActivitiesActivity_ListFragment.newInstance(attractionType);
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}