package com.aniket.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aniket.githubapi.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView r;
    ArrayList<User> user_List;
    String URL_DATA = "https://api.github.com/users";
    RequestQueue reqQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.recyclerview);

        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setItemAnimator(new DefaultItemAnimator());
        r.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        user_List = new ArrayList<>();
        loadurl();
    }

    public void loadurl(){

        JsonArrayRequest stringRequest = new JsonArrayRequest(URL_DATA, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getValue(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        reqQue = Volley.newRequestQueue(this);
        reqQue.add(stringRequest);
    }
    public void getValue(JSONArray array){
        for(int i=0;i<array.length();i++){
            User userlist = new User();
            JSONObject json = null;
            try{
                json = array.getJSONObject(i);
                userlist.setLogin(json.getString("login"));
                userlist.setAvatarUrl(json.getString("avatar_url"));
            }catch (Exception e){

            }
            user_List.add(userlist);
        }
        r.setAdapter(new adapter(user_List,MainActivity.this));
    }
}
