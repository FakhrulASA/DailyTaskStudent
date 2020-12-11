package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siddiqei.dailytaskbeta.GPS.GpsTracker;
import com.siddiqei.dailytaskbeta.R;

import java.util.Locale;

public class CourseDetailsActivity extends AppCompatActivity {
    TextView nameTV,timeTV,dayTV;
    Button direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        nameTV=findViewById(R.id.classname_details);
        timeTV=findViewById(R.id.time_details);
        dayTV=findViewById(R.id.days_details);
        direction=findViewById(R.id.direction);
        String name=getIntent().getExtras().getString("NAME");
        String time=getIntent().getExtras().getString("TIME");
        String day=getIntent().getExtras().getString("DAY");
        nameTV.setText(name);
        timeTV.setText(time);
        dayTV.setText(day);
        GpsTracker gpsTracker=new GpsTracker(getApplicationContext());
        double lat=gpsTracker.getLatitude();
        double lon=gpsTracker.getLongitude();


        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", lat, lon, "Student Home", 23.7549, 90.3764, "Daffodil International University Classroom");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });



    }
}