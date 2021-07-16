package net.jozoproductions.jplibandroid.spaces.compontents2d;

import net.jozoproductions.jplibandroid.Texture;
import net.jozoproductions.jplibandroid.math.Vector2;
import net.jozoproductions.jplibandroid.spaces.Space2D;
import net.jozoproductions.jplibandroid.spaces.Space2DComponent;

public class Texture2DComponent extends Space2DComponent {

    public Texture texture;

    public Texture2DComponent(Vector2 position, Texture texture) {
        super(position);

        this.texture = texture;
    }

    @Override
    public void Render(Space2D space) {
        //Render texture
        for (int x = 0; x < texture.width; x++) {
            for (int y = 0; y < texture.height; y++) {
                space.DrawPixel(x, y, texture.image[x][y]);
            }
        }
    }

}
