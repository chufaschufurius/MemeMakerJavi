package com.nicajaowk.equipo3.mememaker;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 05/02/2015.
 */
public class MemeAnnotation implements Serializable{
    private int memeId;
    private String memeColor;
    private String memeTitle;

    private int memeLocationX;
    private int memeLocationY;

    public MemeAnnotation(int id, String color, String title, int localX, int localY){
        memeId=id;
        memeColor=color;
        memeTitle=title;
        memeLocationX=localX;
        memeLocationY=localY;
    }
    public MemeAnnotation(){
        this(-1, "", "", 0, 0);
    }

    public void setMemeColor(String memeColor) {
        this.memeColor = memeColor;
    }

    public void setMemeTitle(String memeTitle) {
        this.memeTitle = memeTitle;
    }

    public void setMemeLocationX(int memeLocationX) {
        this.memeLocationX = memeLocationX;
    }

    public void setMemeLocationY(int memeLocationY) {
        this.memeLocationY = memeLocationY;
    }

    public int getMemeId() { return memeId; }
    public boolean hasBeenSaved(){return (getMemeId()!=-1);}

    public String getMemeColor() {
        return memeColor;
    }

    public String getMemeTitle() {
        return memeTitle;
    }

    public int getMemeLocationX() {
        return memeLocationX;
    }

    public int getMemeLocationY() {
        return memeLocationY;
    }




}
