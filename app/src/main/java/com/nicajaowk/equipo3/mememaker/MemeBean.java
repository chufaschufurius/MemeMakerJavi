package com.nicajaowk.equipo3.mememaker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by CHUFASCHIN on 05/02/2015.
 */
public class MemeBean implements Serializable{
    private int memeId;
    private  String memeAssetLocation;
    private ArrayList<MemeAnnotation> memeAnnotation;
    private String memeName;

    public MemeBean(){
        this(-1,"","", new ArrayList<MemeAnnotation>());
    }
    public MemeBean(int id, String assetLocation, String name, ArrayList<MemeAnnotation> annotations){
        memeId=id;
        memeAssetLocation=assetLocation;
        memeAnnotation=annotations;
        memeName=name;
    }

    public void setMemeAssetLocation(String memeAssetLocation) {
        this.memeAssetLocation = memeAssetLocation;
    }

    public void setMemeAnnotation(ArrayList<MemeAnnotation> memeAnnotation) {
        this.memeAnnotation = memeAnnotation;
    }

    public void setMemeName(String memeName) {
        this.memeName = memeName;
    }

    public int getMemeId() {
        return memeId;
    }

    public String getMemeAssetLocation() {
        return memeAssetLocation;
    }

    public ArrayList<MemeAnnotation> getMemeAnnotation() {
        return memeAnnotation;
    }

    public String getMemeName() {
        return memeName;
    }

    public Bitmap getBitmap(){
        File file =new File(memeAssetLocation);
        if(!file.exists()){
            Log.e("File is missing", memeAssetLocation);
        }
        return BitmapFactory.decodeFile(memeAssetLocation);
    }




}
