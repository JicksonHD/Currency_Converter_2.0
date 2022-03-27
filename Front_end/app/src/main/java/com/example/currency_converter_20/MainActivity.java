package com.example.currency_converter_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name;
    ImageView converter_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);

        converter_logo = (ImageView) findViewById(R.id.converter);
        converter_logo.setTranslationX(-1000);
        converter_logo.animate().translationXBy(1000).setDuration(2000);
    }
}