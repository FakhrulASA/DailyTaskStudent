package com.siddiqei.dailytaskbeta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.model.NoticeModel;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    List<NoticeModel> posts;
    LayoutInflater inflater;
    Context context;


    public EventAdapter(Context ctx, List<NoticeModel> posts) {
        this.context = ctx;
        this.posts = posts;
        this.inflater = LayoutInflater.from(ctx);
    }

    //Which layout should it show
    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_list, parent, false);
        return new ViewHolder(view);
    }

    //showingdata
    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {

        holder.title.setText(posts.get(position).getTitle());
        holder.des.setText(posts.get(position).getDes());
        holder.time.setText(posts.get(position).getTime());

    }

    //how many item
    @Override
    public int getItemCount() {
        return posts.size();
    }

    //declaring the value
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, time, des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize
            title = itemView.findViewById(R.id.event_title);
            time = itemView.findViewById(R.id.event_time);
            des = itemView.findViewById(R.id.event_descriptiton);

        }
    }
}
