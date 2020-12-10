package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.siddiqei.dailytaskbeta.R;

public class ClassListActivity extends AppCompatActivity {
    RecyclerView class_recycle;
    Button addCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        class_recycle=findViewById(R.id.course_recycler);
        addCourse=findViewById(R.id.button_add_course);

    }
}