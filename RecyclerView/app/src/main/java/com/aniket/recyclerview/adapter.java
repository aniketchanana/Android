package com.aniket.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    private ArrayList<item> mylist;
    public adapter(ArrayList<item> mylist){
        this.mylist = mylist;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        viewholder vh = new viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        item currentitem = mylist.get(position);

        holder.mytext2.setText(currentitem.getText1());
        holder.mytext1.setText(currentitem.getText2());
        holder.myimg.setImageResource(currentitem.getImage());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        public ImageView myimg;
        public TextView mytext1;
        public TextView mytext2;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            myimg = itemView.findViewById(R.id.myimg);
            mytext1 = itemView.findViewById(R.id.mytext1);
            mytext2 = itemView.findViewById(R.id.mytext2);
        }
    }
}
