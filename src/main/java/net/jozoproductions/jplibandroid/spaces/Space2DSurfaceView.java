package net.jozoproductions.jplibandroid.spaces;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import net.jozoproductions.jplibandroid.JPCore;
import net.jozoproductions.jplibandroid.dimensions2.Camera2D;

public class Space2DSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public Space2D space2D;
    public Camera2D camera2D;

    public Canvas canvas;

    public Space2DSurfaceView(Context context) {
        super(context);

        getHolder().addCallback(this);
    }

    public Space2DSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    public Space2DSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().addCallback(this);
    }

    public Space2DSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void surfaceCreated(@NonNull final SurfaceHolder holder) {

        Thread renderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (space2D != null) {
                        canvas = holder.lockCanvas(new Rect(0, 0, JPCore.SCREEN_WIDTH, JPCore.SCREEN_HEIGHT));
                        space2D.Render(Space2DSurfaceView.this, canvas);
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        });

        renderThread.setPriority(Thread.MAX_PRIORITY);
        renderThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }

    @Override public void surfaceDestroyed(@NonNull SurfaceHolder holder) {}
}