package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.siddiqei.dailytaskbeta.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout classLayout,ebookLayout,noteLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classLayout=findViewById(R.id.class_layout);
        ebookLayout=findViewById(R.id.ebook_layout);
       noteLayout=findViewById(R.id.note_layout);
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
    }
}