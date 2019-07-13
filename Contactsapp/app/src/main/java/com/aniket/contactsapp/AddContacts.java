package com.aniket.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aniket.contactsapp.Database.DatabaseHelper;
import com.aniket.contactsapp.model.ContactInfo;

public class AddContacts extends AppCompatActivity {
    EditText name,phone,address,email;
    Button submitbtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phonenumber);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);

        submitbtn = findViewById(R.id.button);
        db = new DatabaseHelper(this);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactInfo contact = new ContactInfo(name.getText().toString(),phone.getText().toString(),email.getText().toString(),address.getText().toString());
                boolean check = db.addContact(contact);
                if(check){
                    startActivity(new Intent(AddContacts.this,MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(AddContacts.this,"error!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
