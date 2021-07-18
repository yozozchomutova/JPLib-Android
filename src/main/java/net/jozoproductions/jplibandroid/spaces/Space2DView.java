package net.jozoproductions.jplibandroid.spaces;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import net.jozoproductions.jplibandroid.R;
import net.jozoproductions.jplibandroid.dimensions2.Camera2D;

public class Space2DView extends ConstraintLayout {

    public Space2DSurfaceView surfaceView;

    public Space2DView(@NonNull Context context) {
        super(context);
        init();
    }

    public Space2DView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Space2DView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Space2DView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_2d_space, this, true);

        surfaceView = findViewById(R.id.surfaceView);
    }

    public void setSpace2D(Space2D space2D) {
        surfaceView.space2D = space2D;
    }

    public void setCamera2D(Camera2D camera2D) {
        surfaceView.camera2D = camera2D;
    }
}
