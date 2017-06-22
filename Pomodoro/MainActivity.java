package com.example.atharva.pomodoro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.ActivityChooserModel;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button = (Button)findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent changeMyIntent = new Intent(MainActivity.this, Timer.class);
                MainActivity.this.startActivity(changeMyIntent);
            }
        });
    }
}

