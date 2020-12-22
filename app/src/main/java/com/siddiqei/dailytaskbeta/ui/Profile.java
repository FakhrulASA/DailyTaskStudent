package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.adapter.ClassAdapter;
import com.siddiqei.dailytaskbeta.model.ClassListModel;

public class Profile extends AppCompatActivity {
    TextView name, email, phone;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button edit=findViewById(R.id.editprofile);
        name=findViewById(R.id.name_profile);
        email=findViewById(R.id.email_profile);
        phone=findViewById(R.id.phone_profile);
        firebaseAuth=FirebaseAuth.getInstance();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EditProfile.class));
            }
        });
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("courselist").document(firebaseAuth.getCurrentUser().getUid()).collection("profile")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               name.setText(document.get("name").toString());
                               phone.setText(document.get("phone").toString());
                               email.setText(firebaseAuth.getCurrentUser().getEmail());

                            }


                        } else {

                        }
                    }
                });

    }
}