package com.example.atharva.pomodoro;

import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by atharva on 21/06/17 for Pomodoro
 */

abstract class abstarctTimer extends AppCompatActivity implements DialogInterface.OnClickListener{

    public void confirmExit(){
        /*
        When user presses the stopButton, create a confirmation dialog box
         */
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setPositiveButton("Yes!",this);
        alertDialog.setNegativeButton("No!", this);
        AlertDialog alert = alertDialog.create();
        alert.setTitle("Are you sure?");
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which){

    }

    public void createTimer(final int miliseconds){
        /*
        Start the timer from 25:00 and on finish play notification and delete activity
         */
        final EditText timerText = (EditText) findViewById(R.id.timerText);

        new CountDownTimer(miliseconds, 1000){
            public void onTick(long milisec){
                timerText.setText(inFormat(milisec));
            }

            public void onFinish(){
                try{
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                    afterRingtone();
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

    public void afterRingtone(){

    }

    public void setStopButton() {
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
