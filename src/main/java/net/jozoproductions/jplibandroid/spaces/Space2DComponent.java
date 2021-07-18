package net.jozoproductions.jplibandroid.spaces;

import android.graphics.Canvas;

import net.jozoproductions.jplibandroid.math.Vector2;

public abstract class Space2DComponent {

    public Vector2 position;
    public Vector2 size;

    public Space2DComponent(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
    }

    public abstract void OnAdd(Space2D space2D);
    public abstract void Render(Space2D space2D, Canvas canvas);
}
