package net.jozoproductions.jplibandroid.spaces.particlesystem2d;

import android.graphics.Bitmap;

import net.jozoproductions.jplibandroid.Texture;
import net.jozoproductions.jplibandroid.math.Vector2;
import net.jozoproductions.jplibandroid.spaces.compontents2d.Texture2DComponent;

public class Particle2D extends Texture2DComponent {

    public Vector2 velocity;

    public Particle2D(Vector2 position, Bitmap bitmap) {
        super(position, new Vector2(0, 0), "");
    }

    public void Update() {
        position.x += velocity.x;
        position.y += velocity.y;
    }
}
