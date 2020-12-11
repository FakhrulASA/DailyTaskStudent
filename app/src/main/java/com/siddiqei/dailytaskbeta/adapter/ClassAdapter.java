package com.siddiqei.dailytaskbeta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.model.ClassListModel;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    List<ClassListModel> posts;
    LayoutInflater inflater;
    Context context;

    public ClassAdapter(Context ctx, List<ClassListModel> posts) {
        this.context=ctx;
        this.posts = posts;
        this.inflater = LayoutInflater.from(ctx);
    }

    //Which layout should it show
    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_list,parent,false);
        return new ViewHolder(view);
    }
    //showingdata
    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.ViewHolder holder, int position) {
          holder.subject.setText(posts.get(position).getName());
          holder.time.setText(posts.get(position).getTime());
          holder.day.setText(posts.get(position).getDays());
    }
    //how many item
    @Override
    public int getItemCount() {
        return posts.size();
    }
    //declaring the value
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,teacher,time,day;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize
            subject=itemView.findViewById(R.id.subject_text);
            time=itemView.findViewById(R.id.time_text);
            day=itemView.findViewById(R.id.day_text);
        }
    }
}
