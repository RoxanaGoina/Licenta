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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GadActivity extends AppCompatActivity {

    private int score=0;

    private Button firstQuestionFirstAnswer;
    private Button firstQuestionSecondAnswer;
    private Button firstQuestionThirdAnswer;
    private Button firstQuestionFourthAnswer;


    private Button secondQuestionFirstAnswer;
    private Button secondQuestionSecondAnswer;
    private Button secondQuestionThirdAnswer;
    private Button secondQuestionFourthAnswer;


    private Button thirdQuestionFirstAnswer;
    private Button thirdQuestionSecondAnswer;
    private Button thirdQuestionThirdAnswer;
    private Button thirdQuestionFourthAnswer;


    private Button fourthQuestionFirstAnswer;
    private Button fourthQuestionSecondAnswer;
    private Button fourthQuestionThirdAnswer;
    private Button fourthQuestionFourthAnswer;



    private Button fifthQuestionFirstAnswer;
    private Button fifthQuestionSecondAnswer;
    private Button fifthQuestionThirdAnswer;
    private Button fifthQuestionFourthAnswer;



    private Button sixthQuestionFirstAnswer;

    private Button sixthQuestionSecondAnswer;
    private Button sixthQuestionThirdAnswer;
    private Button sixthQuestionFourthAnswer;



    private Button seventhQuestionFirstAnswer;
    private Button seventhQuestionSecondAnswer;
    private Button seventhQuestionThirdAnswer;

    private Button seventhQuestionFourthAnswer;

    private Button finalizeGADTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gad);

        firstQuestionFirstAnswer=findViewById(R.id.firstQuestionFirstAnswer);
        firstQuestionSecondAnswer=findViewById(R.id.firstQuestionSecondAnswer);
        firstQuestionThirdAnswer=findViewById(R.id.firstQuestionThirdAnswer);
        firstQuestionFourthAnswer=findViewById(R.id.firstQuestionFourthAnswer);


        secondQuestionFirstAnswer=findViewById(R.id.secondQuestionFirstAnswer);
        secondQuestionSecondAnswer=findViewById(R.id.secondQuestionSecondAnswer);
        secondQuestionThirdAnswer=findViewById(R.id.secondQuestionThirdAnswer);
        secondQuestionFourthAnswer=findViewById(R.id.secondQuestionFourthAnswer);


        thirdQuestionFirstAnswer=findViewById(R.id.thirdQuestionFirstAnswer);
        thirdQuestionSecondAnswer=findViewById(R.id.thirdQuestionSecondAnswer);
        thirdQuestionThirdAnswer=findViewById(R.id.thirdQuestionThirdAnswer);
        thirdQuestionFourthAnswer=findViewById(R.id.thirdQuestionFourthAnswer);

        fourthQuestionFirstAnswer=findViewById(R.id.fourthQuestionFirstAnswer);
        fourthQuestionSecondAnswer=findViewById(R.id.fourthQuestionSecondAnswer);
        fourthQuestionThirdAnswer=findViewById(R.id.fourthQuestionThirdAnswer);
        fourthQuestionFourthAnswer=findViewById(R.id.fourthQuestionFourthAnswer);

        fifthQuestionFirstAnswer=findViewById(R.id.fifthQuestionFirstAnswer);
        fifthQuestionSecondAnswer=findViewById(R.id.fifthQuestionSecondAnswer);
        fifthQuestionThirdAnswer=findViewById(R.id.fifthQuestionThirdAnswer);
        fifthQuestionFourthAnswer=findViewById(R.id.fifthQuestionFourthAnswer);


        sixthQuestionFirstAnswer=findViewById(R.id.sixthQuestionFirstAnswer);
        sixthQuestionSecondAnswer=findViewById(R.id.sixthQuestionSecondAnswer);
        sixthQuestionThirdAnswer=findViewById(R.id.sixthQuestionThirdAnswer);
        sixthQuestionFourthAnswer=findViewById(R.id.sixthQuestionFourthAnswer);


        seventhQuestionFirstAnswer=findViewById(R.id.seventhQuestionFirstAnswer);
        seventhQuestionSecondAnswer=findViewById(R.id.seventhQuestionSecondAnswer);
        seventhQuestionThirdAnswer=findViewById(R.id.seventhQuestionThirdAnswer);
        seventhQuestionFourthAnswer=findViewById(R.id.seventhQuestionFourthAnswer);

        finalizeGADTest=findViewById(R.id.finalizeGADTest);


        firstQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    firstQuestionSecondAnswer.setEnabled(false);
                    firstQuestionThirdAnswer.setEnabled(false);
                    firstQuestionFourthAnswer.setEnabled(false);
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    Context context = view.getContext();
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
                    isQuestionSelected = true;
                    firstQuestionFirstAnswer.setSelected(true);
                } else {
                    firstQuestionSecondAnswer.setEnabled(true);
                    firstQuestionThirdAnswer.setEnabled(true);
                    firstQuestionFourthAnswer.setEnabled(true);
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    firstQuestionFirstAnswer.setSelected(false);
                }

            }
        });


        firstQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    firstQuestionFirstAnswer.setEnabled(false);
                    firstQuestionThirdAnswer.setEnabled(false);
                    firstQuestionFourthAnswer.setEnabled(false);
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    firstQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    firstQuestionFirstAnswer.setEnabled(true);
                    firstQuestionThirdAnswer.setEnabled(true);
                    firstQuestionFourthAnswer.setEnabled(true);
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    firstQuestionSecondAnswer.setSelected(false);
                }

            }
        });




        firstQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    firstQuestionFirstAnswer.setEnabled(false);
                    firstQuestionSecondAnswer.setEnabled(false);
                    firstQuestionFourthAnswer.setEnabled(false);
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    firstQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    firstQuestionFirstAnswer.setEnabled(true);
                    firstQuestionSecondAnswer.setEnabled(true);
                    firstQuestionFourthAnswer.setEnabled(true);
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    firstQuestionThirdAnswer.setSelected(false);
                }

            }
        });

        firstQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    firstQuestionFirstAnswer.setEnabled(false);
                    firstQuestionSecondAnswer.setEnabled(false);
                    firstQuestionThirdAnswer.setEnabled(false);
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    firstQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    firstQuestionFirstAnswer.setEnabled(true);
                    firstQuestionSecondAnswer.setEnabled(true);
                    firstQuestionThirdAnswer.setEnabled(true);
                    firstQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    firstQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    firstQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    firstQuestionFourthAnswer.setSelected(false);
                }


            }
        });



        secondQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    secondQuestionSecondAnswer.setEnabled(false);
                    secondQuestionThirdAnswer.setEnabled(false);
                    secondQuestionFourthAnswer.setEnabled(false);
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    secondQuestionFirstAnswer.setSelected(true);
                } else {
                    secondQuestionSecondAnswer.setEnabled(true);
                    secondQuestionThirdAnswer.setEnabled(true);
                    secondQuestionFourthAnswer.setEnabled(true);
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    secondQuestionFirstAnswer.setSelected(false);
                }

            }
        });



        secondQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    secondQuestionFirstAnswer.setEnabled(false);
                    secondQuestionThirdAnswer.setEnabled(false);
                    secondQuestionFourthAnswer.setEnabled(false);
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    secondQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    secondQuestionFirstAnswer.setEnabled(true);
                    secondQuestionThirdAnswer.setEnabled(true);
                    secondQuestionFourthAnswer.setEnabled(true);
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    secondQuestionSecondAnswer.setSelected(false);
                }

            }
        });


        secondQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    secondQuestionFirstAnswer.setEnabled(false);
                    secondQuestionSecondAnswer.setEnabled(false);
                    secondQuestionFourthAnswer.setEnabled(false);
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    secondQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    secondQuestionFirstAnswer.setEnabled(true);
                    secondQuestionSecondAnswer.setEnabled(true);
                    secondQuestionFourthAnswer.setEnabled(true);
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    secondQuestionThirdAnswer.setSelected(false);
                }

            }
        });

        secondQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    secondQuestionFirstAnswer.setEnabled(false);
                    secondQuestionSecondAnswer.setEnabled(false);
                    secondQuestionThirdAnswer.setEnabled(false);
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    secondQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    secondQuestionFirstAnswer.setEnabled(true);
                    secondQuestionSecondAnswer.setEnabled(true);
                    secondQuestionThirdAnswer.setEnabled(true);
                    secondQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    secondQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    secondQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    secondQuestionFourthAnswer.setSelected(false);
                }


            }
        });

        thirdQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    thirdQuestionSecondAnswer.setEnabled(false);
                    thirdQuestionThirdAnswer.setEnabled(false);
                    thirdQuestionFourthAnswer.setEnabled(false);
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionFirstAnswer.setSelected(true);
                } else {
                    thirdQuestionSecondAnswer.setEnabled(true);
                    thirdQuestionThirdAnswer.setEnabled(true);
                    thirdQuestionFourthAnswer.setEnabled(true);
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionFirstAnswer.setSelected(false);
                }

            }
        });


        thirdQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    thirdQuestionFirstAnswer.setEnabled(false);
                    thirdQuestionThirdAnswer.setEnabled(false);
                    thirdQuestionFourthAnswer.setEnabled(false);
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    thirdQuestionFirstAnswer.setEnabled(true);
                    thirdQuestionThirdAnswer.setEnabled(true);
                    thirdQuestionFourthAnswer.setEnabled(true);
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionSecondAnswer.setSelected(false);
                }

            }
        });

        thirdQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    thirdQuestionFirstAnswer.setEnabled(false);
                    thirdQuestionSecondAnswer.setEnabled(false);
                    thirdQuestionFourthAnswer.setEnabled(false);
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    thirdQuestionFirstAnswer.setEnabled(true);
                    thirdQuestionSecondAnswer.setEnabled(true);
                    thirdQuestionFourthAnswer.setEnabled(true);
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionThirdAnswer.setSelected(false);
                }

            }
        });


        thirdQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    thirdQuestionFirstAnswer.setEnabled(false);
                    thirdQuestionSecondAnswer.setEnabled(false);
                    thirdQuestionThirdAnswer.setEnabled(false);
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    thirdQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    thirdQuestionFirstAnswer.setEnabled(true);
                    thirdQuestionSecondAnswer.setEnabled(true);
                    thirdQuestionThirdAnswer.setEnabled(true);
                    thirdQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    thirdQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    thirdQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    thirdQuestionFourthAnswer.setSelected(false);
                }


            }
        });


        fourthQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    fourthQuestionSecondAnswer.setEnabled(false);
                    fourthQuestionThirdAnswer.setEnabled(false);
                    fourthQuestionFourthAnswer.setEnabled(false);
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionFirstAnswer.setSelected(true);
                } else {
                    fourthQuestionSecondAnswer.setEnabled(true);
                    fourthQuestionThirdAnswer.setEnabled(true);
                    fourthQuestionFourthAnswer.setEnabled(true);
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionFirstAnswer.setSelected(false);
                }

            }
        });


        fourthQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    fourthQuestionFirstAnswer.setEnabled(false);
                    fourthQuestionThirdAnswer.setEnabled(false);
                    fourthQuestionFourthAnswer.setEnabled(false);
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    fourthQuestionFirstAnswer.setEnabled(true);
                    fourthQuestionThirdAnswer.setEnabled(true);
                    fourthQuestionFourthAnswer.setEnabled(true);
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionSecondAnswer.setSelected(false);
                }

            }
        });


        fourthQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    fourthQuestionFirstAnswer.setEnabled(false);
                    fourthQuestionSecondAnswer.setEnabled(false);
                    fourthQuestionFourthAnswer.setEnabled(false);
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    fourthQuestionFirstAnswer.setEnabled(true);
                    fourthQuestionSecondAnswer.setEnabled(true);
                    fourthQuestionFourthAnswer.setEnabled(true);
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionThirdAnswer.setSelected(false);
                }

            }
        });

        fourthQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    fourthQuestionFirstAnswer.setEnabled(false);
                    fourthQuestionSecondAnswer.setEnabled(false);
                    fourthQuestionThirdAnswer.setEnabled(false);
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fourthQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    fourthQuestionFirstAnswer.setEnabled(true);
                    fourthQuestionSecondAnswer.setEnabled(true);
                    fourthQuestionThirdAnswer.setEnabled(true);
                    fourthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fourthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fourthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fourthQuestionFourthAnswer.setSelected(false);
                }


            }
        });


        fifthQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    fifthQuestionSecondAnswer.setEnabled(false);
                    fifthQuestionThirdAnswer.setEnabled(false);
                    fifthQuestionFourthAnswer.setEnabled(false);
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionFirstAnswer.setSelected(true);
                } else {
                    fifthQuestionSecondAnswer.setEnabled(true);
                    fifthQuestionThirdAnswer.setEnabled(true);
                    fifthQuestionFourthAnswer.setEnabled(true);
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionFirstAnswer.setSelected(false);
                }

            }
        });


        fifthQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    fifthQuestionFirstAnswer.setEnabled(false);
                    fifthQuestionThirdAnswer.setEnabled(false);
                    fifthQuestionFourthAnswer.setEnabled(false);
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    fifthQuestionFirstAnswer.setEnabled(true);
                    fifthQuestionThirdAnswer.setEnabled(true);
                    fifthQuestionFourthAnswer.setEnabled(true);
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionSecondAnswer.setSelected(false);
                }

            }
        });


        fifthQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    fifthQuestionFirstAnswer.setEnabled(false);
                    fifthQuestionSecondAnswer.setEnabled(false);
                    fifthQuestionFourthAnswer.setEnabled(false);
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    fifthQuestionFirstAnswer.setEnabled(true);
                    fifthQuestionSecondAnswer.setEnabled(true);
                    fifthQuestionFourthAnswer.setEnabled(true);
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionThirdAnswer.setSelected(false);
                }

            }
        });


        fifthQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    fifthQuestionFirstAnswer.setEnabled(false);
                    fifthQuestionSecondAnswer.setEnabled(false);
                    fifthQuestionThirdAnswer.setEnabled(false);
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    fifthQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    fifthQuestionFirstAnswer.setEnabled(true);
                    fifthQuestionSecondAnswer.setEnabled(true);
                    fifthQuestionThirdAnswer.setEnabled(true);
                    fifthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    fifthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    fifthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    fifthQuestionFourthAnswer.setSelected(false);
                }


            }
        });


        sixthQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    sixthQuestionSecondAnswer.setEnabled(false);
                    sixthQuestionThirdAnswer.setEnabled(false);
                    sixthQuestionFourthAnswer.setEnabled(false);
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionFirstAnswer.setSelected(true);
                } else {
                    sixthQuestionSecondAnswer.setEnabled(true);
                    sixthQuestionThirdAnswer.setEnabled(true);
                    sixthQuestionFourthAnswer.setEnabled(true);
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionFirstAnswer.setSelected(false);
                }

            }
        });



        sixthQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    sixthQuestionFirstAnswer.setEnabled(false);
                    sixthQuestionThirdAnswer.setEnabled(false);
                    sixthQuestionFourthAnswer.setEnabled(false);
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    sixthQuestionFirstAnswer.setEnabled(true);
                    sixthQuestionThirdAnswer.setEnabled(true);
                    sixthQuestionFourthAnswer.setEnabled(true);
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionSecondAnswer.setSelected(false);
                }

            }
        });


        sixthQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    sixthQuestionFirstAnswer.setEnabled(false);
                    sixthQuestionSecondAnswer.setEnabled(false);
                    sixthQuestionFourthAnswer.setEnabled(false);
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    sixthQuestionFirstAnswer.setEnabled(true);
                    sixthQuestionSecondAnswer.setEnabled(true);
                    sixthQuestionFourthAnswer.setEnabled(true);
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionThirdAnswer.setSelected(false);
                }

            }
        });


        sixthQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    sixthQuestionFirstAnswer.setEnabled(false);
                    sixthQuestionSecondAnswer.setEnabled(false);
                    sixthQuestionThirdAnswer.setEnabled(false);
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    sixthQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    sixthQuestionFirstAnswer.setEnabled(true);
                    sixthQuestionSecondAnswer.setEnabled(true);
                    sixthQuestionThirdAnswer.setEnabled(true);
                    sixthQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    sixthQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    sixthQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    sixthQuestionFourthAnswer.setSelected(false);
                }


            }
        });

        seventhQuestionFirstAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    seventhQuestionSecondAnswer.setEnabled(false);
                    seventhQuestionThirdAnswer.setEnabled(false);
                    seventhQuestionFourthAnswer.setEnabled(false);
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionFirstAnswer.setSelected(true);
                } else {
                    seventhQuestionSecondAnswer.setEnabled(true);
                    seventhQuestionThirdAnswer.setEnabled(true);
                    seventhQuestionFourthAnswer.setEnabled(true);
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionFirstAnswer.setSelected(false);
                }

            }
        });

        seventhQuestionSecondAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+1;
                    seventhQuestionFirstAnswer.setEnabled(false);
                    seventhQuestionThirdAnswer.setEnabled(false);
                    seventhQuestionFourthAnswer.setEnabled(false);
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionSecondAnswer.setSelected(true);
                } else {
                    score=score-1;
                    seventhQuestionFirstAnswer.setEnabled(true);
                    seventhQuestionThirdAnswer.setEnabled(true);
                    seventhQuestionFourthAnswer.setEnabled(true);
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionSecondAnswer.setSelected(false);
                }

            }
        });



        seventhQuestionThirdAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;
            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+2;
                    seventhQuestionFirstAnswer.setEnabled(false);
                    seventhQuestionSecondAnswer.setEnabled(false);
                    seventhQuestionFourthAnswer.setEnabled(false);
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionThirdAnswer.setSelected(true);
                } else {
                    score=score-2;
                    seventhQuestionFirstAnswer.setEnabled(true);
                    seventhQuestionSecondAnswer.setEnabled(true);
                    seventhQuestionFourthAnswer.setEnabled(true);
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionThirdAnswer.setSelected(false);
                }

            }
        });


        seventhQuestionFourthAnswer.setOnClickListener(new View.OnClickListener() {
            boolean isQuestionSelected = false;


            @Override
            public void onClick(View view) {
                if (!isQuestionSelected) {
                    score=score+3;
                    seventhQuestionFirstAnswer.setEnabled(false);
                    seventhQuestionSecondAnswer.setEnabled(false);
                    seventhQuestionThirdAnswer.setEnabled(false);
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.lavender));
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.black));
                    isQuestionSelected = true;
                    seventhQuestionFourthAnswer.setSelected(true);
                } else {
                    score=score-3;
                    seventhQuestionFirstAnswer.setEnabled(true);
                    seventhQuestionSecondAnswer.setEnabled(true);
                    seventhQuestionThirdAnswer.setEnabled(true);
                    seventhQuestionFirstAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    seventhQuestionSecondAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionThirdAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.floral));
                    seventhQuestionFourthAnswer.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.floral));
                    isQuestionSelected = false;
                    seventhQuestionFourthAnswer.setSelected(false);
                }


            }
        });
            finalizeGADTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if(!firstQuestionFirstAnswer.isSelected()  && !firstQuestionSecondAnswer.isSelected() && !firstQuestionThirdAnswer.isSelected() && !firstQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}

                    else if (!secondQuestionFirstAnswer.isSelected() && !secondQuestionSecondAnswer.isSelected() && !secondQuestionThirdAnswer.isSelected() && !secondQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}
                    else if (!thirdQuestionFirstAnswer.isSelected() && !thirdQuestionSecondAnswer.isSelected() && !thirdQuestionThirdAnswer.isSelected() && !thirdQuestionFourthAnswer.isSelected())
                    {   String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                    }
                    else if (!fourthQuestionFirstAnswer.isSelected() && !fourthQuestionSecondAnswer.isSelected() && !fourthQuestionThirdAnswer.isSelected() && !fourthQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                    } else if (!fifthQuestionFirstAnswer.isSelected() && !fifthQuestionSecondAnswer.isSelected() && !fifthQuestionThirdAnswer.isSelected() && !fifthQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();}
                    else if (!sixthQuestionFirstAnswer.isSelected() && !sixthQuestionSecondAnswer.isSelected() && !sixthQuestionThirdAnswer.isSelected() && !sixthQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                    }
                    else if (!seventhQuestionFirstAnswer.isSelected() && !seventhQuestionSecondAnswer.isSelected() && !seventhQuestionThirdAnswer.isSelected() && !seventhQuestionFourthAnswer.isSelected()) {
                        String errorMessage = "Raspunde la toate intrebarile";
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();

                    }

                    else {

                        String message ="Scorul tău este: " +score;
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if (user != null) {
                            String userId = user.getUid();
                            DatabaseReference database = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference();
                            database.child("username").child(userId).child("gadscore").setValue(score);
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(GadActivity.this, TestsActivity.class));
                            }
                        }, 500);
                    }
                }


            });

    }
    public void onBackPressed() {
        Intent intent = new Intent(this, TestsActivity.class);
        startActivity(intent);
    }
}