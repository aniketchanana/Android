package com.aniket.burgerfeedbackform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RatingBar r;
    EditText feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.submit);
        r = findViewById(R.id.rating);
        feedback = findViewById(R.id.feedback);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(r.getRating());
                String feedbackmsg = feedback.getText().toString();
                showgreetings();
                feedback.setText("");
            }
        });
    }
    void showgreetings()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Feedback saved.")
                .setMessage("Thanks for your feedback")
                .setPositiveButton("ok", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert!!")
                .setMessage("Are sure you want to exit.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setCancelable(false)
                .setNegativeButton("cancel",null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
