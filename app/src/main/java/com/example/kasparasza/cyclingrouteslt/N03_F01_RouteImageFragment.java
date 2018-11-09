package com.example.kasparasza.cyclingrouteslt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class N03_F01_RouteImageFragment extends Fragment {


    public N03_F01_RouteImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initializes root view to be used by the fragment
        View rootView = inflater.inflate(R.layout.route_image_full_screen, container, false);

        // Initializes ImageView to be inflated
        ImageView my_image = (ImageView) rootView.findViewById(R.id.image_full_screen);

        // Sets image resource to the ImageView
        final int imageToDisplay = getArguments().getInt("KEY_ROUTE_IMAGE_ID", 0);
        my_image.setImageResource(imageToDisplay);

        return rootView;
    }
}
