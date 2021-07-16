package net.jozoproductions.jplibandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import net.jozoproductions.jplibandroid.JPCore;
import net.jozoproductions.jplibandroid.R;
import net.jozoproductions.jplibandroid.dimensions2.Camera2D;
import net.jozoproductions.jplibandroid.spaces.Space2D;
import net.jozoproductions.jplibandroid.spaces.Space2DComponent;

public class Space2DRenderer extends ConstraintLayout {

    private Space2D space;
    public Camera2D camera;

    private ConstraintLayout root;
    public ImageView renderingImage;
    public Bitmap renderingImageBitmap;

    public Space2DRenderer(@NonNull Context context) {
        super(context);
        init();
    }

    public Space2DRenderer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Space2DRenderer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Space2DRenderer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_2d_space, this, true);

        root = findViewById(R.id.root);
        renderingImage = findViewById(R.id.rendering_image);
        renderingImageBitmap = Bitmap.createBitmap(JPCore.SCREEN_WIDTH, JPCore.SCREEN_HEIGHT, Bitmap.Config.ARGB_8888);

        UpdateRenderingImage();
    }

    public Space2D getSpace() {
        return space;
    }

    public void setSpace(Space2D space) {
        this.space = space;
        this.space.space2DRenderer = this;
        this.space.renderingImageBitmap = renderingImageBitmap;
    }

    public void setCamera(Camera2D camera) {
        this.camera = camera;
    }

    public void UpdateRenderingImage() {
        ((Activity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                renderingImage.setImageBitmap(renderingImageBitmap);
            }
        });
    }

    public void setupListener(OnTouchListener onTouchListener) {
        root.setOnTouchListener(onTouchListener);
    }
}
