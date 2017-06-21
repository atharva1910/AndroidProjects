package com.example.atharva.pomodoro;

import java.util.Locale;
import java.util.StringTokenizer;

import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.net.Uri;

public class Timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        createTimer();
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

    public void confirmExit(){
        /*
        When user presses the stopButton, create a confirmation dialog box
         */
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setTitle("Are you sure?");
        alert.show();
    }

    public void createTimer(){
        /*
        Start the timer from 25:00 and on finish play notification and delete activity
         */
        final int MILISECONDS = 150000;
        final EditText timerText = (EditText) findViewById(R.id.timerText);
        new CountDownTimer(MILISECONDS, 1000){
            public void onTick(long milisec){
                timerText.setText(inFormat(milisec));
            }
            public void onFinish(){
                try{
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                }catch (Exception e){
                    e.printStackTrace();
                }
                finish();
            }
        }.start();

    }

    public String inFormat(long mil){
        /*
        convert miliseconds to mm:ss format
         */
        long minutes = mil/60000;
        long seconds = (mil/1000)%60;
        return(String.format(Locale.ENGLISH,"%02d:%02d",
                minutes,seconds));
    }
}
