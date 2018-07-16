package com.example.qwn.day10;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main_layout;
    private ConstraintSet constraintSet = new ConstraintSet();
    //private String log_tag = "TimerStart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_layout = findViewById(R.id.main_layout);
        constraintSet.clone(this, R.layout.layout);
    }

    public void TimerStart(View v)
    {
        Log.d("TimerStart", "Read click");
        TransitionManager transitionManager = new TransitionManager();
        transitionManager.beginDelayedTransition(main_layout);
        constraintSet.applyTo(main_layout);
    }
}
