package com.aniket.ledgerbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button login,signUp;
    EditText email,pass;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    String namedb,emaildb,phonedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_btn);
        signUp = findViewById(R.id.signup_btn);

        email = findViewById(R.id.email_txt);
        pass = findViewById(R.id.password_txt);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String password = pass.getText().toString();
                if(mail.equals("")){
                    email.setError("Field can't be empty");
                }else if(password.equals("")){
                    pass.setError("Field can't be empty");
                }
                else {
                    log_into_app(mail,password);
                }
            }
        });
    }
    private void log_into_app(String mail,String password){

        final ProgressDialog p = new ProgressDialog(this);
        p.setMessage("Loading...");
        p.show();
        p.setCancelable(false);
        mAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            p.cancel();
                            updateUI();
                        } else {
                            p.cancel();
                            Toast.makeText(Login.this, "Not a verified user",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();
        updateUI();
    }
    void updateUI(){
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if(mUser != null && mUser.isEmailVerified()){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }
}
