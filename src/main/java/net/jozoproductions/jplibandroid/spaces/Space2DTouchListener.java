package net.jozoproductions.jplibandroid.spaces;

import android.view.MotionEvent;

public interface Space2DTouchListener {
    void OnDown(MotionEvent event);
    void OnMove(MotionEvent event);
}
