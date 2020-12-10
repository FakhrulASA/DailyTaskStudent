package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.siddiqei.dailytaskbeta.R;

import java.util.HashMap;
import java.util.Map;

public class AddCourseActivity extends AppCompatActivity {
    EditText courseName, teacherInitial, clasStarts, classEnds;
    Spinner classDay;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String[] days={"Friday","Saturday","Sunday","Moneday","Tuesday","Wednesday","Thursday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        courseName=findViewById(R.id.course_name_add_course);
        teacherInitial=findViewById(R.id.teacher_initial_addcourse);
        clasStarts=findViewById(R.id.class_start_add_course);
        classEnds=findViewById(R.id.end_time_addcourse);
        classDay=findViewById(R.id.day_addcourse);
        Button button=findViewById(R.id.button_add_course);
        firebaseFirestore=FirebaseFirestore.getInstance();

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(getApplicationContext(),   android.R.layout.simple_spinner_item, days);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        classDay.setAdapter(spinnerArrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> course= new HashMap<>();
                course.put("courseName",courseName.getText().toString());
                course.put("teacherInitial",teacherInitial.getText().toString());
                course.put("clasStarts",clasStarts.getText().toString());
                course.put("classEnds",classEnds.getText().toString());
                course.put("classDay",classDay.getSelectedItem().toString());

                firebaseFirestore.collection("courselist")
                        .add(course)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(AddCourseActivity.this,"Successfully Added",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(AddCourseActivity.this,CourseListActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddCourseActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });

    }
}