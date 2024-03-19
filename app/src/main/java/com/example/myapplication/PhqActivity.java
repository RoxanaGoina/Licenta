package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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


    private Button thirdQuestionNotAtAll;
    private Button thirdQuestionSomeDays;
    private Button thirdQuestionHalfDays;
    private Button thirdQuestionAllTheTime;


    private Button fourthQuestionNotAtAll;
    private Button fourthQuestionSomeDays;
    private Button fourthQuestionHalfDays;
    private Button fourthQuestionAllTheTime;


    private Button fifthQuestionNotAtAll;
    private Button fifthQuestionSomeDays;
    private Button fifthQuestionHalfDays;
    private Button fifthQuestionAllTheTime;


    private Button sixthQuestionNotAtAll;
    private Button sixthQuestionSomeDays;
    private Button sixthQuestionHalfDays;
    private Button sixthQuestionAllTheTime;



    private Button seventhQuestionNotAtAll;
    private Button seventhQuestionSomeDays;
    private Button seventhQuestionHalfDays;
    private Button seventhQuestionAllTheTime;


    private Button eightQuestionNotAtAll;
    private Button eighthQuestionSomeDays;

    private Button eightQuestionHalfDays;
    private Button eigthQuestionAllTheTime;


    private Button ninethQuestionNotAtAll;
    private Button ninethQuestionSomeDays;
    private Button ninethQuestionHalfDays;
    private Button ninethQuestionAllTheTime;


    private Button tenthQuestionNotAtAll;
    private Button tenthQuestionSomeDays;
    private Button tenthQuestionHalfDays;
    private Button tenthQuestionAllTheTime;


    private Button finalizePHQTest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phq);
        firstQuestionAtAll=findViewById(R.id.firstQuestionAtAll);
        firstQuestionSomeDays=findViewById(R.id.firstQuestionSomeDays);
        firstQuestionHalfDays=findViewById(R.id.firstQuestionHalfDays);
        firstQuestionAllTheTime=findViewById(R.id.firstQuestionAllTheTime);

        secondQuestionNotAtAll=findViewById(R.id.secondQuestionNotAtAll);
        secondQuestionSomeDays=findViewById(R.id.secondQuestionSomeDays);
        secondQuestionHalfDays=findViewById(R.id.secondQuestionHalfTime);
        secondQuestAllTheTime=findViewById(R.id.secondQuestionAllTheTime);

        thirdQuestionNotAtAll=findViewById(R.id.thirdQuestionNotAtAll);
        thirdQuestionSomeDays=findViewById(R.id.thirdQuestionSomeDays);
        thirdQuestionHalfDays=findViewById(R.id.thirdQuestionHalfDays);
        thirdQuestionAllTheTime=findViewById(R.id.thirdQuestionAllTheTime);

        fourthQuestionNotAtAll=findViewById(R.id.fourthQuestionNotAtAll);
        fourthQuestionSomeDays=findViewById(R.id.fourthQuestionSomeDays);
        fourthQuestionHalfDays=findViewById(R.id.fourthQuestionHalfDays);
        fourthQuestionAllTheTime=findViewById(R.id.fourthQuestionAllTheTime);

        fifthQuestionNotAtAll=findViewById(R.id.fifthQuestionNotAtAll);
        fifthQuestionSomeDays=findViewById(R.id.fifthQuestionSomeDays);
        fifthQuestionHalfDays=findViewById(R.id.fifthQuestionHalfDays);
        fifthQuestionAllTheTime=findViewById(R.id.fifthQuestionAllTheTime);

        sixthQuestionNotAtAll=findViewById(R.id.sixthQuestionNotAtAll);
        sixthQuestionSomeDays=findViewById(R.id.sixthQuestionSomeDays);
        sixthQuestionHalfDays=findViewById(R.id.sixthQuestionHalfDays);
        sixthQuestionAllTheTime=findViewById(R.id.sixthQuestionAllTheTime);

        seventhQuestionNotAtAll=findViewById(R.id.seventhQuestionNotAtAll);
        seventhQuestionSomeDays=findViewById(R.id.seventhQuestionSomeDays);
        seventhQuestionHalfDays=findViewById(R.id.seventhQuestionHalfDays);
        seventhQuestionAllTheTime=findViewById(R.id.seventhQuestionAllTheTime);

        eightQuestionNotAtAll=findViewById(R.id.eighthQuestionNotAtAll);
        eighthQuestionSomeDays=findViewById(R.id.eighthQuestionSomeDays);
        eightQuestionHalfDays=findViewById(R.id.eightQuestionHalfDays);
        eigthQuestionAllTheTime=findViewById(R.id.eighthQuestionAllTheTime);

        ninethQuestionNotAtAll=findViewById(R.id.ninethQuestionNotAtAll);
        ninethQuestionSomeDays=findViewById(R.id.ninethQuestionSomeDays);
        ninethQuestionHalfDays=findViewById(R.id.ninethQuestionHalfDays);
        ninethQuestionAllTheTime=findViewById(R.id.ninethQuestionAllTheTime);

        tenthQuestionNotAtAll=findViewById(R.id.tenthQuestionNotAtAll);
        tenthQuestionSomeDays=findViewById(R.id.tenthQuestionSomeDays);
        tenthQuestionHalfDays=findViewById(R.id.tenthQuestionHalfDays);
        tenthQuestionAllTheTime=findViewById(R.id.tenthQuestionAllTheTime);

        finalizePHQTest=findViewById(R.id.finalizePHQTest);





        firstQuestionAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isFirstQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isFirstQuestionSelected) {
                    firstQuestionSomeDays.setEnabled(false);
                    firstQuestionHalfDays.setEnabled(false);
                    firstQuestionAllTheTime.setEnabled(false);
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    //firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    isFirstQuestionSelected = true;
                } else {
                    firstQuestionSomeDays.setEnabled(true);
                    firstQuestionHalfDays.setEnabled(true);
                    firstQuestionAllTheTime.setEnabled(true);
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isFirstQuestionSelected = false;
                }
            }
        });

        firstQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isFirstQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isFirstQuestionSelected) {
                    score=score+1;
                    firstQuestionAtAll.setEnabled(false);
                    firstQuestionHalfDays.setEnabled(false);
                    firstQuestionAllTheTime.setEnabled(false);
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isFirstQuestionSelected = true;
                } else {
                    score=score-1;
                    firstQuestionAtAll.setEnabled(true);
                    firstQuestionHalfDays.setEnabled(true);
                    firstQuestionAllTheTime.setEnabled(true);
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isFirstQuestionSelected = false;
                }

            }
        });

        firstQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                firstQuestionAtAll.setEnabled(false);
                firstQuestionSomeDays.setEnabled(false);
                firstQuestionAllTheTime.setEnabled(false);
                firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
            } else {
                score=score-2;
                firstQuestionAtAll.setEnabled(true);
                firstQuestionSomeDays.setEnabled(true);
                firstQuestionAllTheTime.setEnabled(true);
                firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
            }
            }
        });

        firstQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    firstQuestionAtAll.setEnabled(false);
                    firstQuestionSomeDays.setEnabled(false);
                    firstQuestionHalfDays.setEnabled(false);
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                } else {
                    score=score-3;
                    firstQuestionAtAll.setEnabled(true);
                    firstQuestionSomeDays.setEnabled(true);
                    firstQuestionHalfDays.setEnabled(true);
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                }
            }
        });

        secondQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    secondQuestionSomeDays.setEnabled(false);
                    secondQuestionHalfDays.setEnabled(false);
                    secondQuestAllTheTime.setEnabled(false);
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    //firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    isQuestionSelected = true;
                } else {
                    secondQuestionSomeDays.setEnabled(true);
                    secondQuestionHalfDays.setEnabled(true);
                    secondQuestAllTheTime.setEnabled(true);
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                }
            }
        });



        secondQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    secondQuestionNotAtAll.setEnabled(false);
                    secondQuestionHalfDays.setEnabled(false);
                    secondQuestAllTheTime.setEnabled(false);
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                } else {
                    score=score-1;
                    secondQuestionNotAtAll.setEnabled(true);
                    secondQuestionHalfDays.setEnabled(true);
                    secondQuestAllTheTime.setEnabled(true);
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                }

            }
        });
        secondQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                secondQuestionNotAtAll.setEnabled(false);
                secondQuestionSomeDays.setEnabled(false);
                secondQuestAllTheTime.setEnabled(false);
                secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
            } else {
                score=score-2;
                secondQuestionNotAtAll.setEnabled(true);
                secondQuestionSomeDays.setEnabled(true);
                secondQuestAllTheTime.setEnabled(true);
                secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
            }
            }
        });




        secondQuestAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    secondQuestionNotAtAll.setEnabled(false);
                    secondQuestionSomeDays.setEnabled(false);
                    secondQuestionHalfDays.setEnabled(false);
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                } else {
                    score=score-3;
                    secondQuestionNotAtAll.setEnabled(true);
                    secondQuestionSomeDays.setEnabled(true);
                    secondQuestionHalfDays.setEnabled(true);
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                }
            }
        });

        finalizePHQTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message ="Scorul tău este: " + score;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            }
        });
    }

}