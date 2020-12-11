package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.adapter.ClassAdapter;
import com.siddiqei.dailytaskbeta.model.ClassListModel;

import java.util.ArrayList;

public class ClassListActivity extends AppCompatActivity {
    RecyclerView class_recycle;
    Button addCourse;
    ClassAdapter classAdapter;
    ArrayList<ClassListModel> posts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        class_recycle=findViewById(R.id.course_recycler);
        addCourse=findViewById(R.id.button_add_course);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddCourseActivity.class));
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("courselist")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ClassListModel classListModel=new ClassListModel();
                                classListModel.setName(document.getData().get("courseName").toString()+"-"+document.getData().get("teacherInitial").toString());
                                classListModel.setDays(document.getData().get("classDay").toString());
                                classListModel.setTime(document.getData().get("clasStarts").toString()+"-"+document.getData().get("classEnds").toString());
                                classListModel.setTeacher("");
                                posts.add(classListModel);

                            }

                            classAdapter = new ClassAdapter(getApplicationContext(),posts);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
                            class_recycle.setLayoutManager(gridLayoutManager);
                            class_recycle.setAdapter(classAdapter);
                        } else {

                        }
                    }
                });




    }
}