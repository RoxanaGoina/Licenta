package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PhqActivity extends AppCompatActivity {
    private int score=0;
    private Button firstQuestionAtAll;
    private Button firstQuestionSomeDays;
    private Button firstQuestionHalfDays;
    private Button firstQuestionAllTheTime;

    private  Button secondQuestionNotAtAll;
    private  Button secondQuestionSomeDays;
    private  Button secondQuestionHalfDays;
    private Button secondQuestAllTheTime;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phq);
        firstQuestionAtAll=findViewById(R.id.firstQuestionAtAll);
    }
}