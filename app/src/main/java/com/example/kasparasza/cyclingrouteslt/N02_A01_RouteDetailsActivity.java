package com.example.kasparasza.cyclingrouteslt;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import java.util.ArrayList;

public class N02_A01_RouteDetailsActivity extends AppCompatActivity {

    //an instance of arrayList, which will be used to store data retrieved from other activity
    private ArrayList<Route> routesList;
    //variable that stores the number ID of the route selected by the user
    private int selectedRouteNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the following layout file
        setContentView(R.layout.activity_route_detailed_view);

        // Retrieves data from the previous activity
        selectedRouteNumber = getIntent().getIntExtra("SELECTED_ROUTE_NUMBER", 0);
        routesList = getIntent().getParcelableArrayListExtra("ROUTES_LIST");

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_route_in_selected_region);

        // Create an adapter that knows which fragment should be shown on each page
        N02_Ad01_RouteFragmentPagerAdapter adapter = new N02_Ad01_RouteFragmentPagerAdapter(getSupportFragmentManager(), routesList);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Set the Fragment that will be opened first of all - it depends on the route selected by the user
        viewPager.setCurrentItem(selectedRouteNumber);
    }
}
