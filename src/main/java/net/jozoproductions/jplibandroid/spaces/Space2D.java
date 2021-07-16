package net.jozoproductions.jplibandroid.spaces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import net.jozoproductions.jplibandroid.JPCore;
import net.jozoproductions.jplibandroid.fragments.Space2DRenderer;
import net.jozoproductions.jplibandroid.math.Mathf;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Space2D {

    public Space2DRenderer space2DRenderer;

    public ArrayList<Space2DComponent> components = new ArrayList<>();

    public ConstraintLayout root;
    public Bitmap renderingImageBitmap;

    public Space2D() {

    }

    public void Start() {
        //Render
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Render();

                    try { Thread.sleep(10); } catch (Exception e) { e.printStackTrace(); }
                }
            }
        });
        thread.start();
    }

    public void AddComponent(Space2DComponent component) {
        components.add(component);
    }

    public void Render() {
        for (Space2DComponent space2DComponent : components) {
            space2DComponent.Render(this);
        }

        space2DRenderer.UpdateRenderingImage();
    }

    public void DrawPixel(int x, int y, int color) {
        x += JPCore.SCREEN_WIDTH/2f - space2DRenderer.camera.position.getX();
        y += JPCore.SCREEN_HEIGHT/2f - space2DRenderer.camera.position.getY();

        if( Mathf.isInBounds(x, 0, renderingImageBitmap.getWidth()) &&
            Mathf.isInBounds(y, 0, renderingImageBitmap.getHeight()))
            renderingImageBitmap.setPixel(x, y, color);
    }
}
