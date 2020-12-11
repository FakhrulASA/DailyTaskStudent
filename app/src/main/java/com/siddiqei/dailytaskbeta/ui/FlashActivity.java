package com.siddiqei.dailytaskbeta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.siddiqei.dailytaskbeta.R;

public class FlashActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        firebaseAuth=FirebaseAuth.getInstance();



// Using handler with postDelayed called runnable run method


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser!=null)
        {
            goHome();
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),SignInActivity.class));
        }
    }

    private void goHome() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
