package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestsActivity extends AppCompatActivity {
    private Button phq_9;
    private Button gad_7;
    private Button score;

    private Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        phq_9=findViewById(R.id.phq9);
        gad_7=findViewById(R.id.gad7);
        score=findViewById(R.id.score);
        myDialog=new Dialog(this);
        findViewById(R.id.phq9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestsActivity.this, PhqActivity.class));
            }
        });

        findViewById(R.id.gad7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestsActivity.this, GadActivity.class));
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.pop);
                myDialog.show();
            }
        });

    }
}