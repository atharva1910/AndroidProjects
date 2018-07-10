package com.example.qwn.day9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class PostForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_form);
        Intent passed_intent = getIntent();
        Log.d("Intent Check", passed_intent.getStringExtra("NAME_STRING"));

        EditText display_field = findViewById(R.id.display_text);
        display_field.setText("Hello There "+ passed_intent.getStringExtra("NAME_STRING"));
    }

}
