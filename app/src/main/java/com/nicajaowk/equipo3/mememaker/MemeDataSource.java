package com.nicajaowk.equipo3.mememaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CHUFASCHIN on 05/02/2015.
 */
public class MemeDataSource {
    private Context mContext;
    MemeSQLiteH memeSQLiteH;

    public MemeDataSource(Context context){
        mContext=context;
        memeSQLiteH= new MemeSQLiteH(context, null, null, 1);
        SQLiteDatabase database=memeSQLiteH.getReadableDatabase();
    }

    public SQLiteDatabase openReadable(){
        return memeSQLiteH.getReadableDatabase();
    }

    public SQLiteDatabase openWriteable(){
        return memeSQLiteH.getWritableDatabase();
    }

    public void closeDatabase(SQLiteDatabase dbase){
        dbase.close();
    }

    public void createMeme(MemeBean memeBean){
        SQLiteDatabase database= openWriteable();
        database.beginTransaction();
        //detalles
        long longMemeId;
        MemeBean memeBean1 = new MemeBean();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MemeSQLiteH.COLUMN_MEME_ASSET, memeBean1.getMemeAssetLocation());
        contentValues.put(MemeSQLiteH.COLUMN_MEME_NAME, memeBean1.getMemeName());
//        contentValues.put(MemeSQLiteH.COLUMN_MEME_ID, memeBean1.getMemeId());

        longMemeId=database.insert(MemeSQLiteH.MEME_TABLE, null,contentValues);

        ArrayList<MemeAnnotation> anotationArray=memeBean1.getMemeAnnotation();
        for(MemeAnnotation memeAnnotation :anotationArray){
            if(memeAnnotation.getMemeId()==longMemeId){
                ContentValues annotationValues= new ContentValues();
                annotationValues.put(MemeSQLiteH.COLUMN_ANNOTATIONS_NAME, memeAnnotation.getMemeTitle());
                annotationValues.put(MemeSQLiteH.COLUMN_ANNOTATIONS_COLOR, memeAnnotation.getMemeColor());
                annotationValues.put(MemeSQLiteH.COLUMN_ANNOTATIONS_X, memeAnnotation.getMemeLocationX());
                annotationValues.put(MemeSQLiteH.COLUMN_ANNOTATIONS_Y, memeAnnotation.getMemeLocationY());

                database.insert(MemeSQLiteH.ANNOTATIONS_TABLE, null, annotationValues);

            }
        }

        database.setTransactionSuccessful();
        database.endTransaction();
        closeDatabase(database);
    }





}
