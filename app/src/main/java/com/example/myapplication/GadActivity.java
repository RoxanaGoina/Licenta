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

    private int score = 0;

    // Declararea butoanelor pentru fiecare întrebare
    private Button firstQuestionFirstAnswer, firstQuestionSecondAnswer, firstQuestionThirdAnswer, firstQuestionFourthAnswer;
    private Button secondQuestionFirstAnswer, secondQuestionSecondAnswer, secondQuestionThirdAnswer, secondQuestionFourthAnswer;
    private Button thirdQuestionFirstAnswer, thirdQuestionSecondAnswer, thirdQuestionThirdAnswer, thirdQuestionFourthAnswer;
    private Button fourthQuestionFirstAnswer, fourthQuestionSecondAnswer, fourthQuestionThirdAnswer, fourthQuestionFourthAnswer;
    private Button fifthQuestionFirstAnswer, fifthQuestionSecondAnswer, fifthQuestionThirdAnswer, fifthQuestionFourthAnswer;
    private Button sixthQuestionFirstAnswer, sixthQuestionSecondAnswer, sixthQuestionThirdAnswer, sixthQuestionFourthAnswer;
    private Button seventhQuestionFirstAnswer, seventhQuestionSecondAnswer, seventhQuestionThirdAnswer, seventhQuestionFourthAnswer;
    private Button finalizeGADTest;

    // Matricea butoanelor pentru fiecare întrebare
    Button[][] gadAnswerButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gad);

        // Inițializarea butoanelor
        initializeElements();

        // Configurarea comportamentului butoanelor pentru fiecare întrebare
        setupQuestionsButtons(firstQuestionFirstAnswer, firstQuestionSecondAnswer, firstQuestionThirdAnswer, firstQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(secondQuestionFirstAnswer, secondQuestionSecondAnswer, secondQuestionThirdAnswer, secondQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(thirdQuestionFirstAnswer, thirdQuestionSecondAnswer, thirdQuestionThirdAnswer, thirdQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(fourthQuestionFirstAnswer, fourthQuestionSecondAnswer, fourthQuestionThirdAnswer, fourthQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(fifthQuestionFirstAnswer, fifthQuestionSecondAnswer, fifthQuestionThirdAnswer, fifthQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(sixthQuestionFirstAnswer, sixthQuestionSecondAnswer, sixthQuestionThirdAnswer, sixthQuestionFourthAnswer,
                0, 1, 2, 3);
        setupQuestionsButtons(seventhQuestionFirstAnswer, seventhQuestionSecondAnswer, seventhQuestionThirdAnswer, seventhQuestionFourthAnswer,
                0, 1, 2, 3);

        // Setarea listener-ului pentru butonul de finalizare
        finalizeGADTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizeGadTest();
            }
        });
    }

    // Metodă pentru finalizarea testului GAD
    /**
     * finalizează testul GAD, verifica dacă toate întrebările au primit un răspuns, calculează severitatea scorului,
     * afișează scorul și severitatea acestuia, si salveaza scorul în baza de date Firebase.
     *
     *
     * se veerifica daca la toate întrebările s-a selectat un răspuns.
     * se calculeaz și afișeaza severitatea scorului.
     * salvează scorul în baza de date Firebase pentru utilizatorul curent.
     */
    private void finalizeGadTest() {
        // se verifica daca la toate intrebarile s-a selectat un raspuns
        if (!checkAllQuestionsAnswered()) {
            String errorMessage = "Răspundeți la toate întrebările";
            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
            return;
        }

        //  calculam severitatea scorului
        String severity = scoreRange(score);
        String message = "Scorul tău este: " + score + "\n " + severity;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        // salvarea scorului în baza de date Firebase
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
                finish(); // Terminăm activitatea curentă pentru a elibera resursele
            }
        }, 500); // Așteptăm 500ms înainte de a porni următoarea activitate
    }

    // Metodă pentru inițializarea butoanelor
    private void initializeElements() {
        firstQuestionFirstAnswer = findViewById(R.id.firstQuestionFirstAnswer);
        firstQuestionSecondAnswer = findViewById(R.id.firstQuestionSecondAnswer);
        firstQuestionThirdAnswer = findViewById(R.id.firstQuestionThirdAnswer);
        firstQuestionFourthAnswer = findViewById(R.id.firstQuestionFourthAnswer);

        secondQuestionFirstAnswer = findViewById(R.id.secondQuestionFirstAnswer);
        secondQuestionSecondAnswer = findViewById(R.id.secondQuestionSecondAnswer);
        secondQuestionThirdAnswer = findViewById(R.id.secondQuestionThirdAnswer);
        secondQuestionFourthAnswer = findViewById(R.id.secondQuestionFourthAnswer);

        thirdQuestionFirstAnswer = findViewById(R.id.thirdQuestionFirstAnswer);
        thirdQuestionSecondAnswer = findViewById(R.id.thirdQuestionSecondAnswer);
        thirdQuestionThirdAnswer = findViewById(R.id.thirdQuestionThirdAnswer);
        thirdQuestionFourthAnswer = findViewById(R.id.thirdQuestionFourthAnswer);

        fourthQuestionFirstAnswer = findViewById(R.id.fourthQuestionFirstAnswer);
        fourthQuestionSecondAnswer = findViewById(R.id.fourthQuestionSecondAnswer);
        fourthQuestionThirdAnswer = findViewById(R.id.fourthQuestionThirdAnswer);
        fourthQuestionFourthAnswer = findViewById(R.id.fourthQuestionFourthAnswer);

        fifthQuestionFirstAnswer = findViewById(R.id.fifthQuestionFirstAnswer);
        fifthQuestionSecondAnswer = findViewById(R.id.fifthQuestionSecondAnswer);
        fifthQuestionThirdAnswer = findViewById(R.id.fifthQuestionThirdAnswer);
        fifthQuestionFourthAnswer = findViewById(R.id.fifthQuestionFourthAnswer);

        sixthQuestionFirstAnswer = findViewById(R.id.sixthQuestionFirstAnswer);
        sixthQuestionSecondAnswer = findViewById(R.id.sixthQuestionSecondAnswer);
        sixthQuestionThirdAnswer = findViewById(R.id.sixthQuestionThirdAnswer);
        sixthQuestionFourthAnswer = findViewById(R.id.sixthQuestionFourthAnswer);

        seventhQuestionFirstAnswer = findViewById(R.id.seventhQuestionFirstAnswer);
        seventhQuestionSecondAnswer = findViewById(R.id.seventhQuestionSecondAnswer);
        seventhQuestionThirdAnswer = findViewById(R.id.seventhQuestionThirdAnswer);
        seventhQuestionFourthAnswer = findViewById(R.id.seventhQuestionFourthAnswer);

        finalizeGADTest = findViewById(R.id.finalizeGADTest);

        // Inițializarea matricei butoanelor
        gadAnswerButtons = new Button[][]{
                {firstQuestionFirstAnswer, firstQuestionSecondAnswer, firstQuestionThirdAnswer, firstQuestionFourthAnswer},
                {secondQuestionFirstAnswer, secondQuestionSecondAnswer, secondQuestionThirdAnswer, secondQuestionFourthAnswer},
                {thirdQuestionFirstAnswer, thirdQuestionSecondAnswer, thirdQuestionThirdAnswer, thirdQuestionFourthAnswer},
                {fourthQuestionFirstAnswer, fourthQuestionSecondAnswer, fourthQuestionThirdAnswer, fourthQuestionFourthAnswer},
                {fifthQuestionFirstAnswer, fifthQuestionSecondAnswer, fifthQuestionThirdAnswer, fifthQuestionFourthAnswer},
                {sixthQuestionFirstAnswer, sixthQuestionSecondAnswer, sixthQuestionThirdAnswer, sixthQuestionFourthAnswer},
                {seventhQuestionFirstAnswer, seventhQuestionSecondAnswer, seventhQuestionThirdAnswer, seventhQuestionFourthAnswer}
        };
    }

    // Metodă pentru configurarea comportamentului butoanelor pentru o singură întrebare
    /**
     * Configurează butoanele de răspuns pentru întrebări, adăugându-le un `OnClickListener` comun.
     *
     * @param firstAnswer primul buton de răspuns.
     * @param secondAnswer al doilea buton de răspuns.
     * @param thirdAnswer al treilea buton de răspuns.
     * @param fourthAnswer al patrulea buton de răspuns.
     * @param scoreChange1 modificarea scorului asociata primului răspuns.
     * @param scoreChange2 modificarea scorului asociata celui de-al doilea răspuns.
     * @param scoreChange3 modificarea scorului asociata celui de-al treilea răspuns.
     * @param scoreChange4 modificarea scorului asociata celui de-al patrulea răspuns.
     *

     * se creează un `OnClickListener` comun pentru toate butoanele de răspuns.
     * se determina care buton a fost apăsat și actualizeaza starea acestuia și a celorlalte butoane; ulterior se modifică starea de selecție a butoanelor și scorul în funcție de răspunsul selectat.
     */
    private void setupQuestionsButtons(final Button firstAnswer, final Button secondAnswer, final Button thirdAnswer, final Button fourthAnswer,
                                       final int scoreChange1, final int scoreChange2, final int scoreChange3, final int scoreChange4) {
        View.OnClickListener listener = new View.OnClickListener() {
            boolean isQuestionSelected = false;

            @Override
            public void onClick(View view) {
                Button selectedButton = (Button) view;
                Button[] otherButtons;

                // Determinăm care buton a fost apăsat și actualizăm starea acestuia
                if (selectedButton == firstAnswer) {
                    otherButtons = new Button[]{secondAnswer, thirdAnswer, fourthAnswer};
                    updateButtonState(firstAnswer, otherButtons, isQuestionSelected, scoreChange1);
                } else if (selectedButton == secondAnswer) {
                    otherButtons = new Button[]{firstAnswer, thirdAnswer, fourthAnswer};
                    updateButtonState(secondAnswer, otherButtons, isQuestionSelected, scoreChange2);
                } else if (selectedButton == thirdAnswer) {
                    otherButtons = new Button[]{firstAnswer, secondAnswer, fourthAnswer};
                    updateButtonState(thirdAnswer, otherButtons, isQuestionSelected, scoreChange3);
                } else if (selectedButton == fourthAnswer) {
                    otherButtons = new Button[]{firstAnswer, secondAnswer, thirdAnswer};
                    updateButtonState(fourthAnswer, otherButtons, isQuestionSelected, scoreChange4);
                }

                isQuestionSelected = !isQuestionSelected; // Toggle the selection state
            }
        };

        // Setăm listener-ul de click pentru fiecare buton de răspuns
        firstAnswer.setOnClickListener(listener);
        secondAnswer.setOnClickListener(listener);
        thirdAnswer.setOnClickListener(listener);
        fourthAnswer.setOnClickListener(listener);
    }

    // Metodă pentru actualizarea stării unui buton și a celorlalte butoane din același set

    /**
     * @param selectedButton butonul care a fost selectat/deselectat.
     * @param otherButtons   un array de butoane care trebuie dezactivate/activate în funcție de selecția `selectedButton`.
     * @param isSelected     starea curentă de selecție a `selectedButton`.
     * @param scoreChange    valoarea cu care trebuie modificat scorul.
     *
     * dacă selectedButton nu este selectat se incrementeaza scorul cu  valoarea scoreChange;dezactiveaza si schimba culoarea tuturor butoanelor din `otherButtons`.
     * ulterior seschimba culoarea selectedButton si îl seteaza ca selectat.
     * dacă selectedButton este selectat se decrementează scorul cu valoarea scoreChange; activează si schimba culoarea tuturor butoanelor din `otherButtons`; iar ulterior
     * se schimba culoarea `selectedButton` și îl setează ca ne-selectat.
     */
    private void updateButtonState(Button selectedButton, Button[] otherButtons, boolean isSelected, int scoreChange) {
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

    // Metodă pentru verificarea dacă s-a raspuns la toate intrebarile

    /**
     * functia verifica daca pentru pentru fiecare intrebare s-a selectat un raspuns.
     * se utilizeaza o matrice in care fiecare linie, este reprezentata de butoanele de la fiecare intrebare
     *
     * @return functia returneaza o valoare booleana, true daca s-a selectat un raspuns pt fiecare intrebare ; false in caz contrar
     */
    private boolean checkAllQuestionsAnswered() {
        for (Button[] buttons : gadAnswerButtons) {
            boolean questionAnswered = false;
            for (Button button : buttons) {
                if (button.isSelected()) {
                    questionAnswered = true;
                    break;
                }
            }
            if (!questionAnswered) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param score - scorul obtinut in utma finalizarii testului
     * @return - se returneaza un text in functie de range-ul in care se afla scorul primit ca parametru
     */
    // Metodă pentru determinarea nivelului de anxietate în funcție de scor
    private String scoreRange(int score) {
        if (score >= 0 && score <= 4)
            return "Nivel anxietate : Minim";
        else if (score >= 5 && score <= 9)
            return "Nivel anxietate : Ușoară";
        else if (score >= 10 && score <= 14)
            return "Nivel anxietate : Moderată";
        else
            return "Nivel anxietate : Severă";
    }
}
