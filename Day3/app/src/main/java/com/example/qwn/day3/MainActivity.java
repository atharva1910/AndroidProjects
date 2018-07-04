package com.example.qwn.day3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DisplayText(View v) {
        EditText edText = findViewById(R.id.textInput);
        TextView txtView = findViewById(R.id.textView);
        String text = edText.getText().toString();
        txtView.setText(text);

    }
}
