package com.example.kasparasza.cyclingrouteslt;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom adapter that shall be used to populate GridView with Route objects.
 */

public class N01_Ad01_RoutesAdapter extends ArrayAdapter<Route> {

    //Class constructor #1:
    public N01_Ad01_RoutesAdapter(Activity context, ArrayList<Route> routes) {
        super(context, 0, routes);
    }

    /**
     * Method for picking Views from the ArrayList and reusing them when needed:
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridViewItem = convertView;

        //Inflates a new gridViewItem in case there are no reusable views in stack
        if (gridViewItem == null) {
            gridViewItem = LayoutInflater.from(getContext()).inflate(R.layout.routes_in_region_item, parent, false);
        }

        //Initialises a particular item from the ArrayList
        Route currentRoute = getItem(position);

        //Assign TextViews for this particular item
        TextView routeName = (TextView) gridViewItem.findViewById(R.id.route_text_name);
        routeName.setText(currentRoute.getRouteName());
        TextView routeDistance = (TextView) gridViewItem.findViewById(R.id.route_text_distance);
        routeDistance.setText(currentRoute.getDistance());
        TextView routeStartEnd = (TextView) gridViewItem.findViewById(R.id.route_text_start_end);
        routeStartEnd.setText(currentRoute.getStartEnd());

        //Assign ImageViews for this particular item
        //Main image of the route:
        ImageView routeImage = (ImageView) gridViewItem.findViewById(R.id.route_thumb_image_1);
        routeImage.setImageResource(currentRoute.getImageId_1());

        //Difficulty icon the route:
        ImageView routeDifficultyIc = (ImageView) gridViewItem.findViewById(R.id.route_difficulty_icon);
        String difficulty = getContext().getString(currentRoute.getDifficulty());
        if (difficulty.equals("1")) {
            routeDifficultyIc.setImageResource(R.drawable.ic_difficulty_one);
        } else if (difficulty.equals("2")) {
            routeDifficultyIc.setImageResource(R.drawable.ic_difficulty_two);
        } else {
            routeDifficultyIc.setImageResource(R.drawable.ic_difficulty_three);
        }

        //Closing return statement - returns inflated view item with data points attached to it
        return gridViewItem;
    }
}
