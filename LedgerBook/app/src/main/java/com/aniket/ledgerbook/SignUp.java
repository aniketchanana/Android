package com.aniket.ledgerbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.UiAutomation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.aniket.ledgerbook.models.UserDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference("");
    Button create_account;
    EditText user_name,user_email,user_phone,user_password,user_password_confirm;
    String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
    String regexpass = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$";
    String name,email,phone,password,passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        create_account = findViewById(R.id.create_account);
        user_name = findViewById(R.id.user_name);
        user_email = findViewById(R.id.user_email);
        user_phone = findViewById(R.id.user_phone);
        user_password = findViewById(R.id.user_password);
        user_password_confirm = findViewById(R.id.user_password_confirm);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAccount();
            }
        });
    }

    private void createNewAccount(){
        if(!verifyDetails()){
            return;
        }
        saveInDatabase();
    }
    void sendVerificationLink(){
        mUser = mAuth.getCurrentUser();
        mUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
                alert.setTitle("Verify your email");
                alert.setMessage("Go to your email to verify your account");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        startActivity(new Intent(SignUp.this,Login.class));
//                        finish();
                    }
                });
                AlertDialog newalert = alert.create();
                newalert.show();
            }
        });
    }

    void emptyalllfields(){
        user_name.setText("");
        user_email.setText("");
        user_password_confirm.setText("");
        user_phone.setText("");
        user_password.setText("");
    }
    private void saveInDatabase(){
        final ProgressDialog p = new ProgressDialog(this);
        p.setMessage("saving details...");
        p.setCancelable(false);
        p.show();
        UserDetails newUser = new UserDetails(name,email,phone);
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        db.child(email).setValue(newUser);
        create();
    }
    private void create(){
        final ProgressDialog p = new ProgressDialog(this);
        p.setMessage("Loading...");
        p.show();
        p.setCancelable(false);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            p.cancel();
                            sendVerificationLink();
                        } else {
                            p.cancel();
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private Boolean verifyDetails(){
        //pending password strong weak confirmation
        name = user_name.getText().toString();
        email = user_email.getText().toString();
        phone = user_phone.getText().toString();
        password = user_password.getText().toString();
        passwordConfirm = user_password_confirm.getText().toString();

        if(name.equals("") || email.equals("") || phone.equals("") || password.equals("") || passwordConfirm.equals("")){
            Toast.makeText(this,"All fields are compulsory",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!(password.length()>=8)){
            //give user notice
            user_password.setError("Min 8 characters required");
            return false;
        }
        if(!email.matches(regex)){
            //give user notice
            user_email.setError("Please enter a valid email address");
            return false;
        }
        if(phone.length()!=10){
            //give user a notice
            user_phone.setError("plase enter a valid phone number");
            return false;
        }
        if(!password.equals(passwordConfirm)){
            user_password.setError("Both fiels should have same value");
            user_password_confirm.setError("Both fiels should have same value");
        }
        return true;
    }
}
