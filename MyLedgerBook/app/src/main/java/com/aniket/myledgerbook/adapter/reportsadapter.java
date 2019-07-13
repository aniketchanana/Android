package com.aniket.myledgerbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniket.myledgerbook.R;
import com.aniket.myledgerbook.models.*;
import java.util.ArrayList;

public class reportsadapter extends RecyclerView.Adapter<reportsadapter.viewholder> {

    ArrayList<report> array = new ArrayList<>();
    Context context;

    public reportsadapter(ArrayList<report> array, Context context){
        this.array = array;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reportview,parent,false);
        return new reportsadapter.viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.reportName.setText(Character.toUpperCase(array.get(position).getName().toString().charAt(0))+array.get(position).getName().toString().substring(1));
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView reportName;
        ImageView reportImage;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            reportName = itemView.findViewById(R.id.report_name);
            reportImage = itemView.findViewById(R.id.report_pdf);

            reportImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });
        }
    }
}
