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

    //Declaring variables that are used in the UI
    EditText lebanese;
    EditText usa;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Initilizing variables
        lebanese = (EditText) findViewById(R.id.lebanese);
        usa = (EditText) findViewById(R.id.usa);
        result = (TextView) findViewById(R.id.result);
        

        //Getting information from page 1 (Enter your name)
        Intent x = getIntent();
        String name = x.getStringExtra("name");
        Toast.makeText(getApplicationContext(),"hello " + name, Toast.LENGTH_LONG).show();


    }

    //OnClick Method
    public void converter (View view){

        //Initilizing the output for the lebanese rate and the dollar rate to 0
        double output_lebanese = 0;
        double output_usa = 0;

        if (lebanese.getText().toString().equalsIgnoreCase("") && !(usa.getText().toString().equalsIgnoreCase(""))){

            //If user entered an amount in $ and wants to convert to LBP
            //dollar rate is 25k for testing the program (actual rate will be fetched with the help of the API)

            double input_usd = Double.parseDouble(usa.getText().toString());
            output_lebanese = input_usd*25000;
            lebanese.setText(output_lebanese + " LBP");
            result.setText("");

        }

        else if (usa.getText().toString().equalsIgnoreCase("") && !(lebanese.getText().toString().equalsIgnoreCase(""))){

            //If user entered an amount in LBP and wants to convert to $
            //dollar rate is 25k for testing the program (actual rate will be fetched with the help of the API)

            double input_lbp = Double.parseDouble(lebanese.getText().toString());
            output_usa = input_lbp/25000;
            usa.setText(output_usa + " $");
            result.setText("");

        }

        else if ((lebanese.getText().toString().equalsIgnoreCase("")) && (usa.getText().toString().equalsIgnoreCase(""))){

            //If user did not enter anything and wants to convert he/she will be notified to enter at least one of the currencies to convert to another

            Toast.makeText(getApplicationContext(),"You must enter at least one of the currencies",Toast.LENGTH_LONG).show();
        }
    }


}