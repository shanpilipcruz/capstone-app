package cebucityguide.capstoneproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cebucityguide.capstoneproject.adapters.MasterAdapter;
import cebucityguide.capstoneproject.model.ActivitiesCollection;
import cebucityguide.capstoneproject.model.ActivitiesRepository;

public class ActivitiesActivity_Main extends HomeActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.capstone_activities_activity_navigation, frameLayout);
        setTitle("Discover");

        // Initialize list to store collection of attractions
        ActivitiesRepository repository = ActivitiesRepository.getInstance(this);
        List<ActivitiesCollection> collections = repository.getCollections();

        // Hook the recycler view
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

        // Set fixed size true and optimize recycler view performance
        // The data container has fixed number of attractions and not infinite list
        recyclerView.setHasFixedSize(true);

        // Connect the RecyclerView widget to the vertical linear layout
        // (not reverse layout - hence false)
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        // Attach adapter to the RecyclerView widget which is connected to a layout manager
        MasterAdapter collectionAdapter = new MasterAdapter(this, collections);
        recyclerView.setAdapter(collectionAdapter);
    }
}
