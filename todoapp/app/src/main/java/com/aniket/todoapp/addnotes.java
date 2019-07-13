package com.aniket.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addnotes extends AppCompatActivity {
    private DatabaseReference dbrfrnc;
    EditText title,description;
    Button submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnotes);
        dbrfrnc = FirebaseDatabase.getInstance().getReference();
        title = findViewById(R.id.title_note);
        description = findViewById(R.id.des);
        submitbtn = findViewById(R.id.submitbtn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnote();
            }
        });
    }

    void addnote(){
        String id = dbrfrnc.child("tasks").push().getKey();
        task mytask = new task(description.getText().toString(),title.getText().toString(),id);
        dbrfrnc.child("tasks").child(id).setValue(mytask).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(addnotes.this,"Data added succesfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(addnotes.this,MainActivity.class));
            }
        });
    }
}
