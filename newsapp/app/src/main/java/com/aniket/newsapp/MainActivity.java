package com.aniket.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<item> allpost;
    RecyclerView recyclerview;
    RequestQueue reqQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allpost = new ArrayList<>();
        recyclerview = findViewById(R.id.recyclerview);
        reqQue = Volley.newRequestQueue(this);
        allpost = new ArrayList<>();
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        parsejson();
    }

    void parsejson(){
//        String url = "https://www.amitbhawani.com/wp-json/wp/v2/posts/";
        String url = "https://www.amitbhawani.com/wp-json/wp/v2/posts/";
        JsonArrayRequest postsreq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getValue(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),30000).show();
            }
        });
        reqQue.add(postsreq);
    }

    void getValue(JSONArray arrayOfPosts){
        Toast.makeText(MainActivity.this,"hello",3000).show();
        String imgurl=null,des=null,posttitle=null;
        for(int i=0;i<arrayOfPosts.length();i++)
        {
            try{
                JSONObject post = arrayOfPosts.getJSONObject(i);
                JSONObject postTitle = post.getJSONObject("title");
                posttitle = postTitle.getString("rendered");
                JSONObject postdes = post.getJSONObject("content");
                des = postdes.getString("rendered");
                imgurl = post.getString("jetpack_featured_media_url");
                Toast.makeText(MainActivity.this,imgurl,3000).show();
            }catch (Exception e){

            }
            item myitem = new item(imgurl,posttitle,des);
            allpost.add(myitem);

        }
        recyclerview.setAdapter(new adapter(allpost,this));
    }
}
