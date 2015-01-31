package com.example.mgupta3.application_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;



public class VideoViewer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewer);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        VideoView video_player_view = (VideoView) findViewById(R.id.video);
        video_player_view.setMediaController(new MediaController(this));
        video_player_view.setVideoPath("/Users/mgupta3/Desktop/resources/video/scary.mp4");
        video_player_view.requestFocus();
        video_player_view.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video_viewer, menu);
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

    public void play(View view){
        /*
        VideoView video_player_view = (VideoView) findViewById(R.id.video);
        MediaController media_Controller = new MediaController(this);
        DisplayMetrics dm = new DisplayMetrics();

        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(media_Controller);
        //video_player_view.setVideoPath("");
        video_player_view.setVideoPath("/Users/mgupta3/Desktop/resources/video/cat-fight.mp4");
        video_player_view.start();
        System.out.println("Video play started");
        */
    }
}
