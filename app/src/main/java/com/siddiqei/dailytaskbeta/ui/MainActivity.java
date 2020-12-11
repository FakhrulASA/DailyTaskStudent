package com.siddiqei.dailytaskbeta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.siddiqei.dailytaskbeta.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout classLayout,ebookLayout,noteLayout,noticelayout,eventLayout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classLayout=findViewById(R.id.class_layout);
        ebookLayout=findViewById(R.id.ebook_layout);
       noteLayout=findViewById(R.id.note_layout);
       noticelayout=findViewById(R.id.notice_layout);
       eventLayout=findViewById(R.id.event_layout);

       classLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ClassListActivity.class));
            }
        });
        noteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NotesActivity.class));
            }
        });
        ebookLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EbookActivity.class));
            }
        });

        noticelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NoticeActivity.class));
            }
        });
        eventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EventActivity.class));
            }
        });
    }

}