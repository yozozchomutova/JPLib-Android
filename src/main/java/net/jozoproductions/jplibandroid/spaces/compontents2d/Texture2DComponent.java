package net.jozoproductions.jplibandroid.spaces.compontents2d;

import android.graphics.Canvas;

import net.jozoproductions.jplibandroid.JPCore;
import net.jozoproductions.jplibandroid.Texture;
import net.jozoproductions.jplibandroid.dimensions2.Camera2D;
import net.jozoproductions.jplibandroid.math.Vector2;
import net.jozoproductions.jplibandroid.spaces.Space2D;
import net.jozoproductions.jplibandroid.spaces.Space2DComponent;

public class Texture2DComponent extends Space2DComponent {

    public String key;

    public boolean render = false;

    public float offsetX;
    public float offsetY;

    public Texture2DComponent(Vector2 position, Vector2 size, String key) {
        super(position, size);

        this.key = key;
    }

    @Override
    public void OnAdd(Space2D space2D) {
        offsetX = JPCore.SCREEN_WIDTH / 2f - size.x / 2f;
        offsetY = JPCore.SCREEN_HEIGHT / 2f - size.y / 2f;
    }

    @Override
    public void Render(Space2D space, Canvas canvas) {
        if (render) {
            Vector2 camPos = space.lastSurfaceView.camera2D.position;

            Texture texture = space.textureList.get(key);

            float imgX = offsetX - camPos.x + position.x;
            float imgY = offsetY - camPos.y + position.y;

            /*if (imgX < JPCore.SCREEN_WIDTH && imgY < JPCore.SCREEN_HEIGHT &&
                    imgX + size.x > 0 && imgY + size.y > 0)*/
                canvas.drawBitmap(texture.bitmap, imgX, imgY, null);
        }
    }
}
