package com.example.kasparasza.cyclingrouteslt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Creates custom FragmentPagerAdapter that manages the fragments used in RouteDetails activity
 */

public class N02_Ad01_RouteFragmentPagerAdapter extends FragmentStatePagerAdapter {
    //Creates an instance of arrayList, which will be used by the the constructor
    private ArrayList<Route> routesList;

    // The constructor has additional parameters that were passed to it by parent activity: ArrayList
    public N02_Ad01_RouteFragmentPagerAdapter(FragmentManager fm, ArrayList<Route> mRoutesList) {
        super(fm);
        routesList = mRoutesList;
    }

    //Dynamically creates Fragments which contain details of a particular Route
    //These details are obtained from the main ArrayList and packed into Bundle
    @Override
    public Fragment getItem(int position) {
        Route selectedRoute = routesList.get(position);
        Bundle bundleWithSelectedRoute = new Bundle();
        bundleWithSelectedRoute.putInt("KEY_ROUTE_NAME", selectedRoute.getRouteName());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_DISTANCE", selectedRoute.getDistance());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_START_END", selectedRoute.getStartEnd());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_IMAGE_ID_1", selectedRoute.getImageId_1());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_IMAGE_ID_2", selectedRoute.getImageId_2());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_IMAGE_ID_3", selectedRoute.getImageId_3());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_IMAGE_ID_4", selectedRoute.getImageId_4());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_DIFFICULTY", selectedRoute.getDifficulty());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_DESCRIPTION", selectedRoute.getDescription());
        bundleWithSelectedRoute.putString("KEY_ROUTE_MAP_LINK", selectedRoute.getMapLink());
        bundleWithSelectedRoute.putInt("KEY_ROUTE_MAP_IMAGE_ID", selectedRoute.getMapImageId());
        N02_F01_DetailedRouteInfoFragment fragment = new N02_F01_DetailedRouteInfoFragment();
        fragment.setArguments(bundleWithSelectedRoute);
        return fragment;
    }

    //Returns the total number of fragments
    @Override
    public int getCount() {
        return routesList.size();
    }

}
