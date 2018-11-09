package com.example.kasparasza.cyclingrouteslt;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class N01_A01_RegionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the following layout file
        setContentView(R.layout.activity_region);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_region);

        // Initialise names for the ViewPager tabs
        String tab_titles_regions [] = new String[]{getString(R.string.region_East), getString(R.string.region_South),
                getString(R.string.region_West), getString(R.string.region_North)};

        // Create an adapter that knows which fragment should be shown on each page
        N01_Ad02_RegionsFragmentPagerAdapter adapter = new N01_Ad02_RegionsFragmentPagerAdapter(getSupportFragmentManager(), tab_titles_regions);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_region);
        tabLayout.setupWithViewPager(viewPager);
    }
}
