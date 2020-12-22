package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.siddiqei.dailytaskbeta.R;

import java.util.HashMap;

public class AddValue extends AppCompatActivity {

    EditText addname,addphone;
    Button update;
    String showname,showphone;
    DatabaseReference sdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_value);

        addname=findViewById(R.id.addname);
        addphone=findViewById(R.id.addphone);
        update=findViewById(R.id.update);

        sdata= FirebaseDatabase.getInstance().getReference();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
            }
        });


    }

    private void adddata() {

        showname=addname.getText().toString();
        showphone=addphone.getText().toString();

        if (showname.isEmpty()){
            addname.setError("Enter yourn name");
        } else if (showphone.length()<11) {
            addphone.setError("Enter your correct phone number");
        }
        else {
            HashMap nmap=new HashMap();
            nmap.put("name",showname);
            nmap.put("phonename",showphone);
            sdata.child("Teachers").push().setValue(nmap).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                    cleartext();
                    Intent intent=new Intent(AddValue.this,MainActivity.class);
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Not Successfull", Toast.LENGTH_SHORT).show();
                    cleartext();
                    Intent  intent=new Intent(AddValue.this,AddValue.class);
                    startActivity(intent);

                }
            });



        }
    }

    private void cleartext() {
        addname.setText(" ");
        addphone.setText(" ");
    }
}