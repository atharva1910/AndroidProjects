package com.example.atharva.pomodoro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Timer extends abstarctTimer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        createTimer(1500000);
        setStopButton();
    }

    public void setStopButton(){
        /*
        Find the stop Button and set OnClickListener
         */
        Button stopTimer = (Button) findViewById(R.id.stopButton);
        stopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmExit();
            }
        });
    }






}
