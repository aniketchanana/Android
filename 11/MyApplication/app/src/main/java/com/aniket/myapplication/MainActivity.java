package com.aniket.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Button call,message,browser,watsapp,thirdactivity;
    RatingBar r;
    Button rateBtn,progress,alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.ratingbar);
        rateBtn = findViewById(R.id.rate);
        progress = findViewById(R.id.progress);
        alert = findViewById(R.id.alert);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showalert();
            }
        });
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog p = new ProgressDialog(MainActivity.this);
                p.setMessage("Loading");
                p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                p.setCancelable(false);
                p.setProgress(10);
                p.setMax(50);
                p.show();
            }
        });
        rateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(r.getRating());
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_SHORT).show();
            }
        });
//        call = findViewById(R.id.call);
//        browser = findViewById(R.id.browser);
//        message = findViewById(R.id.message);
//        watsapp = findViewById(R.id.watsapp);
//        thirdactivity = findViewById(R.id.third);
//        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
//        {
//            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},10);
//        }
//        call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                opencall();
//            }
//        });
//
//        browser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openbrowser();
//            }
//        });
//
//        message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                passmessage();
//            }
//        });
//
//
//        watsapp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openwatsapp();
//            }
//        });
//
//
//        thirdactivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                thirdactivity();
//            }
//        });
    }
    public void showalert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to log out");
        builder.setTitle("ALERT!!");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"yes clicked",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"No clicked",Toast.LENGTH_SHORT);
                dialogInterface.cancel();
            }
        });

        AlertDialog alertBox = builder.show();
        alertBox.show();
    }
//    public void opencall(){
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse("tel:9588195330"));
//        startActivity(intent);
//    }
//
//    public void openbrowser(){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://learncodeonline.in"));
//        startActivity(intent);
//    }
//
//
//    public void openwatsapp(){
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(intent.EXTRA_TEXT,"hello guys how are you");
//        intent.setType("text/plain");
//        intent.setPackage("com.whatsapp");
//        startActivity(intent);
//    }
//
//    public void passmessage(){
//        Intent intent = new Intent(this,Main2Activity.class);
//        intent.putExtra("name","aniket");
//        startActivity(intent);
//
//    }

//    public void thirdactivity(){
//        Intent intent = new Intent(this,thirdactivity.class);
//        startActivity(intent);
//    }

}
