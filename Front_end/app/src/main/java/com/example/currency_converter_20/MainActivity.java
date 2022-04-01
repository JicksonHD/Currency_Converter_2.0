package com.example.currency_converter_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText name;
    ImageView converter_logo;

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

                }
            }catch(Exception e){

            }


            }
        protected void onPostExecute(String s){

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);

        converter_logo = (ImageView) findViewById(R.id.converter);
        converter_logo.setTranslationX(-1000);
        converter_logo.animate().translationXBy(1000).setDuration(2000);

    }

    public void start(View view){

        String entered_name = name.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra("name", entered_name);
        startActivity(intent);

        String url = "https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP&_ver=t202233120";

        DownloadTask task = new DownloadTask();
        task.execute(url);
    }
}