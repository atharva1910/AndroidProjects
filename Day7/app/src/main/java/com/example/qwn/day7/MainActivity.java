package com.example.qwn.day7;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet constraintSet = new ConstraintSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.main_activity);
        constraintSet.clone(this,R.layout.content_animate);
    }

    public void ButtonClicked(View v)
    {

        TransitionManager transitionManager = new TransitionManager();

        transitionManager.beginDelayedTransition(layout);
        constraintSet.applyTo(layout);

    }
}
