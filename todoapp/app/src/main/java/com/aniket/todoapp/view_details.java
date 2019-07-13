package com.aniket.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class view_details extends AppCompatActivity {
    Button  update_btn , delete_btn;
    EditText update_title , update_des;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        update_title = findViewById(R.id.update_title_notes);
        update_des = findViewById(R.id.update_des);
        update_btn = findViewById(R.id.update_btn);
        delete_btn = findViewById(R.id.delete_btn);

        String title = getIntent().getStringExtra("title");
        String des = getIntent().getStringExtra("description");
        final String id = getIntent().getStringExtra("id");

        update_des.setText(des);
        update_title.setText(title);

        db = FirebaseDatabase.getInstance().getReference();
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(id);
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(id);
            }
        });
    }

    void update(String id)
    {
        String title_send = update_title.getText().toString();
        String des_send = update_des.getText().toString();

        task mytask = new task(des_send,title_send,id);

        db.child("tasks").child(id).setValue(mytask);

        startActivity(new Intent(this,MainActivity.class));
    }

    void delete(String id)
    {
        db.child("tasks").child(id).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        startActivity(new Intent(view_details.this,MainActivity.class));
                    }
                });
    }
}
