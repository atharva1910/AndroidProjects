package com.example.qwn.day6;

import android.content.IntentFilter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private long number_1 = 0;
    private long number_2 = 0;
    StringBuilder stringBuilder = new StringBuilder();
    private String operator = "";
    private String log_tag = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(log_tag, findViewById(R.id.main_activity).getClass().toString());
        constraintLayout = findViewById(R.id.main_activity);
        //Display(Long.toString(number_1;
    }

    public void NumberClicked(View v)
    {
        Log.v(log_tag, "Number Clicked");
        switch (v.getId()){
            case R.id.button_0:
                stringBuilder.append("0");
                break;
            case R.id.button_1:
                stringBuilder.append("1");
                break;
            case R.id.button_2:
                stringBuilder.append("2");
                break;
            case R.id.button_3:
                stringBuilder.append("3");
                break;
            case R.id.button_4:
                stringBuilder.append("4");
                break;
            case R.id.button_5:
                stringBuilder.append("5");
                break;
            case R.id.button_6:
                stringBuilder.append("6");
                break;
            case R.id.button_7:
                stringBuilder.append("7");
                break;
            case R.id.button_8:
                stringBuilder.append("8");
                break;
            case R.id.button_9:
                stringBuilder.append("9");
                break;
        }
        Display(stringBuilder.toString());
    }

    public void OperatorClicked(View v)
    {
        Log.v(log_tag, "Operator Clicked");
        if(!operator.isEmpty()){
            DisplayResult(v);
            Log.v(log_tag, "After compute number_1 " + number_1 + " number_2 " + number_2);
            StoreOperator(v.getId());
            return;
        }

        if(number_1 == 0) {
            Log.v(log_tag, "number_1 is 0 storing " + stringBuilder.toString() + " in number_1");
            number_1 = Long.parseLong(stringBuilder.toString());
            stringBuilder.setLength(0);
            Display(Long.toString(number_1));
        }

        StoreOperator(v.getId());
    }

    private void Compute()
    {
        number_2 = Long.parseLong(stringBuilder.toString());
        stringBuilder.setLength(0);
        switch(operator){
            case "+":
                number_1 += number_2;
                break;
            case "-":
                number_1 -= number_2;
                break;
            case "/":
                try {
                    number_1 /= number_2;
                }catch (ArithmeticException e){
                    Log.v(log_tag, "Divide by zero exception");
                }
                break;
            case "*":
                number_1 *= number_2;
                break;
            default:
                if(number_2 > 0)
                    number_1 = number_2;
                break;
        }
        number_2 = 0;
    }

    public void DisplayResult(View v)
    {
        Compute();
        operator = "";
        Display(Long.toString(number_1));
    }

    private void Display(String string)
    {
        EditText editText = findViewById(R.id.calcText);
        editText.setText(string);
    }

    private void StoreOperator(int id)
    {
        switch (id){
            case R.id.button_add:
                operator = "+";
                break;
            case R.id.button_sub:
                operator = "-";
                break;
            case R.id.button_mul:
                operator = "*";
                break;
            case R.id.button_div:
                operator = "/";
                break;
        }
    }

    public void ClearClicked(View v)
    {
        Display("0");
        number_2 = 0;
        number_1 = 0;
        operator = "";
        stringBuilder.setLength(0);
    }
}
