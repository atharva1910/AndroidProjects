package com.example.qwn.day9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String log_tag = "form_button_clicked";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TEST","this called again? or isit loaded from memory");
    }

    public void form_button_clicked(View v)
    {
        Log.d(log_tag, "Button clicked");
        String name ="", phone = "", email = "", address = "";
        boolean post_form = true;
        EditText name_field = findViewById(R.id.name_field);

        if(TextUtils.isEmpty((name_field.getText().toString()))){
            Log.d(log_tag, "name_field is empty");
            post_form = false;
        }else{
            name = name_field.getText().toString();
        }

        EditText email_field = findViewById(R.id.email_field);
        if(TextUtils.isEmpty((email_field.getText().toString()))){
            Log.d(log_tag, "name_field is empty");
            post_form = false;
        }else{
            email = email_field.getText().toString();
        }

        EditText phone_field = findViewById(R.id.phone_field);
        if(TextUtils.isEmpty((phone_field.getText().toString()))){
            Log.d(log_tag, "name_field is empty");
            post_form = false;
        }else{
            phone = phone_field.getText().toString();
        }

        EditText address_field = findViewById(R.id.address_field);
        if(TextUtils.isEmpty((address_field.getText().toString()))){
            Log.d(log_tag, "name_field is empty");
            post_form = false;
        }else{
            address = address_field.getText().toString();
        }

        if(post_form){
            Log.d(log_tag, "All form fields filled in correctly");
            Intent post_form_intent = new Intent(MainActivity.this, PostForm.class);
            post_form_intent.putExtra("NAME_STRING", name);
            post_form_intent.putExtra("PHONE_STRING", phone);
            post_form_intent.putExtra("EMAIL_STRING", email);
            post_form_intent.putExtra("ADDRESS_STRING", address);
            startActivity(post_form_intent);
        }
    }
}
