package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class EditProfile extends AppCompatActivity {
    EditText name, email, phone;
    Button save;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        name=findViewById(R.id.name_editprofile);
        email=findViewById(R.id.email_editprofile);
        phone=findViewById(R.id.phone_editprofile);
        save=findViewById(R.id.editsave);
        email.setText(firebaseAuth.getCurrentUser().getEmail());
        email.setEnabled(false);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> course= new HashMap<>();
                course.put("name",name.getText().toString());
                course.put("phone",phone.getText().toString());


                firebaseFirestore.collection("courselist").document(firebaseAuth.getCurrentUser().getUid()).collection("profile")
                        .add(course)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(EditProfile.this,"Successfully Edited",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),Profile.class));
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditProfile.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}