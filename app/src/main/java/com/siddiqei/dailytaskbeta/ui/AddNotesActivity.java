package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.siddiqei.dailytaskbeta.R;

import java.util.HashMap;
import java.util.Map;

public class AddNotesActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    TextView title,note;
    String userID;
    Button addnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        title=findViewById(R.id.note_title);
        note=findViewById(R.id.note_note);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        userID=firebaseAuth.getCurrentUser().getUid();
        addnote=findViewById(R.id.button_add_note);
        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> course= new HashMap<>();
                course.put("title",title.getText().toString());
                course.put("note",note.getText().toString());


                firebaseFirestore.collection("courselist").document(userID).collection("notes")
                        .add(course)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(AddNotesActivity.this,"Successfully Added",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),NotesActivity.class));
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddNotesActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });

    }
}