package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loginBtn = findViewById(R.id.blogin);
        email = findViewById(R.id.email);
        password=findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_SHORT).show();
                String emailid,pass;
                emailid = email.getText().toString();
                pass = password.getText().toString();
                Toast.makeText(getApplicationContext(),"button clicked"+emailid+" "+pass,Toast.LENGTH_SHORT).show();
            }
        });
    }
}mmmmmmmmmmm
