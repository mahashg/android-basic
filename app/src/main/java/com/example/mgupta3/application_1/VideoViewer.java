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
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class VideoViewer extends Activity {
    private List<String> list = new ArrayList<String>();
    private TextView jokeText;
    private int current_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewer);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        jokeText = (TextView) findViewById(R.id.joke);
        jokeText.setText(list.get(current_index));
    }

    private void init(){
        list.add("I’m reading a great book on anti-gravity.\n" +
                "I can’t put it down.");
        list.add("Why can’t atheists solve exponential equations? Because they don’t believe in higher powers.");
        list.add("A group of protesters in front of a physics lab:\n" +
                "“What do we want?”.\n" +
                "“Time travel”\n" +
                "“When do we want it?”.\n" +
                "“Irrelevant.");
        list.add("What does a subatomic duck say?\n" +
                "Quark!");
        list.add("A neutron walks into a bar and asks how much for a beer.\n" +
                "Bartender replies “For you, no charge”.");
        list.add("Two atoms are walking along. One of them says:\n" +
                "“Oh, no, I think I lost an electron.”\n" +
                "“Are you sure?”\n" +
                "“Yes, I’m positive.”");
        list.add("Entropy isn't what it used to be.");
        list.add("Did you hear about the man who got cooled to absolute zero?\n" +
                "He's OK now.");
        list.add("Why did the bear dissolve in water ? Because it was polar");
        list.add("Why is pH of youtube is very stable ? Because it constantly buffers.");
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

    public void next(View view ){
        current_index = (current_index + list.size()+1) % list.size();
        jokeText.setText(list.get(current_index));
    }

    public void previous(View view ){
        current_index = (current_index + list.size()-1) % list.size();
        jokeText.setText(list.get(current_index));
    }

}
