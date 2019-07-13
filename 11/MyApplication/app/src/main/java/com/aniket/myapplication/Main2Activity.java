package com.aniket.myapplication;


import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        WebView web = findViewById(R.id.webview);
        web.loadUrl("https://punjab.chitkara.edu.in//Interface/index.php");
        web.setWebViewClient(new WebViewClient());
    }
}

