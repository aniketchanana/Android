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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class addnotes extends AppCompatActivity {
    private DatabaseReference dbrfrnc;
    EditText title,description;
    Button submitbtn;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collection = db.collection("tasks");

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
        collection.add(mytask)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(addnotes.this,"success",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(addnotes.this,"error",Toast.LENGTH_LONG).show();
                    }
                });
//        dbrfrnc.child("tasks").child(id).setValue(mytask).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                Toast.makeText(addnotes.this,"Data added succesfully",Toast.LENGTH_LONG).show();
//                startActivity(new Intent(addnotes.this,MainActivity.class));
//            }
//        });
    }
}
