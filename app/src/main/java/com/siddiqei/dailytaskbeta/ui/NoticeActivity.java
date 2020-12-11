package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.adapter.NoteAdapter;
import com.siddiqei.dailytaskbeta.adapter.NoticeAdapter;
import com.siddiqei.dailytaskbeta.model.NoteModel;
import com.siddiqei.dailytaskbeta.model.NoticeModel;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ArrayList<NoticeModel> posts=new ArrayList<>();
    NoticeAdapter noticeAdapter;
    RecyclerView recyclerView;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        firebaseAuth=FirebaseAuth.getInstance();
        recyclerView=findViewById(R.id.rec_notice);
        String userid=FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("courselist").document("course").collection("course")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NoticeModel classListModel=new NoticeModel();
                                classListModel.setTitle(document.getData().get("title").toString());
                                classListModel.setTime(document.getData().get("time").toString());
                                classListModel.setDes(document.getData().get("des").toString());
                                posts.add(classListModel);

                            }

                            noticeAdapter = new NoticeAdapter(getApplicationContext(),posts);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recyclerView.setAdapter(noticeAdapter);
                        } else {

                        }
                    }
                });

    }
}