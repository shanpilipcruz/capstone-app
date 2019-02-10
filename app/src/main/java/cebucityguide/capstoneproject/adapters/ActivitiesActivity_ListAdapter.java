package cebucityguide.capstoneproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cebucityguide.capstoneproject.ActivitiesActivity_PagerActivity;
import cebucityguide.capstoneproject.R;
import cebucityguide.capstoneproject.ScaledImages;
import cebucityguide.capstoneproject.model.Activities;

public class ActivitiesActivity_ListAdapter extends ArrayAdapter<Activities> {

    public static final int LIST_ITEM_IMAGE_DECODE = 444;
    private LayoutInflater mLayoutInflater;
    private List<Activities> mActivities;
    private int sectionTitle;

    /**
     * Create new collection adapter
     *
     * @param context     holds the {@link Context} of the {@link android.widget.ListView}
     * @param activities an {@link ArrayList} of {@link Activities} objects
     */
    public ActivitiesActivity_ListAdapter(@NonNull Context context, List<Activities> activities, int sectionTitle) {
        super(context, 0, activities);
        mActivities = new ArrayList<>();
        mActivities = activities;
        mLayoutInflater = LayoutInflater.from(context);
        this.sectionTitle = sectionTitle;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            // There are no views in the recycle pool
            // Inflate layout for first time view render
            convertView = mLayoutInflater.inflate(R.layout.capstone_discovery_list_item, parent, false);
        }

        // Get item currently viewed by user
        final Activities currentAttraction = mActivities.get(position);

        // Set the image of the attraction
        final ImageView imageContainer = convertView.findViewById(R.id.list_item_image);

        // Convert px to dips
        Resources resources = convertView.getResources();

        // Use scaled down version of image for the image set in {@link ListView} row
        imageContainer.setImageBitmap(ScaledImages.decodeSampledBitmapFromResource(
                resources,
                currentAttraction.getImageResourceId(),
                LIST_ITEM_IMAGE_DECODE
        ));

        // Set text for the title {@link TextView}
        TextView titleText = convertView.findViewById(R.id.list_item_title_text_view);
        titleText.setText(currentAttraction.getTitle());

        // Set text for the brief description {@link TextView}
        TextView descText = convertView.findViewById(R.id.list_item_brief_desc_text_view);
        descText.setText(currentAttraction.getShortDesc());

        // Set up the row in the {@link ListView} to respond to click(s)
        // Get a handle on the {@link RelativeLayout} that holds the attraction's data
        RelativeLayout listRow = convertView.findViewById(R.id.list_item_row);

        // Setup and register OnClickListener to navigate to the appropriate activity
        listRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitiesActivity_PagerActivity
                        .newIntent(getContext(), sectionTitle, currentAttraction.getTitle());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return mActivities == null ? 0 : mActivities.size();
    }
}
