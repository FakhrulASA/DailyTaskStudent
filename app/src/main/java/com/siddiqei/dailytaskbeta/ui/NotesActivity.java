package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.adapter.ClassAdapter;
import com.siddiqei.dailytaskbeta.adapter.NoteAdapter;
import com.siddiqei.dailytaskbeta.model.ClassListModel;
import com.siddiqei.dailytaskbeta.model.NoteModel;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    FirebaseAuth firebaseAuth;
    ArrayList<NoteModel> posts=new ArrayList<>();
    NoteAdapter noteAdapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        firebaseAuth=FirebaseAuth.getInstance();
        String userid=firebaseAuth.getCurrentUser().getUid();
        recyclerView=findViewById(R.id.note_recycler);
        add=findViewById(R.id.button_add_note);
        swipeRefreshLayout=findViewById(R.id.sra);
        swipeRefreshLayout.setOnRefreshListener(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddNotesActivity.class));
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("courselist").document(userid).collection("notes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NoteModel classListModel=new NoteModel();
                                classListModel.setNote(document.getData().get("note").toString());
                                classListModel.setTitle(document.getData().get("title").toString());
                                classListModel.setId(document.getId());
                                posts.add(classListModel);

                            }

                            noteAdapter = new NoteAdapter(getApplicationContext(),posts);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recyclerView.setAdapter(noteAdapter);
                        } else {

                        }
                    }
                });

    }

    @Override
    public void onRefresh() {
        startActivity(new Intent(getApplicationContext(),NotesActivity.class));
        finish();
    }
}