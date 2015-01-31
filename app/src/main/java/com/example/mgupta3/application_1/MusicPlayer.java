package com.example.mgupta3.application_1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MusicPlayer extends Activity {
    private boolean state;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        this.state = true;
        playMusic();
    }

    public void music(View view){
        if(!state){
            playMusic();
        }else{
            pauseMusic();
        }
        state = !state;
    }

    public void playMusic(){
        player = MediaPlayer.create(this, R.raw.music1);
        try {
            player.prepare();
        }catch(Exception e){
            e.printStackTrace();
        }
        player.start();

        Button button = (Button) findViewById(R.id.music);
        button.setText(R.string.pause_button);

    }

    public void pauseMusic(){
        player.stop();

        Button button = (Button) findViewById(R.id.music);
        button.setText(R.string.play_button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music_player, menu);
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
