package com.example.atharva.pomodoro;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;


public class Timer extends abstarctTimer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        createTimer(1500000);
        setStopButton();
    }

    @Override
    public void afterRingtone(){
        Intent changeIntentInterval = new Intent(Timer.this, Interval.class);
        Timer.this.startActivity(changeIntentInterval);
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
