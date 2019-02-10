package cebucityguide.capstoneproject.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Activities implements Parcelable {

    public static final Creator<Activities> CREATOR = new Creator<Activities>() {
        @Override
        public Activities createFromParcel(Parcel in) {
            return new Activities(in);
        }

        @Override
        public Activities[] newArray(int size) {
            return new Activities[size];
        }
    };
    /** Image resource ID for the image file associated with the attraction */
    private int imageResourceId;
    /** Title of the attraction */
    private int titleTextResId;
    /** Brief description of the attraction */
    private int shortDescTextResId;
    /** Long description of the attraction */
    private int longDescTextResId;
    /** Map Query String of attraction */
    private int mapQueryStrId;

    /**
     * Create data object that holds all the details of an attraction including an image resource
     * for the attraction
     *
     * @param imageResourceId    an integer value for the image resource ID
     * @param titleTextResId     a String value for the name of the attraction
     * @param shortDescTextResId a String value for a brief description of the attraction
     */
    public Activities(int imageResourceId, int titleTextResId, int shortDescTextResId,
                      int longDescTextResId, int mapQueryStrId) {
        this.imageResourceId = imageResourceId;
        this.titleTextResId = titleTextResId;
        this.shortDescTextResId = shortDescTextResId;
        this.longDescTextResId = longDescTextResId;
        this.mapQueryStrId = mapQueryStrId;
    }

    protected Activities(Parcel in) {
        imageResourceId = in.readInt();
        titleTextResId = in.readInt();
        shortDescTextResId = in.readInt();
        longDescTextResId = in.readInt();
        mapQueryStrId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageResourceId);
        dest.writeInt(this.titleTextResId);
        dest.writeInt(this.shortDescTextResId);
        dest.writeInt(this.longDescTextResId);
        dest.writeInt(this.mapQueryStrId);
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getTitle() {
        return titleTextResId;
    }

    public int getShortDesc() {
        return shortDescTextResId;
    }

    public int getLongDesc() {
        return longDescTextResId;
    }

    public int getMapQueryStrId() {
        return mapQueryStrId;
    }
}
