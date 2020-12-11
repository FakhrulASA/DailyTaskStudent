package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.siddiqei.dailytaskbeta.R;

public class EbookActivity extends AppCompatActivity {
    LinearLayout book1,book2,book3,book4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        book1=findViewById(R.id.book1);
        book2=findViewById(R.id.book2);
        book3=findViewById(R.id.book3);
        book4=findViewById(R.id.book4);
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ShowEbook.class);
                intent.putExtra("BOOK","https://drive.google.com/file/d/1m_AJDpGUCYZJ-JuJPu1VSO7HsOwQ0ly9/view?usp=sharing");
                startActivity(intent);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ShowEbook.class);
                intent.putExtra("BOOK","https://drive.google.com/file/d/1U1JB6s14N3vjq79bAR7wUKGuUdKSLUNv/view?usp=sharing");
                startActivity(intent);
            }
        });
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ShowEbook.class);
                intent.putExtra("BOOK","https://drive.google.com/file/d/1XQaizRPGpKBMnognHvSBJDfKWENqpv-J/view?usp=sharing");
                startActivity(intent);
            }
        });
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ShowEbook.class);
                intent.putExtra("BOOK","https://drive.google.com/file/d/1WPv-u1h36_ROaoHCOAizM8V_gha4nPOp/view?usp=sharing");
                startActivity(intent);
            }
        });
    }
}