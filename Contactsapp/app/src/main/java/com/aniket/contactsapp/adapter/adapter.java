package com.aniket.contactsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniket.contactsapp.*;
import com.aniket.contactsapp.model.ContactInfo;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    ArrayList<ContactInfo> allcontacts;
    private Context context;

    public adapter(ArrayList<ContactInfo> allcontacts, Context context){
        this.context = context;
        this.allcontacts = allcontacts;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ContactInfo contact = allcontacts.get(position);
        holder.contact_name.setText(contact.getName());
        holder.contact_address.setText(contact.getAddress());
        holder.contact_email.setText(contact.getEmail());
        holder.contact_phone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return allcontacts.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView contact_name,contact_phone,contact_email,contact_address;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            contact_name = itemView.findViewById(R.id.contact_name);
            contact_phone = itemView.findViewById(R.id.contact_phone);
            contact_email = itemView.findViewById(R.id.contact_email);
            contact_address = itemView.findViewById(R.id.contact_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ContactInfo contact_clicked = allcontacts.get(getAdapterPosition());
                    Intent i = new Intent(context,update.class);
                    i.putExtra("name",contact_clicked.getName());
                    i.putExtra("email",contact_clicked.getEmail());
                    i.putExtra("phone",contact_clicked.getPhone());
                    i.putExtra("address",contact_clicked.getAddress());
                    i.putExtra("id", String.valueOf(getAdapterPosition()+1));
                    context.startActivity(i);
                }
            });
        }
    }
}
