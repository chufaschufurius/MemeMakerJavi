package com.nicajaowk.equipo3.mememaker;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by CHUFASCHIN on 05/02/2015.
 */
public class MemeSQLiteH extends SQLiteOpenHelper {
    final static String DB_NAME="MemeMaker.db";
    final static int DB_VERSION=1;
    final static String TAG=MemeSQLiteH.class.getName();

//    Meme Table Functionality
    final static String MEME_TABLE= "MEME";
    final static String COLUMN_MEME_ASSET= "ASSET";
    final static String COLUMN_MEME_NAME= "NAME";
    final static String COLUMN_MEME_ID= "_ID";

    final static String ANNOTATIONS_TABLE= "ANNOTATIONS";
    final static String COLUMN_ANNOTATIONS_ID= "_ID";
    final static String COLUMN_ANNOTATIONS_NAME= "TITLE";
    final static String COLUMN_ANNOTATIONS_COLOR= "COLOR";
    final static String COLUMN_ANNOTATIONS_X= "X";
    final static String COLUMN_ANNOTATIONS_Y= "Y";
    final static String COLUMN_ANNOTATIONS_FK_ID_MEME= "FK_ID_MEME";

    final static String CREATE_TABLE_MEME="CREATE TABLE" +MEME_TABLE+"( "+
            COLUMN_MEME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_MEME_ASSET+"TEXT NOT NULL, "+
            COLUMN_MEME_NAME+"TEXT NOT NULL);";

    final static String CREATE_TABLE_ANNOTATIONS="CREATE TABLE" +ANNOTATIONS_TABLE+"( "+
            COLUMN_ANNOTATIONS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ANNOTATIONS_NAME+"TEXT NOT NULL, "+
            COLUMN_ANNOTATIONS_COLOR+"VARCHAR" +
            COLUMN_ANNOTATIONS_X+"INTEGER" +
            COLUMN_ANNOTATIONS_Y+"INTEGER" +
            COLUMN_ANNOTATIONS_FK_ID_MEME+"INTEGER FOREIGN KEY (FK_ID_MEME) REFERENCES MEME(_ID));";


    public MemeSQLiteH(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_MEME);
            db.execSQL(CREATE_TABLE_ANNOTATIONS);
        }catch (SQLException e){
            Log.e(TAG, "Android SQLException caught" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
