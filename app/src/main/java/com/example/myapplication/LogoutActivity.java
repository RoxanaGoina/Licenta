package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LogoutActivity.this, LoginActivity.class));

    }
}