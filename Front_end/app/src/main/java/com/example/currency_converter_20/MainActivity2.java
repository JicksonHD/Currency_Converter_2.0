package com.example.currency_converter_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent x = getIntent();
        String name = x.getStringExtra("name");
        Toast.makeText(getApplicationContext(),"hello " + name, Toast.LENGTH_LONG).show();


    }
}