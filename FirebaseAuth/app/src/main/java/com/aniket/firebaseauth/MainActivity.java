package com.aniket.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button blogin,signup,forget;
    ProgressDialog progressDialog;
    TextView t;
//    private FirebaseAuth fireBaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        blogin = findViewById(R.id.blogin);
        signup = findViewById(R.id.bsignup);
        forget = findViewById(R.id.bforget);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString();
                String mail = username.getText().toString();
                if(pass.length()>=6 && mail.length()>=6)
                {
                    logIn(mail,pass);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });
    }
    void logIn(String email, String password)
    {

        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        FirebaseAuth fireBaseAuth = FirebaseAuth.getInstance();
        fireBaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(MainActivity.this, "LogIn", Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful())
                        {
                            progressDialog.cancel();
                            Toast.makeText(MainActivity.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,welcomepage.class));
                            finish();
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "ERROR!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user;
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            finish();
//            Toast.makeText(openingpage.this,user.getEmail(),Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,welcomepage.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(MainActivity.this,"No user signed In",Toast.LENGTH_SHORT).show();
        }
    }
}

