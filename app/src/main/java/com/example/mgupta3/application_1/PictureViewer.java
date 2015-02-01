package com.example.mgupta3.application_1;

import android.app.Activity;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PictureViewer extends Activity {
    private List<Integer> imagesList = new ArrayList<Integer>();
    private List<String> description_list = new ArrayList<String>();
    private Toast toast;

    private int current_index = 0;
    public PictureViewer(){
        updateImageList();
    }

    public void updateImageList(){
        this.imagesList.add(R.drawable.pic1);
        this.imagesList.add(R.drawable.pic2);
        this.imagesList.add(R.drawable.pic3);
        this.imagesList.add(R.drawable.pic4);
        this.imagesList.add(R.drawable.pic5);
        this.imagesList.add(R.drawable.pic6);
        this.imagesList.add(R.drawable.pic7);
        this.imagesList.add(R.drawable.pic8);
        this.imagesList.add(R.drawable.pic9);

        this.description_list.add("You are what you eat.");
        this.description_list.add("Adorable Cat");
        this.description_list.add("Master Yoda, trolling..");
        this.description_list.add("Pack you bags");
        this.description_list.add("No parking, means no parking");
        this.description_list.add("One throne to rule them all");
        this.description_list.add("Anything can happen");
        this.description_list.add("Infinite gold");
        this.description_list.add("Silly mistake.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        getActionBar().setDisplayHomeAsUpEnabled(true);

       ImageView img = (ImageView) findViewById(R.id.display);

       img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                next(view);
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
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
        if(toast != null){
            toast.cancel();
        }
        ImageView imageView = (ImageView) findViewById(R.id.display);
        current_index = (current_index + imagesList.size()+1) % imagesList.size();

        imageView.setImageResource(imagesList.get(current_index));

        toast = Toast.makeText(this, description_list.get(current_index), Toast.LENGTH_LONG);
        toast.show();
    }

    // previous button clicked
    public void previous(View view){
        if(toast != null){
            toast.cancel();
        }
        ImageView imageView = (ImageView) findViewById(R.id.display);
        current_index = (current_index + imagesList.size()-1) % imagesList.size();

        imageView.setImageResource(imagesList.get(current_index));
        toast = Toast.makeText(this, description_list.get(current_index), Toast.LENGTH_LONG);
        toast.show();
    }

    public int getCurrentImageIndex(int id){
        for(int i=0; i<imagesList.size() ; ++i){
            if(imagesList.get(i) == id) return i;
        }
        return -1;
    }

}