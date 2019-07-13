package com.aniket.newsapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    ArrayList<item> allitems = new ArrayList<>();
    private Context context;
    public adapter(ArrayList<item> allitems,@NonNull Context context) {
        this.context = context;
        this.allitems = allitems;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.itemview,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        item new_item = allitems.get(position);
        holder.postTitle.setText(new_item.title);
        holder.postdescription.setText(new_item.description);

        Picasso.get().load(new_item.image == "" ? "http://www.amitbhawani.com/wp-content/uploads/2017/02/Fitness-Secret-Strategy-Amit-Bhawani.png":new_item.image).into(holder.postImage);
    }

    @Override
    public int getItemCount() {
        return allitems.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        ImageView postImage;
        TextView postTitle,postdescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            postImage = itemView.findViewById(R.id.postimage);
            postTitle = itemView.findViewById(R.id.posttitle);
            postdescription = itemView.findViewById(R.id.postdes);
        }
    }

}
