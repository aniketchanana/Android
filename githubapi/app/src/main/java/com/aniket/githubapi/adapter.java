package com.aniket.githubapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniket.githubapi.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    ArrayList<User> allusers;
    private Context context;

    public adapter(ArrayList<User> allusers, Context context){
        this.context = context;
        this.allusers = allusers;
    }
    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view,parent,false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        User new_user = allusers.get(position);
        holder.t1.setText(new_user.getLogin());
        holder.t2.setText(new_user.getType());
        Picasso.get().load(new_user.getAvatarUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return allusers.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        ImageView image;
        public holder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            image = itemView.findViewById(R.id.image);
        }
    }
}
