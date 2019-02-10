package cebucityguide.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import cebucityguide.capstoneproject.fragments.ActivitiesActivity_Fragment;
import cebucityguide.capstoneproject.model.Activities;

public class ActivitiesActivity extends SingleActivity {
    /* Class Constants  Papalitan din d2 sa part na to*/
    private static final String EXTRA_ATTRACTION = "inducesmile.com.androiddictionaryapplication.attraction";

    public static Intent newIntent(Context packageContext, Activities activities) {
        Intent intent = new Intent(packageContext, ActivitiesActivity.class);
        intent.putExtra(EXTRA_ATTRACTION, activities);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Activities activities = getIntent().getParcelableExtra(EXTRA_ATTRACTION);
        return ActivitiesActivity_Fragment.newInstance(activities);
    }
}
