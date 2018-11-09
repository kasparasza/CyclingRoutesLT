package com.example.kasparasza.cyclingrouteslt;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class N03_A01_FullscreenMapImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_map_image);

        // getting size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        // hide action bar of the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Initializing root layout
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_view);

        // getting resource ID of an image / map to be displayed
        int mapImageForDisplay = (getIntent().getIntExtra("IMAGE_TO_SHOW", 0));

        // Initializing ImageView that will display map image
        ImageView zoomedMapImage = new ImageView(this);
        zoomedMapImage.setImageResource(mapImageForDisplay);

        // Inflating the root layout with a ScrollView and an ImageView  - a child of the ScrollView,
        // and setting an image to be displayed.
        // Case A: if screen orientation is portrait:
        if (display.getRotation() == Surface.ROTATION_0 || display.getRotation() == Surface.ROTATION_180) {
            HorizontalScrollView horizontalScroll = new HorizontalScrollView(this);
            rootLayout.addView(horizontalScroll);
            horizontalScroll.addView(zoomedMapImage);
            zoomedMapImage.getLayoutParams().height = screenHeight;
            zoomedMapImage.setAdjustViewBounds(true);
        }
        // Case B: if screen orientation is landscape:
        else {
            ScrollView verticalScroll = new ScrollView(this);
            rootLayout.addView(verticalScroll);
            verticalScroll.addView(zoomedMapImage);
            zoomedMapImage.getLayoutParams().width = screenWidth;
            zoomedMapImage.setAdjustViewBounds(true);
        }
    }
}
