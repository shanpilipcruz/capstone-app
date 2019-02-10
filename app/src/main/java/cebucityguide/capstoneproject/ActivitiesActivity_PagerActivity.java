package cebucityguide.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import cebucityguide.capstoneproject.fragments.ActivitiesActivity_Fragment;
import cebucityguide.capstoneproject.model.Activities;
import cebucityguide.capstoneproject.model.ActivitiesCollection;
import cebucityguide.capstoneproject.model.ActivitiesRepository;

public class ActivitiesActivity_PagerActivity extends AppCompatActivity {
    /* Class Constants */
    private static final String EXTRA_SECTION_TITLE = "com.finalproject.android.tourfc.section_title";
    private static final String EXTRA_ATTRACTION_TITLE = "com.finalproject.android.tourfc.attraction_title";
    /* Class variables */
    private ViewPager viewPager;
    private List<Activities> activities;
    private int sectionTitle;

    public static Intent newIntent(Context packageContext, int sectionTitle, int attractionTitle) {
        Intent intent = new Intent(packageContext, ActivitiesActivity_PagerActivity.class);
        intent.putExtra(EXTRA_SECTION_TITLE, sectionTitle);
        intent.putExtra(EXTRA_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_activities_activity_activities_pager);

        sectionTitle = getIntent().getIntExtra(EXTRA_SECTION_TITLE, 0);
        if (sectionTitle == 0) {
            throw new IllegalArgumentException("AttractionListAdapter has not reported on section title");
        } else {
            List<ActivitiesCollection> collections = ActivitiesRepository.getInstance(this).getCollections();
            for (ActivitiesCollection collection : collections) {
                if (collection.getHeaderTitle() == sectionTitle) {
                    activities = collection.getAttractions();
                    break;
                }
            }
        }

        int attractionTitle = getIntent().getIntExtra(EXTRA_ATTRACTION_TITLE, 0);
        if (attractionTitle == 0) {
            throw new IllegalArgumentException("AttractionListAdapter has not reported on attraction title");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager = findViewById(R.id.attraction_view_pager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public int getCount() {
                return activities.size();
            }

            @Override
            public Fragment getItem(int position) {
                Activities attraction = activities.get(position);
                return ActivitiesActivity_Fragment.newInstance(attraction);
            }
        });

        for (int i = 0; i < activities.size(); i++) {
            if (attractionTitle == activities.get(i).getTitle()) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
