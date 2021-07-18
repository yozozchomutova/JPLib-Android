package net.jozoproductions.jplibandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Texture {

    public Bitmap bitmap;

    //Overlaying process
    private Canvas overlayingProcessCanvas;

    public Texture(Context context, int drawableId) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId, opts);
    }

    public Texture(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void StartBuildingMode(Bitmap newBitmap) {
        overlayingProcessCanvas = new Canvas(newBitmap);
        AddBitmapToBuildingMode(bitmap, 0, 0);
        bitmap = newBitmap;
    }

    public void AddBitmapToBuildingMode(Bitmap bitmap, int x, int y) {
        overlayingProcessCanvas.drawBitmap(bitmap, x, y, null);
    }

    public void StopBuildingMode() {

    }
}
