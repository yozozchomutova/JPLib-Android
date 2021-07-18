package net.jozoproductions.jplibandroid.spaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.jozoproductions.jplibandroid.JPCore;
import net.jozoproductions.jplibandroid.Texture;
import net.jozoproductions.jplibandroid.dimensions2.Camera2D;
import net.jozoproductions.jplibandroid.math.Mathf;
import net.jozoproductions.jplibandroid.spaces.compontents2d.Texture2DComponent;
import net.jozoproductions.jplibandroid.spaces.particlesystem2d.ParticleSystem2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Space2D {

    public ArrayList<Space2DComponent> components = new ArrayList<>();
    public ArrayList<ParticleSystem2D> particleSystems = new ArrayList<>();
    public ArrayList<Space2DUpdater> updaters = new ArrayList<>();

    public HashMap<String, Texture> textureList = new HashMap<>();

    public Space2DSurfaceView lastSurfaceView;

    public Space2D() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < updaters.size(); i++) {
                    updaters.get(i).Update();
                }
            }
        }, 0, 5, TimeUnit.MILLISECONDS);

        ScheduledExecutorService textureRenderDecider = Executors.newScheduledThreadPool(5);
        textureRenderDecider.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if(lastSurfaceView != null) {
                    for (int i = 0; i < components.size(); i++) {
                        Texture2DComponent texture2DComponent = (Texture2DComponent) components.get(i);

                        float imgX = texture2DComponent.offsetX - lastSurfaceView.camera2D.position.x + texture2DComponent.position.x;
                        float imgY = texture2DComponent.offsetY - lastSurfaceView.camera2D.position.y + texture2DComponent.position.y;

                        texture2DComponent.render = (imgX < JPCore.SCREEN_WIDTH && imgY < JPCore.SCREEN_HEIGHT &&
                            imgX + texture2DComponent.size.x > 0 && imgY + texture2DComponent.size.y > 0);
                    }
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }

    public void AddComponent(Space2DComponent component) {
        components.add(component);
        component.OnAdd(this);
    }

    public void AddUpdater(Space2DUpdater updater) {
        updaters.add(updater);
        updater.Start();
    }

    public void LoadTexture(String key, Texture texture) {
        textureList.put(key, texture);
    }

    public void AddParticleSystem2D(ParticleSystem2D particleSystem2D) {
        particleSystems.add(particleSystem2D);
    }

    public void Render(Space2DSurfaceView surfaceView, Canvas canvas) {
        this.lastSurfaceView = surfaceView;

        for (Space2DComponent space2DComponent : components) {
            space2DComponent.Render(this, canvas);
        }
    }
}
