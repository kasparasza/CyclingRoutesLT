package com.example.kasparasza.cyclingrouteslt;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Creates a class which stores data about a route.
 */
public class Route implements Parcelable {

    //Variables of the class:

    //Name of the route
    private int mRouteName;

    //Distance of the route
    private int mDistance;

    //Start and end points of the route
    private int mStartEnd;

    //PhotoImage ID's of the route
    private int mImageId_1;
    private int mImageId_2;
    private int mImageId_3;
    private int mImageId_4;

    //Difficulty level the route
    private int mDifficulty;

    //Detailed description of the route
    private int mDescription;

    //Link to map resource
    private String mMapLink;

    //MapImage ID of the route
    private int mMapImageId;


    //Class constructor:
    public Route (int routeName, int distance, int startEnd, int imageId_1, int imageId_2, int imageId_3, int imageId_4, int difficulty, int description, String mapLink, int mapImageId){
        this.mRouteName = routeName;
        this.mDistance = distance;
        this.mStartEnd = startEnd;
        this.mImageId_1 = imageId_1;
        this.mImageId_2 = imageId_2;
        this.mImageId_3 = imageId_3;
        this.mImageId_4 = imageId_4;
        this.mDifficulty = difficulty;
        this.mDescription = description;
        this.mMapLink = mapLink;
        this.mMapImageId = mapImageId;
    }

    //Class getter methods:
    public int getRouteName() {
        return mRouteName;
    }

    public int getDistance() {
        return mDistance;
    }

    public int getStartEnd() {
        return mStartEnd;
    }

    public int getImageId_1() {
        return mImageId_1;
    }

    public int getImageId_2() {
        return mImageId_2;
    }

    public int getImageId_3() {
        return mImageId_3;
    }

    public int getImageId_4() {
        return mImageId_4;
    }

    public int getDifficulty() {
        return mDifficulty;
    }

    public int getDescription() {
        return mDescription;
    }

    public String getMapLink() {
        return mMapLink;
    }

    public int getMapImageId() {
        return mMapImageId;
    }


    // <----------------------- remember to properly explain parcel methods ------------------

    // The following methods that are required for using Parcelable
    private Route(Parcel in) {
        // The order must match the order in writeToParcel()
        mRouteName = in.readInt();
        mDistance = in.readInt();
        mStartEnd = in.readInt();
        mImageId_1= in.readInt();
        mImageId_2= in.readInt();
        mImageId_3= in.readInt();
        mImageId_4= in.readInt();
        mDifficulty = in.readInt();
        mDescription = in.readInt();
        mMapLink = in.readString();
        mMapImageId = in.readInt();
   }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mRouteName);
        out.writeInt(mDistance);
        out.writeInt(mStartEnd);
        out.writeInt(mImageId_1);
        out.writeInt(mImageId_2);
        out.writeInt(mImageId_3);
        out.writeInt(mImageId_4);
        out.writeInt(mDifficulty);
        out.writeInt(mDescription);
        out.writeString(mMapLink);
        out.writeInt(mMapImageId);
    }

    // Just cut and paste this for now
    public int describeContents() {
        return 0;
    }

    // Just cut and paste this for now
    public static final Parcelable.Creator<Route> CREATOR = new Parcelable.Creator<Route>() {
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        public Route[] newArray(int size) {
            return new Route[size];
        }
    };
}
