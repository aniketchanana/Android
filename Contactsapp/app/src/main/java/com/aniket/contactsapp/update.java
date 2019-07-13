package com.aniket.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aniket.contactsapp.Database.DatabaseHelper;

public class update extends AppCompatActivity {
    TextView name,email,phone,address;

    Button updatebtn,deletebtn;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = findViewById(R.id.update_name);
        email = findViewById(R.id.update_email);
        phone = findViewById(R.id.update_phonenumber);
        address = findViewById(R.id.update_address);
        updatebtn = findViewById(R.id.update_button);
        deletebtn = findViewById(R.id.delete_btn);
        db = new DatabaseHelper(this);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.update(Integer.parseInt(getIntent().getStringExtra("id")),name.getText().toString(),
                        email.getText().toString(),
                        phone.getText().toString(),
                        address.getText().toString());
                startActivity(new Intent(update.this,MainActivity.class));
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(update.this,getIntent().getStringExtra("id"),3000).show();
                db.delete(Integer.parseInt(getIntent().getStringExtra("id")));
                startActivity(new Intent(update.this,MainActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");

        this.name.setText(name);
        this.email.setText(email);
        this.phone.setText(phone);
        this.address.setText(address);
    }
}
