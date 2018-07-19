package com.example.qwn.day10;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet constraintSet = new ConstraintSet();
    TransitionManager transitionManager = new TransitionManager();
    Switch timer_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer_toggle = findViewById(R.id.timerToggle);
        timer_toggle.setTextOn("Start timer");
        timer_toggle.setTextOff("Stop timer");
        timer_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.d("On switch", "Switch is on");
                    TimerStart();
                }else{
                    Log.d("On switch", "Switch is off");
                    TimerStop();
                }
            }
        });
    }

    public void TimerStart()
    {
        Log.d("TimerStart", "Read click");
        ConstraintLayout main_layout = findViewById(R.id.main_layout);
        constraintSet.clone(this, R.layout.layout);
        transitionManager.beginDelayedTransition(main_layout);
        constraintSet.applyTo(main_layout);
    }

     public void TimerStop()
    {
        Log.d("TimerStop", "Read click");
        ConstraintLayout main_layout = findViewById(R.id.timer_layout);
        constraintSet.clone(this, R.layout.activity_main);
        transitionManager.beginDelayedTransition(main_layout);
        constraintSet.applyTo(main_layout);
    }
}
