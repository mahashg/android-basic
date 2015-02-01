package com.example.mgupta3.application_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HomePage extends Activity {
    public final static String EXTRA_MESSAGE = "com.mgupta3.application_1.MESSAGE";
    private Button music_button;
    private Button picture_button;
    private Button quotes_button;
    private Button india_joke_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        picture_button = (Button) findViewById(R.id.pictures);
        picture_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                begin(v);
            }
        });

        quotes_button = (Button) findViewById(R.id.videos);
        quotes_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                videos(v);
            }
        });

        india_joke_button = (Button) findViewById(R.id.musics);
        india_joke_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                music(v);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
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

    // Called when button on homescreen is called.
    public void sendMessage(View view){
        Intent intent = new Intent(this, Quotes.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = "dummy message"; //editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void begin(View view){
        Intent intent = new Intent(this, PictureViewer.class);
        startActivity(intent);
    }

    public void videos(View view){
        Intent intent = new Intent(this, VideoViewer.class);
        startActivity(intent);
    }

    public void music(View view){
        Intent intent = new Intent(this, Quotes.class);
        startActivity(intent);
    }
}
