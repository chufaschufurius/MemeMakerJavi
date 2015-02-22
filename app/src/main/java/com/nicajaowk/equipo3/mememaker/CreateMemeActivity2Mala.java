package com.nicajaowk.equipo3.mememaker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;


public class CreateMemeActivity2Mala extends ActionBarActivity {

//    private MemeImageView mMemeBitmapHolder;
    private FrameLayout mMemeContainer;
    private ArrayList<EditText> mMemeTexts;
    private String mImageFilePath;
    private String mCurrentColor;
    private MemeBean mCurrentMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

    }

    private void saveMeme() {
        for (int i = 0; i < mMemeTexts.size(); i++) {
            EditText editText = mMemeTexts.get(i);
            MemeAnnotation annotation = mCurrentMeme.getMemeAnnotation().get(i);
            annotation.setMemeTitle(editText.getText().toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_meme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
