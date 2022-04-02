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
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    EditText lebanese;
    EditText usa;
    TextView result;
    Button convert;

    public class DownloadTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection http;

            try{
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader =  new InputStreamReader(in);
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
                String created = json.getString("buy_rate");
                int amount =
                        Log.i("buy", created);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

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

        String url = "http://192.168.0.113/lau/project/Currency_Converter_2.0/back_end/project.php";

        DownloadTask task = new DownloadTask();
        task.execute(url);
    }

    public void converter (View view){

        double output_lebanese = 0;
        double output_usa = 0;

        if (lebanese.getText().toString().equalsIgnoreCase("") && !(usa.getText().toString().equalsIgnoreCase(""))){

            double input_usd = Double.parseDouble(usa.getText().toString());
            output_lebanese = input_usd*25000;
            lebanese.setText(output_lebanese + " LBP");

        }

        else if (usa.getText().toString().equalsIgnoreCase("") && !(lebanese.getText().toString().equalsIgnoreCase(""))){

            double input_lbp = Double.parseDouble(lebanese.getText().toString());
            output_usa = input_lbp/25000;
            usa.setText(output_usa + " $");

        }

        else if ((lebanese.getText().toString().equalsIgnoreCase("")) && (usa.getText().toString().equalsIgnoreCase(""))){

            result.setText("You must enter either in LBP or in $");
        }
    }


}