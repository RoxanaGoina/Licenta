package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.color.utilities.Score;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoricActivity extends AppCompatActivity {

    private final String DatabaseURL = "https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app";
    private List<SleepItem> sleepItems = new ArrayList<>();
    private List<ScoreItem> scoreItemList = new ArrayList<>();
    private TextView simptomDay1;
    private TextView simptomDay2;
    private TextView simptomDay3;
    private TextView simptomDay4;
    private TextView simptomDay5;
    private TextView simptomDay6;
    private TextView simptomDay7;
    private TextView sleepHourDay1;
    private TextView sleepHourDay2;
    private TextView sleepHourDay3;
    private TextView sleepHourDay4;
    private TextView sleepHourDay5;
    private TextView sleepHourDay6;
    private TextView sleepHourDay7;
    private TextView scoreDay1;
    private TextView scoreDay2;
    private TextView scoreDay3;
    private TextView scoreDay4;
    private TextView scoreDay5;
    private TextView scoreDay6;
    private TextView scoreDay7;

    private TextView heartRateDay1;
    private TextView heartRateDay2;
    private TextView heartRateDay3;
    private TextView heartRateDay4;
    private TextView heartRateDay5;
    private TextView heartRateDay6;
    private TextView heartRateDay7;


    private CardView day1CardView;
    private CardView day2CardView;
    private CardView day3CardView;
    private CardView day4CardView;
    private CardView day5CardView;
    private CardView day6CardView;
    private CardView day7CardView;

    private List<CardView> cardViewList = new ArrayList<>();
    FirebaseUser firebaseUser;
    private List<Symptom> symptomsList = new ArrayList<>();
    private List<SleepItem> sleepItemList = new ArrayList<>();
    private List<TextView> sleepScores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);


        initializeElements();
        symptonFunction();
        sleepFunction();
        heartRateFunction();
