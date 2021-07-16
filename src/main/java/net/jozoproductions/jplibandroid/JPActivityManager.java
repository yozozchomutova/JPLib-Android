package net.jozoproductions.jplibandroid;

import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class JPActivityManager {

    public static void GoFullscreen(AppCompatActivity activity) {
        activity.getSupportActionBar().hide();
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
