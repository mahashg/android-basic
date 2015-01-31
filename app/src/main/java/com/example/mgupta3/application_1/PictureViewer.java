package com.example.mgupta3.application_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class PictureViewer extends Activity {
    private List<Integer> imagesList;
    private int current_index = 0;

    public PictureViewer(){
        updateImageList();
    }

    public void updateImageList(){
        this.imagesList = new ArrayList<Integer>();
        this.imagesList.add(R.drawable.pic1);
        this.imagesList.add(R.drawable.pic2);
        this.imagesList.add(R.drawable.pic3);
        this.imagesList.add(R.drawable.pic4);
        this.imagesList.add(R.drawable.pic5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        String message = "Mr. Gupta";

        TextView textView = new TextView(this);
        textView.setText("Hello, "+message+", I am neo.");
        textView.setTextSize(40);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.pic1);
        imageView.setMaxHeight(300);
        imageView.setMaxWidth(300);

        setContentView(imageView);
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
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

    // next button clicked
    public void next(View view){
        ImageView imageView = (ImageView) findViewById(R.id.display);
        if(current_index == imagesList.size()-1){
            current_index = 0;
        }else{
            ++current_index;
        }
        imageView.setImageResource(imagesList.get(current_index));
    }

    // previous button clicked
    public void previous(View view){
        ImageView imageView = (ImageView) findViewById(R.id.display);
        if(current_index == 0){
            current_index = imagesList.size()-1;
        }else{
            --current_index;
        }

        imageView.setImageResource(imagesList.get(current_index));
    }

    public int getCurrentImageIndex(int id){
        for(int i=0; i<imagesList.size() ; ++i){
            if(imagesList.get(i) == id) return i;
        }
        return -1;
    }
}
