package com.example.capstoneproject.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.capstoneproject.R;
import com.example.capstoneproject.adapters.ActivitiesActivity_ListAdapter;
import com.example.capstoneproject.model.Activities;
import com.example.capstoneproject.model.ActivitiesRepository;

import java.util.List;

public class ActivitiesActivity_ListFragment extends Fragment {
    /* Class Constants */
    private static final String ARG_SECTION_TITLE = "sectionTitle";

    /* Class variables */
    private int sectionTitle;
    private ListView attractionListView;
    private ActivitiesActivity_ListAdapter listViewAdapter;

    public static ActivitiesActivity_ListFragment newInstance(int sectionTitle) {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_TITLE, sectionTitle);

        ActivitiesActivity_ListFragment fragment = new ActivitiesActivity_ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null) {
            sectionTitle = getArguments().getInt(ARG_SECTION_TITLE);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.capstone_activities_activity_show_all_views, container, false);

        ActivitiesRepository repository = ActivitiesRepository.getInstance(getActivity());
        List<Activities> attractions = repository.getCollection(sectionTitle).getAttractions();

        attractionListView = v.findViewById(R.id.show_all_list_view);
        listViewAdapter = new ActivitiesActivity_ListAdapter(getActivity(), attractions, sectionTitle);
        attractionListView.setAdapter(listViewAdapter);

        return v;
    }
}