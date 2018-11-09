package com.example.kasparasza.cyclingrouteslt.utilities;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.kasparasza.cyclingrouteslt.R;

/**
 * Class that contains static methods used by other classes
 */

public class AppUtilities {

    /*
    * Class constructor set as private so that the utility class would not be available to instantiate
    */
    private AppUtilities(){
        super();
    }

    /**
     * Method that returns column width of the gridView to be set
     * If display width is too small to display at least 2 columns, then column width is adjusted to fit at least two of them in the display
     *
     * @param context
     * @return column width
     */
    public static int calculateColumnWidth(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        float targetColumnWidth = context.getResources().getDimension(R.dimen.grid_view_col_width) / displayMetrics.density;
        float targetSpacingWidth = context.getResources().getDimension(R.dimen.grid_view_col_horizontal_space) / displayMetrics.density;
        float widthAdjustment = dpWidth - (targetColumnWidth * 2 + targetSpacingWidth * 3);
        if(widthAdjustment < 0){
            return Math.round((targetColumnWidth + (widthAdjustment / 2)) * displayMetrics.density);
        }
        else {
            return Math.round(targetColumnWidth * displayMetrics.density);
        }
    }


}
