package net.jozoproductions.jplibandroid.spaces;

import net.jozoproductions.jplibandroid.math.Vector2;

public abstract class Space2DComponent {

    public Vector2 position;

    public Space2DComponent(Vector2 position) {
        this.position = position;
    }

    public abstract void Render(Space2D space);
}
