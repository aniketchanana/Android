package com.aniket.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView display;
    EditText location;
    Button queryBtn;

    String URL ;

    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        location = findViewById(R.id.editText);
        queryBtn = findViewById(R.id.querybtn);



        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });
    }

    void getdata(){
        URL = "https://api.openweathermap.org/data/2.5/forecast?q="+location.getText().toString()+"&appid=7ff40f113655ea0e80b1937829187ed4";
        JsonObjectRequest request = new JsonObjectRequest( URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("list");
                            JSONObject myobj = array.getJSONObject(0);
                            showData(myobj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                display.setText(error.getMessage());
                error.printStackTrace();
            }
        });

        mQueue = Volley.newRequestQueue(this);
        mQueue.add(request);
    }

    void showData(JSONObject weather){
        JSONObject mainWeather = null;
        JSONArray prediction = null;
        String des = "";
        try {
            mainWeather = weather.getJSONObject("main");
            prediction = weather.getJSONArray("weather");
            JSONObject myweather = prediction.getJSONObject(0);
            des = myweather.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String report = null;
        try {
            report = "In " + location.getText().toString() + " temp is " + String.valueOf(mainWeather.getInt("temp_max") -273) + " with " + des;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        display.setText(report);
    }

}
