package adapter;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aniket.todoapp.*;
import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.taskviewholder> {
    ArrayList<task> mylist;
    private Context context;
    public adapter(ArrayList<task> mylist,Context context)
    {

        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public taskviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view,parent,false);
        return new taskviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull taskviewholder holder, int position) {
        task mytask = mylist.get(position);

        holder.description.setText(mytask.description);
        holder.title.setText(mytask.title);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }


    class taskviewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        public taskviewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleview);
            description = itemView.findViewById(R.id.descriptionview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    task new_task = mylist.get(getAdapterPosition());
                    Intent i = new Intent(context,view_details.class);
                    i.putExtra("title",new_task.description);
                    i.putExtra("description",new_task.title);
                    i.putExtra("id",new_task.id);

                    context.startActivity(i);
                }
            });
        }
    }
}


