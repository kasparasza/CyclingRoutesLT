package com.example.kasparasza.cyclingrouteslt;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class N03_A02_FullscreenImageActivity extends AppCompatActivity {

    // an instance of an Array, which will be used to store data retrieved from other activity
    private int[] imagesOfRoute;
    // image that was clicked by the user
    private int selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the following layout file
        setContentView(R.layout.activity_fullscreen_image);

        // hide action bar of the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Retrieve data from the previous activity
        imagesOfRoute = getIntent().getIntArrayExtra("IMAGES_TO_SHOW");
        selectedImage = getIntent().getIntExtra("FIRST_IMAGE", 0);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_images_of_selected_route);

        // Set TabLayout for the view pager. TabLayout will indicate the position of the selected fragment
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

        // Create an adapter that knows which fragment(in this case an image) should be shown on each page
        N03_Ad01_RouteImageFragmentPagerAdapter adapter = new N03_Ad01_RouteImageFragmentPagerAdapter(getSupportFragmentManager(), imagesOfRoute);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Set the Fragment that will be opened first of all - it depends on an image selected by the user
        viewPager.setCurrentItem(selectedImage);
    }
}

