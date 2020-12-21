package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.siddiqei.dailytaskbeta.Alarm.AlarmActivity;
import com.siddiqei.dailytaskbeta.GPS.GpsTracker;
import com.siddiqei.dailytaskbeta.R;

import java.util.Locale;

public class CourseDetailsActivity extends AppCompatActivity {
    TextView nameTV,timeTV,dayTV;
    Button direction,setalarm,delete;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        nameTV=findViewById(R.id.classname_details);
        timeTV=findViewById(R.id.time_details);
        dayTV=findViewById(R.id.days_details);
        direction=findViewById(R.id.direction);
        setalarm=findViewById(R.id.set_alarm);
        delete=findViewById(R.id.delete);
        firebaseAuth=FirebaseAuth.getInstance();
        String userid=firebaseAuth.getCurrentUser().getUid();
        String name=getIntent().getExtras().getString("NAME");
        String time=getIntent().getExtras().getString("TIME");
        String day=getIntent().getExtras().getString("DAY");
        String id=getIntent().getExtras().getString("ID");
        nameTV.setText(name);
        timeTV.setText(time);
        dayTV.setText(day);
        GpsTracker gpsTracker=new GpsTracker(getApplicationContext());
        double lat=gpsTracker.getLatitude();
        double lon=gpsTracker.getLongitude();
        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),  AlarmActivity.class);
                intent.putExtra("TIME",time);
                intent.putExtra("NAME",name);
                startActivity(intent);
            }
        });

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", lat, lon, "Student Home", 23.7549, 90.3764, "Daffodil International University Classroom");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("courselist").document(userid).collection("Course").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Course Deleted",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }
                });

            }
        });



    }
}