package com.aniket.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager myLayoutManager;
    ArrayList<item> itemList;
    Button insertbtn,removebtn;
    TextView inserttxt,removetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecyclerView();
        insertbtn = findViewById(R.id.insertbtn);
        removebtn = findViewById(R.id.removebtn);

        inserttxt = findViewById(R.id.inserttext);
        removetxt = findViewById(R.id.removetext);

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToList(Integer.parseInt(inserttxt.getText().toString()));
            }
        });

        removebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFromList(Integer.parseInt(removetxt.getText().toString()));
            }
        });

    }

    private void createRecyclerView()
    {
        itemList = new ArrayList<>();
        itemList.add(new item(R.drawable.ic_announcement_black_24dp, "Line 1", "Line 222222222222222222222222222222222222222222222"));
        itemList.add(new item(R.drawable.ic_announcement_black_24dp, "Line 1", "Line 2"));
        itemList.add(new item(R.drawable.ic_announcement_black_24dp, "Line 1", "Line 2"));
        itemList.add(new item(R.drawable.ic_announcement_black_24dp, "Line 1", "Line 2"));

        myrecyclerview = findViewById(R.id.recyclerview);
        myrecyclerview.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myadapter = new adapter(itemList);

        myrecyclerview.setLayoutManager(myLayoutManager);
        myrecyclerview.setAdapter(myadapter);
    }

    private void addToList(int pos)
    {
        itemList.add(pos,new item(R.drawable.ic_announcement_black_24dp, "Line 1", "Line 2"));
        myadapter.notifyItemInserted(pos);
    }

    private void removeFromList(int pos)
    {
        itemList.remove(pos);
        myadapter.notifyItemRemoved(pos);
    }
}
