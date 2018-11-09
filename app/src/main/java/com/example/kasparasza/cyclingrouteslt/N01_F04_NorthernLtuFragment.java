package com.example.kasparasza.cyclingrouteslt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.kasparasza.cyclingrouteslt.utilities.AppUtilities;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class N01_F04_NorthernLtuFragment extends Fragment {


    public N01_F04_NorthernLtuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Initializes root view to be used by the fragment:
        View rootView = inflater.inflate(R.layout.routes_in_region, container, false);

        //Creates an arrayList of data points with details about each route in the region
        final ArrayList<Route> routesList = new ArrayList<Route>();
        routesList.add(new Route(R.string.north_r01_name, R.string.north_r01_distance, R.string.north_r01_start_end, R.drawable.n01_image_01,
                R.drawable.n01_image_02, R.drawable.n01_image_03, R.drawable.n01_image_04,
                R.string.north_r01_difficulty, R.string.north_r01_full_description, URL_resources.NORTH_R01_MAP_URL, R.drawable.n01_map));
        routesList.add(new Route(R.string.north_r02_name, R.string.north_r02_distance, R.string.north_r02_start_end, R.drawable.n02_image_01,
                R.drawable.n02_image_02, R.drawable.n02_image_03, R.drawable.n02_image_04,
                R.string.north_r02_difficulty, R.string.north_r02_full_description, URL_resources.NORTH_R02_MAP_URL, R.drawable.n02_map));
        routesList.add(new Route(R.string.north_r03_name, R.string.north_r03_distance, R.string.north_r03_start_end, R.drawable.n03_image_01,
                R.drawable.n03_image_02, R.drawable.n03_image_03, R.drawable.n03_image_04,
                R.string.north_r03_difficulty, R.string.north_r03_full_description, URL_resources.NORTH_R03_MAP_URL, R.drawable.n03_map));
        routesList.add(new Route(R.string.north_r04_name, R.string.north_r04_distance, R.string.north_r04_start_end, R.drawable.n04_image_01,
                R.drawable.n04_image_02, R.drawable.n04_image_03, R.drawable.n04_image_04,
                R.string.north_r04_difficulty, R.string.north_r04_full_description, URL_resources.NORTH_R04_MAP_URL, R.drawable.n04_map));
        routesList.add(new Route(R.string.north_r05_name, R.string.north_r05_distance, R.string.north_r05_start_end, R.drawable.n05_image_01,
                R.drawable.n05_image_02, R.drawable.n05_image_03, R.drawable.n05_image_04,
                R.string.north_r05_difficulty, R.string.north_r05_full_description, URL_resources.NORTH_R05_MAP_URL, R.drawable.n05_map));
        routesList.add(new Route(R.string.north_r06_name, R.string.north_r06_distance, R.string.north_r06_start_end, R.drawable.n06_image_01,
                R.drawable.n06_image_02, R.drawable.n06_image_03, R.drawable.n06_image_04,
                R.string.north_r06_difficulty, R.string.north_r06_full_description, URL_resources.NORTH_R06_MAP_URL, R.drawable.n06_map));
        routesList.add(new Route(R.string.north_r07_name, R.string.north_r07_distance, R.string.north_r07_start_end, R.drawable.n07_image_01,
                R.drawable.n07_image_02, R.drawable.n07_image_03, R.drawable.n07_image_04,
                R.string.north_r07_difficulty, R.string.north_r07_full_description, URL_resources.NORTH_R07_MAP_URL, R.drawable.n07_map));
        routesList.add(new Route(R.string.north_r08_name, R.string.north_r08_distance, R.string.north_r08_start_end, R.drawable.n08_image_01,
                R.drawable.n08_image_02, R.drawable.n08_image_03, R.drawable.n08_image_04,
                R.string.north_r08_difficulty, R.string.north_r08_full_description, URL_resources.NORTH_R08_MAP_URL, R.drawable.n08_map));

        //Initializes a GridView and creates an Adapter for it:
        //(this GridView will be used to inflate the fragment)
        //(the adapter will populate child items of this GridView)
        N01_Ad01_RoutesAdapter itemsAdapter = new N01_Ad01_RoutesAdapter(getActivity(), routesList);
        GridView gridView = (GridView) rootView.findViewById(R.id.routes_grid_list);
        gridView.setAdapter(itemsAdapter);

        // set column width for the gridView
        int columnWidth = AppUtilities.calculateColumnWidth(this.getContext());
        gridView.setColumnWidth(columnWidth);

        //sets layout parameters for the child views of the GridView
        gridView.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);

        //sets ClickListener for each List Item:
        //click action starts a new activity, where each route is displayed in detail
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Route route = routesList.get(position);

                //Creates an intent and passes ouArrayList to the new activity
                Intent openRouteDetails = new Intent(getActivity(), N02_A01_RouteDetailsActivity.class);
                openRouteDetails.putExtra("SELECTED_ROUTE_NUMBER", position);
                openRouteDetails.putParcelableArrayListExtra("ROUTES_LIST", routesList);
                startActivity(openRouteDetails);
            }
        });

        //Returns root view which is populated with child items:
        return rootView;
    }

}
