package com.example.capstoneproject.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.capstoneproject.R;
import com.example.capstoneproject.model.Activities;

public class ActivitiesActivity_Fragment extends Fragment {
    /* Class Constants */
    private static final String ARG_ATTRACTION = "attraction";

    @SuppressWarnings("FieldCanBeLocal")
    private Button showInMapButton;
    private Activities activities;

    public static ActivitiesActivity_Fragment newInstance(Activities activities) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ATTRACTION, activities);

        ActivitiesActivity_Fragment fragment = new ActivitiesActivity_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activities = getArguments() != null ? (Activities) getArguments().getParcelable(ARG_ATTRACTION) :null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.capstone_activities_activity_fragment_detail, container, false);

        // Grab a handle on the image view
        ImageView detailImageView = view.findViewById(R.id.detail_image_view);
        detailImageView.setImageResource(activities.getImageResourceId());

        // grab a handle on the text view
        TextView textView = view.findViewById(R.id.detail_long_desc_tv);
        textView.setText(activities.getLongDesc());

        showInMapButton = view.findViewById(R.id.detail_show_in_map_button);
        showInMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse(getString(activities.getMapQueryStrId()));
                showMap(location);
            }
        });

        return view;
    }

    @SuppressWarnings("ConstantConditions")
    public void showMap(Uri geoLocation) {
        // Initialize the map intent with an action and the geolocation parameter
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);

        // Make the intent explicit by setting Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent w/o crashing the app
        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
