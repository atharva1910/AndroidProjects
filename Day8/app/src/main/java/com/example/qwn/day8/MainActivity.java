package com.example.qwn.day8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BtnClicked(View v)
    {
        Intent changeIntent = new Intent(MainActivity.this, IntentActivity.class);
        MainActivity.this.startActivity(changeIntent);
    }
}
