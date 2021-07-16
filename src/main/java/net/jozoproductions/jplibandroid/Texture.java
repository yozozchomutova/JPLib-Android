package net.jozoproductions.jplibandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.ColorInt;

public class Texture {

    public int width;
    public int height;

    @ColorInt
    public int[][] image;

    public Texture(Context context, int drawableId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId);

        width = bitmap.getWidth();
        height = bitmap.getHeight();

        image = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image[x][y] = bitmap.getPixel(x, y);
            }
        }
    }
}
