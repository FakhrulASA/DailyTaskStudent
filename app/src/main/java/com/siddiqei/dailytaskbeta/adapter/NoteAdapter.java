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
import com.siddiqei.dailytaskbeta.model.NoteModel;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<NoteModel> posts;
    LayoutInflater inflater;
    Context context;

    public NoteAdapter(Context ctx, List<NoteModel> posts) {
        this.context=ctx;
        this.posts = posts;
        this.inflater = LayoutInflater.from(ctx);
    }

    //Which layout should it show
    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_list,parent,false);
        return new ViewHolder(view);
    }
    //showingdata
    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.title.setText(posts.get(position).getTitle());
        holder.note.setText(posts.get(position).getNote());

    }
    //how many item
    @Override
    public int getItemCount() {
        return posts.size();
    }
    //declaring the value
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,note;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize
            title=itemView.findViewById(R.id.title_list_note);
            note=itemView.findViewById(R.id.note_list_note);
        }
    }
}
