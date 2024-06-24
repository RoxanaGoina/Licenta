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
    private Button finalizePHQTest;

    Button[][] questionButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phq);
        initializeButtons();
        setupQuestionButtons(firstQuestionAtAll, firstQuestionSomeDays, firstQuestionHalfDays,firstQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(secondQuestionNotAtAll, secondQuestionSomeDays, secondQuestionHalfDays,secondQuestAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(thirdQuestionNotAtAll, thirdQuestionSomeDays, thirdQuestionHalfDays,thirdQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(fourthQuestionNotAtAll, fourthQuestionSomeDays, fourthQuestionHalfDays,fourthQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(fifthQuestionNotAtAll, fifthQuestionSomeDays, fifthQuestionHalfDays,fifthQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(sixthQuestionNotAtAll, sixthQuestionSomeDays, sixthQuestionHalfDays,sixthQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(seventhQuestionNotAtAll, seventhQuestionSomeDays, seventhQuestionHalfDays,seventhQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(eightQuestionNotAtAll, eighthQuestionSomeDays, eightQuestionHalfDays,eigthQuestionAllTheTime, 0, 1, 2, 3);
        setupQuestionButtons(ninethQuestionNotAtAll, ninethQuestionSomeDays, ninethQuestionHalfDays, ninethQuestionAllTheTime, 0, 1, 2, 3);

        finalizePHQTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizePHQTest();
            }
        });
    }

    /**
     * metoda creeaza legatura dintre elemente din fisiere XML si obiectele din codul sursa
     */
    private void initializeButtons() {
        firstQuestionAtAll = findViewById(R.id.firstQuestionAtAll);
        firstQuestionSomeDays = findViewById(R.id.firstQuestionSomeDays);
        firstQuestionHalfDays = findViewById(R.id.firstQuestionHalfDays);
        firstQuestionAllTheTime = findViewById(R.id.firstQuestionAllTheTime);

        secondQuestionNotAtAll = findViewById(R.id.secondQuestionNotAtAll);
        secondQuestionSomeDays = findViewById(R.id.secondQuestionSomeDays);
        secondQuestionHalfDays = findViewById(R.id.secondQuestionHalfTime);
        secondQuestAllTheTime = findViewById(R.id.secondQuestionAllTheTime);

        thirdQuestionNotAtAll = findViewById(R.id.thirdQuestionNotAtAll);
        thirdQuestionSomeDays = findViewById(R.id.thirdQuestionSomeDays);
        thirdQuestionHalfDays = findViewById(R.id.thirdQuestionHalfDays);
        thirdQuestionAllTheTime = findViewById(R.id.thirdQuestionAllTheTime);

        fourthQuestionNotAtAll = findViewById(R.id.fourthQuestionNotAtAll);
        fourthQuestionSomeDays = findViewById(R.id.fourthQuestionSomeDays);
        fourthQuestionHalfDays = findViewById(R.id.fourthQuestionHalfDays);
        fourthQuestionAllTheTime = findViewById(R.id.fourthQuestionAllTheTime);

        fifthQuestionNotAtAll = findViewById(R.id.fifthQuestionNotAtAll);
        fifthQuestionSomeDays = findViewById(R.id.fifthQuestionSomeDays);
        fifthQuestionHalfDays = findViewById(R.id.fifthQuestionHalfDays);
        fifthQuestionAllTheTime = findViewById(R.id.fifthQuestionAllTheTime);

        sixthQuestionNotAtAll = findViewById(R.id.sixthQuestionNotAtAll);
        sixthQuestionSomeDays = findViewById(R.id.sixthQuestionSomeDays);
        sixthQuestionHalfDays = findViewById(R.id.sixthQuestionHalfDays);
        sixthQuestionAllTheTime = findViewById(R.id.sixthQuestionAllTheTime);

        seventhQuestionNotAtAll = findViewById(R.id.seventhQuestionNotAtAll);
        seventhQuestionSomeDays = findViewById(R.id.seventhQuestionSomeDays);
        seventhQuestionHalfDays = findViewById(R.id.seventhQuestionHalfDays);
        seventhQuestionAllTheTime = findViewById(R.id.seventhQuestionAllTheTime);

        eightQuestionNotAtAll = findViewById(R.id.eighthQuestionNotAtAll);
        eighthQuestionSomeDays = findViewById(R.id.eighthQuestionSomeDays);
        eightQuestionHalfDays = findViewById(R.id.eightQuestionHalfDays);
        eigthQuestionAllTheTime = findViewById(R.id.eighthQuestionAllTheTime);

        ninethQuestionNotAtAll = findViewById(R.id.ninethQuestionNotAtAll);
        ninethQuestionSomeDays = findViewById(R.id.ninethQuestionSomeDays);
        ninethQuestionHalfDays = findViewById(R.id.ninethQuestionHalfDays);
        ninethQuestionAllTheTime = findViewById(R.id.ninethQuestionAllTheTime);

        finalizePHQTest = findViewById(R.id.finalizePHQTest);
         questionButtons =  new Button[][] {
                {firstQuestionAtAll, firstQuestionSomeDays, firstQuestionHalfDays, firstQuestionAllTheTime},
                {secondQuestionNotAtAll, secondQuestionSomeDays, secondQuestionHalfDays, secondQuestAllTheTime},
                {thirdQuestionNotAtAll, thirdQuestionSomeDays, thirdQuestionHalfDays, thirdQuestionAllTheTime},
                {fourthQuestionNotAtAll, fourthQuestionSomeDays, fourthQuestionHalfDays, fourthQuestionAllTheTime},
                {fifthQuestionNotAtAll, fifthQuestionSomeDays, fifthQuestionHalfDays, fifthQuestionAllTheTime},
                {sixthQuestionNotAtAll, sixthQuestionSomeDays, sixthQuestionHalfDays, sixthQuestionAllTheTime},
                {seventhQuestionNotAtAll, seventhQuestionSomeDays, seventhQuestionHalfDays, seventhQuestionAllTheTime},
                {eightQuestionNotAtAll, eighthQuestionSomeDays, eightQuestionHalfDays, eigthQuestionAllTheTime},
                {ninethQuestionNotAtAll, ninethQuestionSomeDays, ninethQuestionHalfDays, ninethQuestionAllTheTime}
        };

    }

    /**
     *
     * @param questionButtons - un array de array de butoane -  cu alte cuvinte, pentru fiecare intrebare butoanele sunt grupate, sub forma unei linii din matrice
     * functia verifica daca cel putin un obiect din element din fiecare grup de butoane este selectat.
     */
    private void checkAllQuestionsAnswered(Button[][] questionButtons) {
        for (Button[] buttons : questionButtons) {
            boolean questionAnswered = false;
            for (Button button : buttons) {
                if (button.isSelected()) {
                    questionAnswered = true;
                    break;
                }
            }
            if (!questionAnswered) {
                String errorMessage = "Raspunde la toate intrebarile";
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                return;
            }
        }

        String severity = scoreRange(score);
        String message = "Scorul tău este: " + score + "\n " + severity;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            DatabaseReference database = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference();
            database.child("username").child(userId).child("phqscore").setValue(score);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(PhqActivity.this, TestsActivity.class));
            }
        }, 500);
    }

    /**
     * Functia apeleaza o functie pentru a verifica daca cel putin un buton de la fiecare intrebare este selectat
     */
    private void finalizePHQTest() {
        checkAllQuestionsAnswered(questionButtons);
    }

    /**
     *
     * @param score - scorul obtinut la finalizarea testului
     * @return  functia returneaza un String in functie de valoarea scorului primita ca parametru
     */

    private String scoreRange(int score){
        if(score >=0 && score <=4)
            return "Nivel depresie : None - minimal";
        else if (score >= 5 && score <= 9)
            return "Nivel depresie : Usoara";
        else if(score >=10 && score <=14)
            return "Nivel depresie : Moderata";
        else if (score >=15 && score <=19)
            return "Nivel depresie : Moderat - Severa ";
        else
             return "Nivel depresie : Severa";
    }

    /**
     * Sets up the click listeners for a set of question buttons and manages their state based on selection.
     *
     * @param firstOption prima varianta de raspuns
     * @param secondOption a doua varianta de raspuns.
     * @param thirdOption a treia varianta de raspuns.
     * @param fourthOption a patra varianta de raspuns
     * @param firstOptionScore scorul obtinut asociat prin selectarea primei variante de raspuns
     * @param secondOptionScore scorul obtinut asociat prin selectarea celei de-a doua variante de raspuns
     * @param thirdOptionScore scorul obtinut asociat prin selectarea celei de-a treia variante de raspuns
     * @param fourthOptionScore scorul obtinut asociat prin selectarea celei de-a patra variante de raspuns.
     *
     */
    private void setupQuestionButtons(final Button firstOption, final Button secondOption, final Button thirdOption, final Button fourthOption, final int firstOptionScore, final int secondOptionScore, final int thirdOptionScore, final int fourthOptionScore) {
        View.OnClickListener listener = new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                Button selectedButton = (Button) view;
                Button[] otherButtons;

                if (selectedButton == firstOption) {
                    otherButtons = new Button[]{secondOption, thirdOption, fourthOption};
                    updateButtonsState(firstOption, otherButtons, isQuestionSelected, firstOptionScore);
                } else if (selectedButton == secondOption) {
                    otherButtons = new Button[]{firstOption, thirdOption, fourthOption};
                    updateButtonsState(secondOption, otherButtons, isQuestionSelected, secondOptionScore);
                } else if (selectedButton == thirdOption) {
                    otherButtons = new Button[]{firstOption, secondOption, fourthOption};
                    updateButtonsState(thirdOption, otherButtons, isQuestionSelected, thirdOptionScore);
                } else if (selectedButton == fourthOption) {
                    otherButtons = new Button[]{firstOption, secondOption, thirdOption};
                    updateButtonsState(fourthOption, otherButtons, isQuestionSelected, fourthOptionScore);
                }
                isQuestionSelected = !isQuestionSelected;
            }
        };

        firstOption.setOnClickListener(listener);
        secondOption.setOnClickListener(listener);
        thirdOption.setOnClickListener(listener);
        fourthOption.setOnClickListener(listener);
    }

    /**
     *
     * @param selectedButton - reprezentat de butonul care este selectat
     * @param otherButtons - reprezintă  un Array compus din restul butoanelor
     * @param isSelected - o variabila booleana utilizată pentru a vedea daca butonul a fost selectat/deselectat
     * @param scoreChange - reprezintă variabila in care se salvează scorul obtinut in urma selectarii/deselectarii butoanelor
     * functia primește un buton selectat, un vector de alte butoane, un indicator de selecție, și o modificare a scorului asociată acestei selecții.
     * dacă butonul nu este selectat, funcția va actualiza scorul prin adăugarea/modificarea scorului scoreChange si  dezactivează celelalte butoane din vectorul otherButtons.
     */
    private void updateButtonsState(Button selectedButton, Button[] otherButtons, boolean isSelected, int scoreChange) {
        Context context = selectedButton.getContext();
        if (!isSelected) {
            score += scoreChange;
            for (Button button : otherButtons) {
                button.setEnabled(false);
                button.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
            }
            selectedButton.setBackgroundColor(ContextCompat.getColor(context, R.color.lavender));
            selectedButton.setSelected(true);
        } else {
            score -= scoreChange;
            for (Button button : otherButtons) {
                button.setEnabled(true);
                button.setBackgroundColor(ContextCompat.getColor(context, R.color.floral));
            }
            selectedButton.setBackgroundColor(ContextCompat.getColor(context, R.color.floral));
            selectedButton.setSelected(false);
        }
    }
}