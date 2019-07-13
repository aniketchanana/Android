package com.aniket.webcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.app.AlertDialog;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,Window.PROGRESS_VISIBILITY_ON);
        WebView web = findViewById(R.id.webview);
//        Bundle bundle =getIntent().getExtras();
//        String key = bundle.getString("key");
//        String key1=bundle.getString("key1");
//        Toast.makeText(getApplicationContext(),key +key1,Toast.LENGTH_SHORT).show();

//        Toast.makeText(getApplicationContext(),key+key1,Toast.LENGTH_SHORT).show();
        String url = getIntent().getStringExtra("url");
        web.loadUrl(url);

        web.getSettings().setJavaScriptEnabled(true);
        final ProgressDialog p = new ProgressDialog(this);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                p.setMessage("Loading...");
                p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                p.setCancelable(false);
                p.show();
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                p.cancel();
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
    }
}
