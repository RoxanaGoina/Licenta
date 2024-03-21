package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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


//    private Button tenthQuestionNotAtAll;
//    private Button tenthQuestionSomeDays;
//    private Button tenthQuestionHalfDays;
//    private Button tenthQuestionAllTheTime;


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

//        tenthQuestionNotAtAll=findViewById(R.id.tenthQuestionNotAtAll);
//        tenthQuestionSomeDays=findViewById(R.id.tenthQuestionSomeDays);
//        tenthQuestionHalfDays=findViewById(R.id.tenthQuestionHalfDays);
//        tenthQuestionAllTheTime=findViewById(R.id.tenthQuestionAllTheTime);

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
                    firstQuestionAtAll.setSelected(true);
                   }
                    else {
                    firstQuestionSomeDays.setEnabled(true);
                    firstQuestionHalfDays.setEnabled(true);
                    firstQuestionAllTheTime.setEnabled(true);
                    firstQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isFirstQuestionSelected = false;
                    firstQuestionAtAll.setSelected(false);
                    if(firstQuestionAtAll.isSelected()==false) {
                        String message = "Butonul nu este selectat!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                }
//

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
                    firstQuestionSomeDays.setSelected(true);
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
                    firstQuestionSomeDays.setSelected(false);
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
                firstQuestionHalfDays.setSelected(true);
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
                firstQuestionHalfDays.setSelected(false);
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
                    firstQuestionAllTheTime.setSelected(true);
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
                    firstQuestionAllTheTime.setSelected(false);
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
                    secondQuestionNotAtAll.setSelected(true);
                } else {
                    secondQuestionSomeDays.setEnabled(true);
                    secondQuestionHalfDays.setEnabled(true);
                    secondQuestAllTheTime.setEnabled(true);
                    secondQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    secondQuestionNotAtAll.setSelected(false);

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
                    secondQuestionSomeDays.setSelected(true);
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
                    secondQuestionSomeDays.setSelected(false);

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
                secondQuestionHalfDays.setSelected(true);
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
                secondQuestionHalfDays.setSelected(false);

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
                    secondQuestAllTheTime.setSelected(true);
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
                    secondQuestAllTheTime.setSelected(true);

                }
            }
        });



        thirdQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    thirdQuestionSomeDays.setEnabled(false);
                    thirdQuestionHalfDays.setEnabled(false);
                    thirdQuestionAllTheTime.setEnabled(false);
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionNotAtAll.setSelected(true);
                } else {
                    thirdQuestionSomeDays.setEnabled(true);
                    thirdQuestionHalfDays.setEnabled(true);
                    thirdQuestionAllTheTime.setEnabled(true);
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionNotAtAll.setSelected(false);
                }
            }
        });


        thirdQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    thirdQuestionNotAtAll.setEnabled(false);
                    thirdQuestionHalfDays.setEnabled(false);
                    thirdQuestionAllTheTime.setEnabled(false);
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    thirdQuestionNotAtAll.setEnabled(true);
                    thirdQuestionHalfDays.setEnabled(true);
                    thirdQuestionAllTheTime.setEnabled(true);
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionSomeDays.setSelected(false);
                }

            }
        });

        thirdQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                thirdQuestionNotAtAll.setEnabled(false);
                thirdQuestionSomeDays.setEnabled(false);
                thirdQuestionAllTheTime.setEnabled(false);
                thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                thirdQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                thirdQuestionNotAtAll.setEnabled(true);
                thirdQuestionSomeDays.setEnabled(true);
                thirdQuestionAllTheTime.setEnabled(true);
                thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                thirdQuestionHalfDays.setSelected(false);
            }
            }
        });


        thirdQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    thirdQuestionNotAtAll.setEnabled(false);
                    thirdQuestionSomeDays.setEnabled(false);
                    thirdQuestionHalfDays.setEnabled(false);
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    thirdQuestionNotAtAll.setEnabled(true);
                    thirdQuestionSomeDays.setEnabled(true);
                    thirdQuestionHalfDays.setEnabled(true);
                    thirdQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionAllTheTime.setSelected(false);
                }
            }
        });





        fourthQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    fourthQuestionSomeDays.setEnabled(false);
                    fourthQuestionHalfDays.setEnabled(false);
                    fourthQuestionAllTheTime.setEnabled(false);
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionNotAtAll.setSelected(true);
                } else {
                    fourthQuestionSomeDays.setEnabled(true);
                    fourthQuestionHalfDays.setEnabled(true);
                    fourthQuestionAllTheTime.setEnabled(true);
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionNotAtAll.setSelected(false);
                }
            }
        });
        fourthQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    fourthQuestionNotAtAll.setEnabled(false);
                    fourthQuestionHalfDays.setEnabled(false);
                    fourthQuestionAllTheTime.setEnabled(false);
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    fourthQuestionNotAtAll.setEnabled(true);
                    fourthQuestionHalfDays.setEnabled(true);
                    fourthQuestionAllTheTime.setEnabled(true);
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionSomeDays.setSelected(false);
                }

            }
        });



        fourthQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                fourthQuestionNotAtAll.setEnabled(false);
                fourthQuestionSomeDays.setEnabled(false);
                fourthQuestionAllTheTime.setEnabled(false);
                fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                fourthQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                fourthQuestionNotAtAll.setEnabled(true);
                fourthQuestionSomeDays.setEnabled(true);
                fourthQuestionAllTheTime.setEnabled(true);
                fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                fourthQuestionHalfDays.setSelected(false);
            }
            }
        });

        fourthQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    fourthQuestionNotAtAll.setEnabled(false);
                    fourthQuestionSomeDays.setEnabled(false);
                    fourthQuestionHalfDays.setEnabled(false);
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    fourthQuestionNotAtAll.setEnabled(true);
                    fourthQuestionSomeDays.setEnabled(true);
                    fourthQuestionHalfDays.setEnabled(true);
                    fourthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionAllTheTime.setSelected(false);
                }
            }
        });


        fifthQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    fifthQuestionSomeDays.setEnabled(false);
                    fifthQuestionHalfDays.setEnabled(false);
                    fifthQuestionAllTheTime.setEnabled(false);
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionNotAtAll.setSelected(true);
                } else {
                    fifthQuestionSomeDays.setEnabled(true);
                    fifthQuestionHalfDays.setEnabled(true);
                    fifthQuestionAllTheTime.setEnabled(true);
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionNotAtAll.setSelected(false);
                }
            }
        });
        fifthQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    fifthQuestionNotAtAll.setEnabled(false);
                    fifthQuestionHalfDays.setEnabled(false);
                    fifthQuestionAllTheTime.setEnabled(false);
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    fifthQuestionNotAtAll.setEnabled(true);
                    fifthQuestionHalfDays.setEnabled(true);
                    fifthQuestionAllTheTime.setEnabled(true);
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionSomeDays.setSelected(false);
                }

            }
        });

        fifthQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                fifthQuestionNotAtAll.setEnabled(false);
                fifthQuestionSomeDays.setEnabled(false);
                fifthQuestionAllTheTime.setEnabled(false);
                fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                fifthQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                fifthQuestionNotAtAll.setEnabled(true);
                fifthQuestionSomeDays.setEnabled(true);
                fifthQuestionAllTheTime.setEnabled(true);
                fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                fifthQuestionHalfDays.setSelected(false);
            }
            }
        });





        fifthQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    fifthQuestionNotAtAll.setEnabled(false);
                    fifthQuestionSomeDays.setEnabled(false);
                    fifthQuestionHalfDays.setEnabled(false);
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    fifthQuestionNotAtAll.setEnabled(true);
                    fifthQuestionSomeDays.setEnabled(true);
                    fifthQuestionHalfDays.setEnabled(true);
                    fifthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionAllTheTime.setSelected(false);
                }
            }
        });

        sixthQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    sixthQuestionSomeDays.setEnabled(false);
                    sixthQuestionHalfDays.setEnabled(false);
                    sixthQuestionAllTheTime.setEnabled(false);
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionNotAtAll.setSelected(true);
                } else {
                    sixthQuestionSomeDays.setEnabled(true);
                    sixthQuestionHalfDays.setEnabled(true);
                    sixthQuestionAllTheTime.setEnabled(true);
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionNotAtAll.setSelected(false);
                }
            }
        });




        sixthQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    sixthQuestionNotAtAll.setEnabled(false);
                    sixthQuestionHalfDays.setEnabled(false);
                    sixthQuestionAllTheTime.setEnabled(false);
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    sixthQuestionNotAtAll.setEnabled(true);
                    sixthQuestionHalfDays.setEnabled(true);
                    sixthQuestionAllTheTime.setEnabled(true);
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionSomeDays.setSelected(false);
                }

            }
        });



        sixthQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                sixthQuestionNotAtAll.setEnabled(false);
                sixthQuestionSomeDays.setEnabled(false);
                sixthQuestionAllTheTime.setEnabled(false);
                sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                sixthQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                sixthQuestionNotAtAll.setEnabled(true);
                sixthQuestionSomeDays.setEnabled(true);
                sixthQuestionAllTheTime.setEnabled(true);
                sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                sixthQuestionHalfDays.setSelected(false);
            }
            }
        });


        sixthQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    sixthQuestionNotAtAll.setEnabled(false);
                    sixthQuestionSomeDays.setEnabled(false);
                    sixthQuestionHalfDays.setEnabled(false);
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    sixthQuestionNotAtAll.setEnabled(true);
                    sixthQuestionSomeDays.setEnabled(true);
                    sixthQuestionHalfDays.setEnabled(true);
                    sixthQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionAllTheTime.setSelected(false);
                }
            }
        });



        seventhQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    seventhQuestionSomeDays.setEnabled(false);
                    seventhQuestionHalfDays.setEnabled(false);
                    seventhQuestionAllTheTime.setEnabled(false);
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionNotAtAll.setSelected(true);
                } else {
                    seventhQuestionSomeDays.setEnabled(true);
                    seventhQuestionHalfDays.setEnabled(true);
                    seventhQuestionAllTheTime.setEnabled(true);
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionNotAtAll.setSelected(false);
                }
            }
        });


        seventhQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    seventhQuestionNotAtAll.setEnabled(false);
                    seventhQuestionHalfDays.setEnabled(false);
                    seventhQuestionAllTheTime.setEnabled(false);
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    seventhQuestionNotAtAll.setEnabled(true);
                    seventhQuestionHalfDays.setEnabled(true);
                    seventhQuestionAllTheTime.setEnabled(true);
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionSomeDays.setSelected(true);
                }

            }
        });



        seventhQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                seventhQuestionNotAtAll.setEnabled(false);
                seventhQuestionSomeDays.setEnabled(false);
                seventhQuestionAllTheTime.setEnabled(false);
                seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                seventhQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                seventhQuestionNotAtAll.setEnabled(true);
                seventhQuestionSomeDays.setEnabled(true);
                seventhQuestionAllTheTime.setEnabled(true);
                seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                seventhQuestionHalfDays.setSelected(false);
            }
            }
        });
        seventhQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    seventhQuestionNotAtAll.setEnabled(false);
                    seventhQuestionSomeDays.setEnabled(false);
                    seventhQuestionHalfDays.setEnabled(false);
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    seventhQuestionNotAtAll.setEnabled(true);
                    seventhQuestionSomeDays.setEnabled(true);
                    seventhQuestionHalfDays.setEnabled(true);
                    seventhQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionAllTheTime.setSelected(false);
                }
            }
        });
        eightQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    eighthQuestionSomeDays.setEnabled(false);
                    eightQuestionHalfDays.setEnabled(false);
                    eigthQuestionAllTheTime.setEnabled(false);
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    eightQuestionNotAtAll.setSelected(true);
                } else {
                    eighthQuestionSomeDays.setEnabled(true);
                    eightQuestionHalfDays.setEnabled(true);
                    eigthQuestionAllTheTime.setEnabled(true);
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    eightQuestionNotAtAll.setSelected(false);
                }
            }
        });




        eighthQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    eightQuestionNotAtAll.setEnabled(false);
                    eightQuestionHalfDays.setEnabled(false);
                    eigthQuestionAllTheTime.setEnabled(false);
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    eighthQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    eightQuestionNotAtAll.setEnabled(true);
                    eightQuestionHalfDays.setEnabled(true);
                    eigthQuestionAllTheTime.setEnabled(true);
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    eighthQuestionSomeDays.setSelected(false);
                }

            }
        });





        eightQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                eightQuestionNotAtAll.setEnabled(false);
                eighthQuestionSomeDays.setEnabled(false);
                eigthQuestionAllTheTime.setEnabled(false);
                eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                eightQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                eightQuestionNotAtAll.setEnabled(true);
                eighthQuestionSomeDays.setEnabled(true);
                eigthQuestionAllTheTime.setEnabled(true);
                eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                eightQuestionHalfDays.setSelected(false);
            }
            }
        });



        eigthQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    eightQuestionNotAtAll.setEnabled(false);
                    eighthQuestionSomeDays.setEnabled(false);
                    eightQuestionHalfDays.setEnabled(false);
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    eigthQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    eightQuestionNotAtAll.setEnabled(true);
                    eighthQuestionSomeDays.setEnabled(true);
                    eightQuestionHalfDays.setEnabled(true);
                    eightQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    eighthQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eigthQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    eightQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    eigthQuestionAllTheTime.setSelected(false);
                }
            }
        });



        ninethQuestionNotAtAll.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    ninethQuestionSomeDays.setEnabled(false);
                    ninethQuestionHalfDays.setEnabled(false);
                    ninethQuestionAllTheTime.setEnabled(false);
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    ninethQuestionNotAtAll.setSelected(true);
                } else {
                    ninethQuestionSomeDays.setEnabled(true);
                    ninethQuestionHalfDays.setEnabled(true);
                    ninethQuestionAllTheTime.setEnabled(true);
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    ninethQuestionNotAtAll.setSelected(false);
                }
            }
        });


        ninethQuestionSomeDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    ninethQuestionNotAtAll.setEnabled(false);
                    ninethQuestionHalfDays.setEnabled(false);
                    ninethQuestionAllTheTime.setEnabled(false);
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    ninethQuestionSomeDays.setSelected(true);
                } else {
                    score=score-1;
                    ninethQuestionNotAtAll.setEnabled(true);
                    ninethQuestionHalfDays.setEnabled(true);
                    ninethQuestionAllTheTime.setEnabled(true);
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    ninethQuestionSomeDays.setSelected(false);
                }

            }
        });


        ninethQuestionHalfDays.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view)
            { if (!isQuestionSelected) {
                score=score+2;
                ninethQuestionNotAtAll.setEnabled(false);
                ninethQuestionSomeDays.setEnabled(false);
                ninethQuestionAllTheTime.setEnabled(false);
                ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                isQuestionSelected = true;
                ninethQuestionHalfDays.setSelected(true);
            } else {
                score=score-2;
                ninethQuestionNotAtAll.setEnabled(true);
                ninethQuestionSomeDays.setEnabled(true);
                ninethQuestionAllTheTime.setEnabled(true);
                ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                isQuestionSelected = false;
                ninethQuestionHalfDays.setSelected(false);
            }
            }
        });

        ninethQuestionAllTheTime.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    ninethQuestionNotAtAll.setEnabled(false);
                    ninethQuestionSomeDays.setEnabled(false);
                    ninethQuestionHalfDays.setEnabled(false);
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    isQuestionSelected = true;
                    ninethQuestionAllTheTime.setSelected(true);
                } else {
                    score=score-3;
                    ninethQuestionNotAtAll.setEnabled(true);
                    ninethQuestionSomeDays.setEnabled(true);
                    ninethQuestionHalfDays.setEnabled(true);
                    ninethQuestionHalfDays.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    ninethQuestionSomeDays.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionAllTheTime.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    ninethQuestionNotAtAll.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    ninethQuestionAllTheTime.setSelected(false);
                }
            }
        });



        finalizePHQTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!firstQuestionAtAll.isSelected()  && !firstQuestionHalfDays.isSelected() && !firstQuestionSomeDays.isSelected() && !firstQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}

                else if (!secondQuestionNotAtAll.isSelected() && !secondQuestionSomeDays.isSelected() && !secondQuestionHalfDays.isSelected() && !secondQuestAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}
              else if (!thirdQuestionNotAtAll.isSelected() && !thirdQuestionSomeDays.isSelected() && !thirdQuestionHalfDays.isSelected() && !thirdQuestionAllTheTime.isSelected())
                {   String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                }
                else if (!fourthQuestionNotAtAll.isSelected() && !fourthQuestionSomeDays.isSelected() && !fourthQuestionHalfDays.isSelected() && !fourthQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                } else if (!fifthQuestionNotAtAll.isSelected() && !fifthQuestionSomeDays.isSelected() && !fifthQuestionHalfDays.isSelected() && !fifthQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}
                else if (!sixthQuestionNotAtAll.isSelected() && !sixthQuestionSomeDays.isSelected() && !sixthQuestionHalfDays.isSelected() && !sixthQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                }
                else if (!seventhQuestionNotAtAll.isSelected() && !seventhQuestionSomeDays.isSelected() && !seventhQuestionHalfDays.isSelected() && !seventhQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();

                }
                else if (!eightQuestionNotAtAll.isSelected() && !eighthQuestionSomeDays.isSelected() && !eightQuestionHalfDays.isSelected() && !eigthQuestionAllTheTime.isSelected())
                {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                } else if (!ninethQuestionNotAtAll.isSelected() && !ninethQuestionSomeDays.isSelected() && !ninethQuestionHalfDays.isSelected() && !ninethQuestionAllTheTime.isSelected()) {
                    String errorMessage = "Raspunde la toate intrebarile";
                    Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                }
            else {

                    String message ="Scorul tău este: " +score;
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(PhqActivity.this, TestsActivity.class));
                        }
                    }, 500);
               }
                }




        });

    }

}