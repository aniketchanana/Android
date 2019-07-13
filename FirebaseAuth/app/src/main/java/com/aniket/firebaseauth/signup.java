package com.aniket.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    EditText email,password;
    Button signup;
    private FirebaseAuth fireBaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.bsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString();
                String mail = email.getText().toString();
                if(mail.length()>=6 && pass.length()>=6)
                {
                    signUp(mail,pass);
                }
                else
                {
                    return;
                }
            }
        });
    }
    void signUp(String mail,String password)
    {
        //this will get your firbase url to you and help
        // you to send and recieve data
        fireBaseAuth = FirebaseAuth.getInstance();
        fireBaseAuth.createUserWithEmailAndPassword(mail,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(signup.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(signup.this, "ERROR!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
