package com.example.kasparasza.cyclingrouteslt;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Fragment that inflates the layout with detailed information about a specific route
 */
public class N02_F01_DetailedRouteInfoFragment extends Fragment {

    //Constructor of the class
    public N02_F01_DetailedRouteInfoFragment() {
        // Required empty public constructor
    }

    // Initialisation of Views that will be inflated by the fragment
    private TextView route_text_name;
    private TextView route_text_start_end;
    private TextView route_text_distance;
    private TextView route_map_link_text;
    private TextView route_detailed_description;
    private ImageView route_map_image;
    private ImageView route_difficulty_icon;
    private String route_map_link;
    // thumbnails of Route images
    private ImageButton thumb1View;
    private ImageButton thumb2View;
    private ImageButton thumb3View;
    private ImageButton thumb4View;

    // Initialisation of other Views
    private ScrollView routeFragmentScrollView;

    // Dimensions constant to be used by thumbnail image
    final int WIDTH_OF_THUMB = 80;

    // We assign layout to the fragment and inflate the views in the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initializes root view to be used by the fragment
        View rootView = inflater.inflate(R.layout.selected_route_detailed_view, container, false);

        // Inflates views of the root view
        // Obtains relevant information from a bundle
        // Numeration of Image resources follows the following logic:
        // #05 -> map_image; #01 -> main image of the route; #02-#04 -> additional images if any
        route_text_name = (TextView) rootView.findViewById(R.id.route_text_name);
        route_text_name.setText(getArguments().getInt("KEY_ROUTE_NAME", 0));

        route_text_start_end = (TextView) rootView.findViewById(R.id.route_text_start_end);
        route_text_start_end.setText(getArguments().getInt("KEY_ROUTE_START_END", 0));

        route_text_distance = (TextView) rootView.findViewById(R.id.route_text_distance);
        route_text_distance.setText(getArguments().getInt("KEY_ROUTE_DISTANCE", 0));

        route_difficulty_icon = (ImageView) rootView.findViewById(R.id.route_difficulty_icon);
        String difficulty = getString(getArguments().getInt("KEY_ROUTE_DIFFICULTY", 0));
        if (difficulty.equals("1")) {
            route_difficulty_icon.setImageResource(R.drawable.ic_difficulty_one);
        } else if (difficulty.equals("2")) {
            route_difficulty_icon.setImageResource(R.drawable.ic_difficulty_two);
        } else {
            route_difficulty_icon.setImageResource(R.drawable.ic_difficulty_three);
        }

        route_detailed_description = (TextView) rootView.findViewById(R.id.route_detailed_description);
        route_detailed_description.setText(getArguments().getInt("KEY_ROUTE_DESCRIPTION", 0));

        route_map_image = (ImageView) rootView.findViewById(R.id.route_map_image);
        final int image_05 = getArguments().getInt("KEY_ROUTE_MAP_IMAGE_ID", 0);
        route_map_image.setImageResource(image_05);

        route_map_link_text = (TextView) rootView.findViewById(R.id.route_map_link_text);

        thumb1View = (ImageButton) rootView.findViewById(R.id.route_thumb_image_1);
        thumb2View = (ImageButton) rootView.findViewById(R.id.route_thumb_image_2);
        thumb3View = (ImageButton) rootView.findViewById(R.id.route_thumb_image_3);
        thumb4View = (ImageButton) rootView.findViewById(R.id.route_thumb_image_4);

        final int image_01 = getArguments().getInt("KEY_ROUTE_IMAGE_ID_1", 0);
        final int image_02 = getArguments().getInt("KEY_ROUTE_IMAGE_ID_2", 0);
        final int image_03 = getArguments().getInt("KEY_ROUTE_IMAGE_ID_3", 0);
        final int image_04 = getArguments().getInt("KEY_ROUTE_IMAGE_ID_4", 0);

        Bitmap image_01_thumb = createBitmapThumbnail(image_01);
        Bitmap image_02_thumb = createBitmapThumbnail(image_02);
        Bitmap image_03_thumb = createBitmapThumbnail(image_03);
        Bitmap image_04_thumb = createBitmapThumbnail(image_04);

        thumb1View.setImageBitmap(image_01_thumb);
        thumb2View.setImageBitmap(image_02_thumb);
        thumb3View.setImageBitmap(image_03_thumb);
        thumb4View.setImageBitmap(image_04_thumb);


        //Sets onClickListeners to views:
        // onClick starts an activity where fullscreen image of the map is displayed
        route_map_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMapFullScreen = new Intent(getActivity(), N03_A01_FullscreenMapImageActivity.class);
                showMapFullScreen.putExtra("IMAGE_TO_SHOW", image_05);
                startActivity(showMapFullScreen);
            }
        });
        // onClick sends an intent to open an external app to display the map
        route_map_link_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                route_map_link = getArguments().getString("KEY_ROUTE_MAP_LINK");
                Uri gmmIntentUri = Uri.parse(route_map_link);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    Toast.makeText(getContext(), R.string.Toast_message_at_opening_a_map, Toast.LENGTH_LONG).show();
                    startActivity(mapIntent);
                }

            }
        });

        // onClicks which start the full screen image activity:

        // Intent that will open full screen image activity
        final Intent showPictureFullScreen = new Intent(getActivity(), N03_A02_FullscreenImageActivity.class);
        int[] imagesOfRoute = new int[]{image_01, image_02, image_03, image_04};
        showPictureFullScreen.putExtra("IMAGES_TO_SHOW", imagesOfRoute);

        // image ID of the clicked image is also sent via intent; it will display this image first
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureFullScreen.putExtra("FIRST_IMAGE", 0);
                startActivity(showPictureFullScreen);
            }
        });
        thumb2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureFullScreen.putExtra("FIRST_IMAGE", 1);
                startActivity(showPictureFullScreen);
            }
        });
        thumb3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureFullScreen.putExtra("FIRST_IMAGE", 2);
                startActivity(showPictureFullScreen);
            }
        });
        thumb4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureFullScreen.putExtra("FIRST_IMAGE", 3);
                startActivity(showPictureFullScreen);
            }
        });

        //Returns the inflated fragment
        return rootView;
       }


    /**
     * Creates Bitmap thumbnail of an image
     * @param imageResource image ID in resources
     * @return Bitmap thumbnail of an image
     */
    private Bitmap createBitmapThumbnail (int imageResource) {
        Bitmap Bitmap_of_image = BitmapFactory.decodeResource(getResources(), imageResource);
        int height_of_thumb = WIDTH_OF_THUMB * 3/4;
        Bitmap Thumbnail_bitmap_of_image = ThumbnailUtils.extractThumbnail(Bitmap_of_image, WIDTH_OF_THUMB, height_of_thumb);
        return Thumbnail_bitmap_of_image;
    }
}
