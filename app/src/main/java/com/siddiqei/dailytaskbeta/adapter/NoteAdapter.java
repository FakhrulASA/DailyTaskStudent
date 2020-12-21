package com.siddiqei.dailytaskbeta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.model.ClassListModel;
import com.siddiqei.dailytaskbeta.model.NoteModel;
import com.siddiqei.dailytaskbeta.ui.MainActivity;

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
        FirebaseAuth firebaseAuth;
        firebaseAuth=FirebaseAuth.getInstance();
        String userid=firebaseAuth.getCurrentUser().getUid();
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("courselist").document(userid).collection("notes").document(posts.get(position).getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context,"Note Deleted",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context,MainActivity.class);
                        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);


                    }
                });
            }
        });

    }
    //how many item
    @Override
    public int getItemCount() {
        return posts.size();
    }
    //declaring the value
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,note;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize
            title=itemView.findViewById(R.id.title_list_note);
            note=itemView.findViewById(R.id.note_list_note);
            delete=itemView.findViewById(R.id.delete_note);
        }
    }
}