//        colorTheCardView();

    }

    /**
     * functia este utilizata pentru a realiza legatura intre elementele din fisierele XML si cele declarate in clasa
     */
    private void initializeElements(){
        simptomDay1 = findViewById(R.id.simptomDay1);
        simptomDay2 = findViewById(R.id.simptomDay2);
        simptomDay3 = findViewById(R.id.simptomDay3);
        simptomDay4 = findViewById(R.id.simptomDay4);
        simptomDay5 = findViewById(R.id.simptomDay5);
        simptomDay6 = findViewById(R.id.simptomDay6);
        simptomDay7 = findViewById(R.id.simptomDay7);
        sleepHourDay1 = findViewById(R.id.sleepHourDay1);
        sleepHourDay2 = findViewById(R.id.sleepHourDay2);
        sleepHourDay3 = findViewById(R.id.sleepHourDay3);
        sleepHourDay4 = findViewById(R.id.sleepHourDay4);
        sleepHourDay5 = findViewById(R.id.sleepHourDay5);
        sleepHourDay6 = findViewById(R.id.sleepHourDay6);
        sleepHourDay7 = findViewById(R.id.sleepHourDay7);
        scoreDay1 = findViewById(R.id.scoreSleepDay1);
        scoreDay2 = findViewById(R.id.scoreSleepDay2);
        scoreDay3 = findViewById(R.id.scoreSleepDay3);
        scoreDay4 = findViewById(R.id.scoreSleepDay4);
        scoreDay5 = findViewById(R.id.scoreSleepDay5);
        scoreDay6 = findViewById(R.id.scoreSleepDay6);
        scoreDay7 = findViewById(R.id.scoreSleepDay7);
        heartRateDay1 = findViewById(R.id.heartRateDay1);
        heartRateDay2 = findViewById(R.id.heartRateDay2);
        heartRateDay3 = findViewById(R.id.heartRateDay3);
        heartRateDay4 = findViewById(R.id.heartRateDay4);
        heartRateDay5 = findViewById(R.id.heartRateDay5);
        heartRateDay6 = findViewById(R.id.heartRateDay6);
        heartRateDay7 = findViewById(R.id.heartRateDay7);
        day1CardView = findViewById(R.id.day1);
        day2CardView = findViewById(R.id.day2);
        day3CardView = findViewById(R.id.day3);
        day4CardView = findViewById(R.id.day4);
        day5CardView = findViewById(R.id.day5);
        day6CardView = findViewById(R.id.day6);
        day7CardView = findViewById(R.id.day7);
        cardViewList.add(day1CardView);
        cardViewList.add(day2CardView);
        cardViewList.add(day3CardView);
        cardViewList.add(day4CardView);
        cardViewList.add(day5CardView);
        cardViewList.add(day6CardView);
        cardViewList.add(day7CardView);

        sleepScores.add(scoreDay1);
        sleepScores.add(scoreDay2);
        sleepScores.add(scoreDay3);
        sleepScores.add(scoreDay4);
        sleepScores.add(scoreDay5);
        sleepScores.add(scoreDay6);
        sleepScores.add(scoreDay7);
    }

    /**
     * converteste un numar zecimal de ore de somn intr-un format de ore si minute.
     *
     * @param hoursDecimal numarul de ore de somn, exprimat ca numar zecimal
     * @return un șir de caractere care reprezintă numarul de ore și minute
     *

     * se  extrage partea intreaga a numarului de ore.
     * se calculeaza partea zecimala a numarului de ore si o convertește in minute; formateaza si returnează rezultatul sub forma "X ore Y minute".
     */
    public static String convertSleepHours(double hoursDecimal) {
        int hours = (int) hoursDecimal;
        double minutesDecimal = (hoursDecimal - hours) * 100;
        int minutes = (int) Math.round(minutesDecimal);
        return hours + " ore " + minutes + " minute";
    }


    /**
     * genereaza un String  cu simptomele raportate pentru o anumita zi.
     *
     * @param symptomsList lista tuturor simptomelor, fiecare avand o data asociata
     * @param day numarul de zile în urma pentru care se doresc simptomele
     * @return un String care contine numele simptomelor raportate în ziua specificată, separate prin virgule.
     *
     * se creeaza o lista pentru a stoca simptomele raportate pentru ziua specificata.
     * se obtine data curenta si calculeaza data pentru ziua specificata.
     *  se parcurge lista de simptome si se adauga in lista de verificare simptomele care corespund datei specificate; se concateneaza numele simptomelor din lista de verificare intr-un String
     */
    public String setDailySymptoms(List<Symptom> symptomsList, int day) {
        List<Symptom> simptomListCheck = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (Symptom symptom : symptomsList) {
            LocalDate symptomDate = LocalDate.parse(symptom.getDate());
            LocalDate dayMinus = currentDate.minusDays(day);
            if (symptomDate.equals(dayMinus)) {
                simptomListCheck.add(symptom);
            }
        }
        String text = "";
        if (!simptomListCheck.isEmpty()) {
            for (int i = 0; i < simptomListCheck.size() - 1; i++) {
                Symptom currentSymptom = simptomListCheck.get(i);
                text = text + currentSymptom.getName() + ", ";
            }

            text = text + simptomListCheck.get(simptomListCheck.size() - 1).getName();
            return text;
        }
        return "";
    }

    /**
     * se incarca si se parseaza date JSON dintr-un DataSnapshot si se adauga simptomele intr-o listă de simptome.
     *
     * @param dataSnapshot obiectul DataSnapshot din Firebase, care contine datele JSON sub forma de String;
     * se  obtine sirul JSON din DataSnapshot.
     * se parsează sirul JSON într-un JSONArray.
     *  se parcurge JSONArray si extrage fiecare obiect JSON individual.
     *  creeaza un obiect Symptom pentru fiecare obiect JSON si il adauga in lista de simptome.
     */

    public void loadJson(DataSnapshot dataSnapshot) {
        String json = dataSnapshot.getValue(String.class);

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String date = jsonObject.getString("date");
                    Symptom symptom = new Symptom(name, date);
                    symptomsList.add(symptom);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public void loadJsonFromCSV(DataSnapshot dataSnapshot) {
        String json = dataSnapshot.getValue(String.class);

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String sleepHours = jsonObject.getString("sleepHours");
                    String date = jsonObject.getString("date");
                    Integer score = jsonObject.getInt("score");
                    SleepItem sleepItem = new SleepItem(date, Double.valueOf(sleepHours), Integer.valueOf(score));
                    sleepItemList.add(sleepItem);
                    Log.d("TAG", sleepItemList.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * metoda  proceseaza datele JSON obținute dintr-un obiect `DataSnapshot` si le încarca intr-o lista
     * de obiecte `ScoreItem`; datele JSON sunt așteptate să fie sub forma unei liste JSON
     *
     *  se obtin datele JSON sub formă de String din `DataSnapshot`.
     *  se creează obiecte `ScoreItem` din datele parcurse si le adauga in lista `scoreItemList`.
     *
     * @param dataSnapshot Obiectul `DataSnapshot` care conține datele JSON.
     */
    private void loadHeartRateJson(DataSnapshot dataSnapshot) {
        String json = dataSnapshot.getValue(String.class);

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String date = jsonObject.getString("date");
                    Double score = jsonObject.getDouble("heartRate");
                    ScoreItem scoreItem = new ScoreItem(date, score);
                    scoreItemList.add(scoreItem);
                    Log.d("TAG", scoreItemList.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * functia actualizeaza interfaaa cu informatiile despre orele de somn și scorurile somnului pentru ultimele 7 zile.
     * Datele sunt obținute din lista `sleepItemList`, iar informațiile sunt afișate în TextView-urile si CardView-urile corespunzătoare pentru fiecare zi.
     * se obtine data curenta.
     * se parcurge lista `sleepItemList` pentru a obtine informatiile despre somn.
     * se compara data fiecarui element din lista cu ultimele 7 zile si se  actualizeaza TextView-urile cu datele corespunzataore
     */
    private void setScoreAndSleepHours() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (SleepItem sleepItem : sleepItemList) {
            LocalDate parsedDate = LocalDate.parse(sleepItem.getDate(), formatter);

            if (parsedDate.equals(today.minusDays(50))) {
                sleepHourDay1.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay1.setText("Scorul somnului : " + sleepItem.getScoreSleep());
                colorCardViews(sleepItem.getScoreSleep(),day1CardView);
            } else if (parsedDate.equals(today.minusDays(51))) {
                sleepHourDay2.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay2.setText("Scorul somnului: " + sleepItem.getScoreSleep());
                colorCardViews(sleepItem.getScoreSleep(),day2CardView);
            } else if (parsedDate.equals(today.minusDays(52))) {
                sleepHourDay3.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay3.setText("Scorul somnului: " + sleepItem.getScoreSleep());
                colorCardViews(sleepItem.getScoreSleep(),day3CardView);
            } else if (parsedDate.equals(today.minusDays(53))) {
                sleepHourDay4.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay4.setText("Scorul somnului: " + sleepItem.getScoreSleep());
                colorCardViews(sleepItem.getScoreSleep(),day4CardView);
            } else if (parsedDate.equals(today.minusDays(54))) {
                sleepHourDay5.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay5.setText("Scorul somnului: " + sleepItem.getScoreSleep());
                colorCardViews(sleepItem.getScoreSleep(),day5CardView);
            } else if (parsedDate.equals(today.minusDays(55))) {
                colorCardViews(sleepItem.getScoreSleep(),day6CardView);
                sleepHourDay6.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay6.setText("Scorul somnului: " + sleepItem.getScoreSleep());
            } else if (parsedDate.equals(today.minusDays(56))) {
                colorCardViews(sleepItem.getScoreSleep(),day7CardView);
                sleepHourDay7.setText("Ore de somn: " + convertSleepHours(sleepItem.getSleepHours()));
                scoreDay7.setText("Scorul somnului: " + sleepItem.getScoreSleep());
            }


        }

    }

    /**
     *
     *  functia incarca datele despre simptomele utilizatorului din Firebase si actualizeaza interfața cu simptomele raportate pentru ultimele 7 zile.
     * se creeaza o referinta la baza de date Firebase pentru datele despre simptomele utilizatorului.
     * se  adauga un ValueEventListener pentru a prelua datele din Firebase.
     * actualizeaza interfata cu simptomele raportate pentru fiecare din ultimele 7 zile.
     *  */

    private void symptonFunction() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance(DatabaseURL)
                    .getReference()
                    .child("username")
                    .child(userId)
                    .child("symptomps");
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    LocalDate currentDate = LocalDate.now();

                    loadJson(dataSnapshot);
                    Log.d("JSON", symptomsList.toString());
                    List<Symptom> simptomListCheck = new ArrayList<>();

                    for (Symptom symptom : symptomsList) {
                        LocalDate symptomDate = LocalDate.parse(symptom.getDate());
                        if (symptomDate.equals(currentDate)) {
                            simptomListCheck.add(symptom);
                        }
                    }
                    String text = "";
                    if (!simptomListCheck.isEmpty()) {
                        for (int i = 0; i < simptomListCheck.size() - 1; i++) {
                            Symptom currentSymptom = simptomListCheck.get(i);
                            text = text + currentSymptom.getName() + ", ";
                        }
                        text = text + simptomListCheck.get(simptomListCheck.size() - 1).getName();
                        simptomDay1.setText("Simptome:  " + text);
                    }
                    simptomDay2.setText("Simptome: " + setDailySymptoms(symptomsList, 1));
                    simptomDay3.setText("Simptome: " + setDailySymptoms(symptomsList, 2));
                    simptomDay4.setText("Simptome: " + setDailySymptoms(symptomsList, 3));
                    simptomDay5.setText("Simptome: " + setDailySymptoms(symptomsList, 4));
                    simptomDay6.setText("Simptome: " + setDailySymptoms(symptomsList, 5));
                    simptomDay7.setText("Simptome: " + setDailySymptoms(symptomsList, 6));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    /**
     * functia încarca datele despre somnul  utilizatorului din Firebase și actualizează interfața cu valorile somnului  pentru ultimele 7 zile.
     * se creeaza o referinta la baza de date Firebase pentru datele despre somnul  utilizatorului; adauga un ValueEventListener pentru a prelua datele din Firebase.
     * * actualizeaza interfața cu valorile preluate din baza de date
     */

    private void sleepFunction() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId1 = user.getUid();
            DatabaseReference databaseReference1 = FirebaseDatabase.getInstance(DatabaseURL)
                    .getReference()
                    .child("dataSleep")
                    .child(userId1)
                    .child("data");
            databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    loadJsonFromCSV(snapshot);
                    setScoreAndSleepHours();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }

    /**
     * functia încarca datele despre ritmul cardiac al utilizatorului din Firebase și actualizeaza interfața cu valorile medii ale ritmului cardiac pentru ultimele 7 zile.
     * functia creeaza o referinta la baza de date Firebase pentru datele despre ritmul cardiac ale utilizatorului; adauga un ValueEventListener pentru a prelua datele din Firebase.
     * actualizeaza interfața cu valorile medii ale ritmului cardiac pentru ultimele 7 zile.

     */


    private void heartRateFunction() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId1 = user.getUid();
            DatabaseReference databaseReference1 = FirebaseDatabase.getInstance(DatabaseURL)
                    .getReference()
                    .child("heartRate")
                    .child(userId1)
                    .child("data");
            databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    loadHeartRateJson(snapshot);
                    LocalDate today = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    for (ScoreItem scoreItem : scoreItemList) {
                        LocalDate parsedDate = LocalDate.parse(scoreItem.getDate(), formatter);
                        if (parsedDate.equals(today.minusDays(50))) {
                            heartRateDay1.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(51))) {
                            heartRateDay2.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(52))) {
                            heartRateDay3.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(53))) {
                            heartRateDay4.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(54))) {
                            heartRateDay5.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(55))) {
                            heartRateDay6.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        } else if (parsedDate.equals(today.minusDays(56))) {
                            heartRateDay7.setText("Puls mediu  : " + (int) scoreItem.getHeartRate());
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }

    public static double twoDecimals(double number) {

        return Math.floor(number * 100) / 100;
    }

    /**
     *
     * @param score - scorul somnului intr-o zi
     * @param cardView - cardview-ul care contine scorul somnului
     * functia coloreaza cardview-ului in functie de scorul somnului trimis ca parametru; daca scorul are o valoare mai mica de 85, se coloreaza in rosu, in caz contrar, se coloreaza in verde
     */
    private void colorCardViews(int score, CardView cardView) {
        if (score < 85)
            cardView.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.imperialRed));
        else
            cardView.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.chartreuse));

    }




}