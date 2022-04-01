package com.example.currency_converter_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText lebanese;
    EditText usa;
    TextView result;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lebanese = (EditText) findViewById(R.id.lebanese);
        usa = (EditText) findViewById(R.id.usa);
        result = (TextView) findViewById(R.id.result);
        convert = (Button) findViewById(R.id.converter);

        Intent x = getIntent();
        String name = x.getStringExtra("name");
        Toast.makeText(getApplicationContext(),"hello " + name, Toast.LENGTH_LONG).show();


    }

    public void converter (View view){

        double output_lebanese = 0;
        double output_usa = 0;

        if (lebanese.getText().toString().equalsIgnoreCase(null) && !(usa.getText().toString().equalsIgnoreCase(null))){

            double input_usd = Double.parseDouble(usa.getText().toString());
            output_lebanese = input_usd*25000;
            lebanese.setText(output_lebanese + " LBP");

        }

        else if (usa.getText().toString().equalsIgnoreCase(null) && !(lebanese.getText().toString().equalsIgnoreCase(null))){

            double input_lbp = Double.parseDouble(lebanese.getText().toString());
            output_usa = input_lbp/25000;
            usa.setText(output_usa + " $");

        }

        else if (!(lebanese.getText().toString().equalsIgnoreCase(null)) && !(usa.getText().toString().equalsIgnoreCase(null))){

            result.setText("You must enter either in LBP or in $");
        }
    }


}