package com.aniket.myledgerbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aniket.myledgerbook.models.Customer;
import com.aniket.myledgerbook.models.records;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class outgoingcash extends AppCompatActivity {
    TextView out;
    Button submitout;
    String money;
    DatabaseReference db;
    String id;
    FirebaseAuth mAuth;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outgoingcash);
        id = getIntent().getStringExtra("id");

        mAuth = FirebaseAuth.getInstance();
        email = mAuth.getCurrentUser().getEmail();
        email = email.replace("@","");
        email = email.replace(".","");

        db = FirebaseDatabase.getInstance().getReference("records").child(email).child(id);
        out = findViewById(R.id.out);
        submitout = findViewById(R.id.submitout);

        submitout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money = out.getText().toString();
                savetodb();
            }
        });
    }

    void savetodb(){
        String key = db.push().getKey();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String transaction_id = dtf.format(now);
        transaction_id = transaction_id.replace("/","-");
        db.child(key).setValue(new records(money,transaction_id));

        final DatabaseReference dbcustref = FirebaseDatabase.getInstance().getReference("customers")
                .child(email).child(id);
        dbcustref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Customer updatecust = dataSnapshot.getValue(Customer.class);
                updatecust.updateoutcashPending(Integer.parseInt(money));
                dbcustref.setValue(updatecust);
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
