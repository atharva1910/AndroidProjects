package com.example.qwn.day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private long result = 0;
    private String logTag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OperatorClicked(View v)
    {
        EditText editText = findViewById(R.id.textBox);
        long val = Long.parseLong(editText.getText().toString());
        editText.setText("");
        switch(v.getId()){
            case R.id.add : {
                result += val;
                Log.v(logTag, "Add Clicked");
            }break;
            case R.id.sub : {
                result += val;
                Log.v(logTag, "Sub Clicked");
            }break;
            case R.id.mul : {
                result += val;
                Log.v(logTag, "Mul Clicked");
            }break;
            case R.id.div : {
                result += val;
                Log.v(logTag, "Div Clicked");
            }break;
            case R.id.cal: {
                Log.v(logTag, "Cal click " + v.getId());
            }break;
        }
        editText.setText(Long.toString(result));
    }
}
