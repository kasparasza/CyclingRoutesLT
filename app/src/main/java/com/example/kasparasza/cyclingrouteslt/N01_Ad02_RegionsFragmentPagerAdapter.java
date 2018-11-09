package com.example.kasparasza.cyclingrouteslt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Creates custom FragmentPagerAdapter that manages the fragments used in the initial activity
 */
public class N01_Ad02_RegionsFragmentPagerAdapter extends FragmentPagerAdapter {

    //String array that will store tab titles for the fragments
    private String tab_titles_regions [];

    // The constructor has additional parameters that were passed to it by parent activity: String array
    public N01_Ad02_RegionsFragmentPagerAdapter(FragmentManager fm, String[] mTab_titles) {
        super(fm);
        tab_titles_regions = mTab_titles;
    }

    //Sequence of the fragments from left to right
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new N01_F01_EasternLtuFragment();
        } else if (position == 1) {
            return new N01_F02_SouthernLtuFragment();
        } else if (position == 2) {
            return new N01_F03_WesternLtuFragment();
        } else {
            return new N01_F04_NorthernLtuFragment();
        }
    }

    //Returns the total number of fragments
    @Override
    public int getCount() {
        return 4;
    }

    //Links tab title to the respective fragments
    @Override
    public CharSequence getPageTitle(int position) {
        return tab_titles_regions[position];
    }
}
