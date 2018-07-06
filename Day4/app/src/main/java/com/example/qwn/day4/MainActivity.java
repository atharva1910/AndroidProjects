package com.example.qwn.day4;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private long result = 0;
    private long number = 0;
    private String oper = null;
    private String logTag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OperatorClicked(View v)
    {
        EditText editText = findViewById(R.id.textBox);
        if(oper != null){
            result = PerformOperation(oper, number, result);
            oper = null;
            number = 0;
            Log.v(logTag, "result " + result);
        }
        number = Long.parseLong(editText.getText().toString());
        editText.setText("");
        switch(v.getId()){
            case R.id.add : {
                oper = "Add";
                Log.v(logTag, "Add Clicked");
            }break;
            case R.id.sub : {
                oper = "Sub";
                Log.v(logTag, "Sub Clicked");
            }break;
            case R.id.mul : {
                oper = "Mul";
                Log.v(logTag, "Mul Clicked");
            }break;
            case R.id.div : {
                oper = "Div";
                Log.v(logTag, "Div Clicked");
            }break;
            case R.id.cal: {
                if(oper != null) {
                    result = PerformOperation(oper, number, result);
                    oper = null;
                }
                editText.setText(Long.toString(result));
                Log.v(logTag, "Cal click " + v.getId());
            }break;
        }

    }

    private long PerformOperation(String operation, long val, long result)
    {
        switch(operation){
            case "Add":{
                result += val;
            }break;
            case "Mul":{
                result *= val;
            }break;
            case "Div":{
                result /= val;
            }break;
            case "Sub":{
                result -= val;
            }break;
        }
        return result;
    }
}
