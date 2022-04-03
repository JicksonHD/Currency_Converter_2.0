package com.example.currency_converter_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity2 extends AppCompatActivity {

    //Declaring variables that are used in the UI
    EditText lebanese;
    EditText usa;
    TextView result;
    Button convert;
    int amount;

    public class DownloadTask extends AsyncTask<String, Void, String> {// retrieving data from first API
        protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection http;

            try{
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader =  new InputStreamReader(in);

                OutputStream out = http.getOutputStream();

                int data = reader.read();
                while( data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;

            }catch(Exception e){
                e.printStackTrace();
                return null;
            }


        }
        protected void onPostExecute(String s){


            try {
                JSONObject json = new JSONObject(s);
                String created = json.getString("buy_rate");// string created contains the second API
                amount = Integer.parseInt(created);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Initilizing variables
        lebanese = (EditText) findViewById(R.id.lebanese);
        usa = (EditText) findViewById(R.id.usa);
        result = (TextView) findViewById(R.id.result);
        convert = (Button) findViewById(R.id.converter);

        //Getting information from page 1 (Enter your name)
        Intent x = getIntent();
        String name = x.getStringExtra("name");
        Toast.makeText(getApplicationContext(),"hello " + name, Toast.LENGTH_LONG).show();

        String url = "http://192.168.0.113/lau/project/Currency_Converter_2.0/back_end/project.php";//url to api

        DownloadTask task = new DownloadTask();
        task.execute(url);
    }

    //OnClick Method
    public void converter (View view){

        //Initilizing the output for the lebanese rate and the dollar rate to 0
        double output_lebanese = 0;
        double output_usa = 0;

        if (lebanese.getText().toString().equalsIgnoreCase("") && !(usa.getText().toString().equalsIgnoreCase(""))){

            //If user entered an amount in $ and wants to convert to LBP

            double input_usd = Double.parseDouble(usa.getText().toString());
            output_lebanese = input_usd*amount;
            lebanese.setText(output_lebanese + " LBP");
            result.setText("");

        }

        else if (usa.getText().toString().equalsIgnoreCase("") && !(lebanese.getText().toString().equalsIgnoreCase(""))){

            //If user entered an amount in LBP and wants to convert to $

            double input_lbp = Double.parseDouble(lebanese.getText().toString());
            output_usa = input_lbp/amount;
            usa.setText(output_usa + " $");
            result.setText("");

        }

        else if ((lebanese.getText().toString().equalsIgnoreCase("")) && (usa.getText().toString().equalsIgnoreCase(""))){

            //If user did not enter anything and wants to convert he/she will be notified to enter at least one of the currencies to convert to another

            Toast.makeText(getApplicationContext(),"You must enter at least one of the currencies",Toast.LENGTH_LONG).show();
        }
    }


}