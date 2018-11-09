package com.example.kasparasza.cyclingrouteslt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Creates custom FragmentPagerAdapter that manages the fragments used in FullscreenImage activity
 */

public class N03_Ad01_RouteImageFragmentPagerAdapter extends FragmentStatePagerAdapter {
    //Creates an instance of arrayList, which will be used by the the constructor
    private int[] imagesOfRoute;

    // The constructor has additional parameters that were passed to it by parent activity: integer Array
    public N03_Ad01_RouteImageFragmentPagerAdapter(FragmentManager fm, int[] mImagesOfRoute) {
        super(fm);
        imagesOfRoute = mImagesOfRoute;
    }

    //Dynamically creates Fragments each of which contain an image of the particular Route
    //These images are obtained from the integer Array and packed into Bundle
    @Override
    public Fragment getItem(int position) {
        Bundle bundleWithSelectedRouteImages = new Bundle();
        bundleWithSelectedRouteImages.putInt("KEY_ROUTE_IMAGE_ID", imagesOfRoute[position]);
        N03_F01_RouteImageFragment fragment = new N03_F01_RouteImageFragment();
        fragment.setArguments(bundleWithSelectedRouteImages);
        return fragment;
    }

    //Returns the total number of fragments
    @Override
    public int getCount() {
        return imagesOfRoute.length;
    }
}
