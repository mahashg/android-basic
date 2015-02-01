package com.example.mgupta3.application_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Quotes extends Activity {
    private ImageView imageView;
    private List<Integer> list = new ArrayList<Integer>();
    private int current_index = 0;

    private Button next_button;
    private Button prev_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        init_buttons();
    }

    private void init(){
        imageView = (ImageView)findViewById(R.id.display_it);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                next(view);
            }
        });

        list.add(R.drawable.pun1);
        list.add(R.drawable.pun2);
        list.add(R.drawable.pun3);
        list.add(R.drawable.pun4);
        list.add(R.drawable.pun5);
        list.add(R.drawable.pun6);
        list.add(R.drawable.pun7);
        list.add(R.drawable.pun8);
        list.add(R.drawable.pun9);
        list.add(R.drawable.pun10);
        list.add(R.drawable.pun11);
        list.add(R.drawable.pun12);
        list.add(R.drawable.pun13);
        list.add(R.drawable.pun14);
        list.add(R.drawable.pun15);
        list.add(R.drawable.pun16);
        list.add(R.drawable.pun17);
        list.add(R.drawable.pun18);
        list.add(R.drawable.pun19);
        list.add(R.drawable.pun20);
        list.add(R.drawable.pun21);


    }

    private void init_buttons(){
        next_button = (Button) findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                next(v);
            }
        });

        prev_button = (Button) findViewById(R.id.previous_button);
        prev_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                previous(v);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void next(View view){
        current_index = (current_index + list.size()+1) % list.size();
        imageView.setImageResource(list.get(current_index));
    }

    private void previous(View view){
        current_index = (current_index + list.size()-1) % list.size();
        imageView.setImageResource(list.get(current_index));
    }
}