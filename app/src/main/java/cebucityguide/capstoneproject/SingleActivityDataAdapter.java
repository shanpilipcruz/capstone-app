package cebucityguide.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cebucityguide.capstoneproject.model.Activities;

public class SingleActivityDataAdapter
        extends RecyclerView.Adapter<SingleActivityDataAdapter.SingleActivityViewHolder> {

    public static final int CARD_SIZE_IMAGE_DECODE = 333;
    private List<Activities> mActivities;
    private Context mContext;
    private LruCache<String, Bitmap> memoryCache;

    /**
     * Create the adapter for a single Attraction class object
     *
     * @param context     to get a handle on the application's environment
     * @param attractions an ArrayList of Attractions
     */
    public SingleActivityDataAdapter(Context context, List<Activities> attractions) {
        this.mActivities = attractions;
        this.mContext = context;

        final int totalMemory = (int) (Runtime.getRuntime().totalMemory() / 1024);
        final int cacheSize = totalMemory / 5;

        memoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    /**
     * This method is called when a new RecyclerView.ViewHolder is required by the
     * recycler view to display an Attraction item
     *
     * @param parent   the primary ViewGroup for the application
     * @param viewType a boolean value indicating whether the inflated view is to be attached
     *                 to the root view
     * @return the SingleAttractionViewHolder that has a backing inflated layout
     */
    @NonNull
    @Override
    public SingleActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.capstone_activities_activity_activity_card, parent, false);
        return new SingleActivityViewHolder(view);
    }

    /**
     * This method is responsible for mapping data to the item that is being currently displayed to
     * the user
     *
     * @param holder   the SingleAttractionViewHolder with the inflated custom layout to
     *                 display the Attraction object item
     * @param position the position of the item in the recycler view that is being viewed by the
     *                 user
     */
    @Override
    public void onBindViewHolder(@NonNull SingleActivityViewHolder holder, int position) {

        final Activities attraction = mActivities.get(position);

        // Set the image file to be displayed for the attraction
        // Load scaled down version of image file into memory
        String imageKey = String.valueOf(attraction.getImageResourceId());
        if (getBitmapFromMemCache(imageKey) != null) {
            // exists in cache
            holder.attractionImage.setImageBitmap(getBitmapFromMemCache(imageKey));
        } else {
            // run down scaler task (add to cache within task)
            new DownscaleImagesTask(mContext.getResources(), memoryCache, holder)
                    .execute(attraction.getImageResourceId());
        }

        // Set the title of the attraction
        holder.attractionTitle.setText(attraction.getTitle());

        // Set the description of the attraction
        holder.attractionBriefDescription.setText(attraction.getShortDesc());

        // Setup and register OnClickListener to the CardView that is displaying the item
        holder.attractionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ActivitiesActivity.newIntent(mContext, attraction);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * Provides information to the adapter on how many items are present in the data set
     *
     * @return the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return mActivities == null ? 0 : mActivities.size();
    }

    private Bitmap getBitmapFromMemCache(String key) {
        return memoryCache.get(key);
    }

/**
 * Nested inner class that provides the adapter with cached expensive findViewById results
 * Basically, a custom RecyclerView.ViewHolder implementation to handle the complexity
 * of the item that is to be displayed by the RecyclerView
 */
static class SingleActivityViewHolder
        extends RecyclerView.ViewHolder {

    ImageView attractionImage;
    TextView attractionTitle;
    TextView attractionBriefDescription;
    CardView attractionCardView;

    /**
     * This is the method that handles caching of the findViewById results to avoid repeatedly
     * performing such expensive tasks
     *
     * @param itemView holds the ViewGroup information of the inflated view
     */
    SingleActivityViewHolder(View itemView) {
        super(itemView);

        attractionCardView = itemView.findViewById(R.id.attraction_card_view);
        attractionImage = itemView.findViewById(R.id.attraction_image_view);
        attractionTitle = itemView.findViewById(R.id.attraction_title_text_view);
        attractionBriefDescription = itemView.findViewById(R.id.attraction_brief_desc_text_view);
    }
}

static class DownscaleImagesTask extends AsyncTask<Integer, Void, Bitmap> {

    private Resources resources;
    private SingleActivityViewHolder imageViewHolder;
    private LruCache<String, Bitmap> memoryCache;

    DownscaleImagesTask(Resources resources, LruCache<String, Bitmap> memoryCache,
                        SingleActivityViewHolder imageViewHolder) {
        super();
        this.resources = resources;
        this.imageViewHolder = imageViewHolder;
        this.memoryCache = memoryCache;
    }

    @Override
    protected Bitmap doInBackground(Integer... imageResId) {
        Bitmap bitmap = ScaledImages.decodeSampledBitmapFromResource(
                resources,
                imageResId[0],
                CARD_SIZE_IMAGE_DECODE
        );
        memoryCache.put(imageResId[0].toString(), bitmap);

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageViewHolder.attractionImage.setImageBitmap(bitmap);
    }
}
}
