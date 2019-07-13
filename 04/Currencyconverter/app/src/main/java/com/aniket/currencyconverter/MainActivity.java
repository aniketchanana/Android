package com.aniket.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring button by th e type button and textview by type textview
    Button usd,yen,euro,yuan,lira,aus;
    TextView query,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //now getting the button from view to the variable of type Button(variable can hold button of view)
        usd = findViewById(R.id.dollar);
        yen = findViewById(R.id.yen);
        euro = findViewById(R.id.euro);
        yuan = findViewById(R.id.yuan);
        lira = findViewById(R.id.lira);
        aus = findViewById(R.id.aus);

        //now we will be getting textviews from the view
        query = findViewById(R.id.query);
        result = findViewById(R.id.result);

        usd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                   if((query.getText().toString() != null) | (query.getText().toString() != "")){


                       float q = Float.parseFloat(query.getText().toString());
                       q=q*0.014f;
                       result.setText(String.valueOf(q));
                   }
               }catch(Exception e){

               }
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float q = Float.parseFloat(query.getText().toString());
                    q=q*1.56f;
                    result.setText(String.valueOf(q));
                }catch (Exception e){

                }
            }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float q = Float.parseFloat(query.getText().toString());
                    q=q*0.013f;
                    result.setText(String.valueOf(q));
                }catch (Exception e){

                }
            }
        });
        yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float q = Float.parseFloat(query.getText().toString());
                    q=q*0.100f;
                    result.setText(String.valueOf(q));
                }catch (Exception e){

                }
            }
        });
        lira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float q = Float.parseFloat(query.getText().toString());
                    q=q*0.084f;
                    result.setText(String.valueOf(q));
                }catch (Exception e){

                }
            }
        });
        aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              try{
                  float q = Float.parseFloat(query.getText().toString());
                  q=q*0.021f;
                  result.setText(String.valueOf(q));
              }
              catch (Exception e){

              }
            }
        });
    }
}
