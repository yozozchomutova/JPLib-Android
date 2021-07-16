package net.jozoproductions.jplibandroid;

import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

public class JPCore {

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static void Start(AppCompatActivity activity) {
        //Screen resolutions
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        SCREEN_WIDTH = displayMetrics.widthPixels;
        SCREEN_HEIGHT = displayMetrics.heightPixels;
    }

}
