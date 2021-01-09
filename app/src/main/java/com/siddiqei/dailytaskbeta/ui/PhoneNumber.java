package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.siddiqei.dailytaskbeta.R;
import com.siddiqei.dailytaskbeta.model.ShowModel;

import java.util.ArrayList;

public class PhoneNumber extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    ListView show;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        Button ad=findViewById(R.id.addcontact);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Teachers");
        show=(ListView)findViewById(R.id.showlist);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        show.setAdapter(arrayAdapter);
ad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),AddValue.class));
    }
});

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(ShowModel.class).toString();
                arrayList.add(value);

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


        show.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                FirebaseDatabase.getInstance().getReference().child("diulifehacks").child("Teachers").child(arrayAdapter.getItem(position)).removeValue();
                Toast.makeText(getApplicationContext(),"Number is Deleted",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}