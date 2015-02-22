package com.nicajaowk.equipo3.mememaker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by CHUFASCHIN on 05/02/2015.
 */
public class ImagenItem {
    private Bitmap bitmap;
    private String string;

    public ImagenItem(String ruta, String texto){
      bitmap= BitmapFactory.decodeFile(ruta);
      string=texto;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getString() {
        return string;
    }
}
