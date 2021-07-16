package net.jozoproductions.jplibandroid.listenerutils;

import android.view.MotionEvent;

@Deprecated
public class LUMoveAround {

    private float lastX;
    private float lastY;

    @Deprecated
    public void Update(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                lastX = event.getRawX();
                lastY = event.getRawY();

                break;
            case MotionEvent.ACTION_MOVE:



                lastX = event.getRawX();
                lastY = event.getRawY();

                break;
        }
    }

}
