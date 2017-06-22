package com.example.atharva.pomodoro;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

public class Interval extends abstarctTimer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval);
        createTimer(3000);
        setStopButton();
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int which){
        switch (which){
            case BUTTON_NEGATIVE:
                dialogInterface.cancel();
                break;

            case BUTTON_POSITIVE:
                finish();
                break;
        }
    }
}

