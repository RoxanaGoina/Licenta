package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricActivity extends AppCompatActivity {

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
    private List<Symptom> symptomsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);
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

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
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
                        LocalDate dayMinusOne = currentDate.minusDays(1);
                        Log.d("yesterday date", dayMinusOne.toString());
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
                    SleepDataParser parser = new SleepDataParser();
                    List<SleepDataParser.SleepData> sleepDataList = parser.readCsvFromAssets(HistoricActivity.this, "D://Facultate//Anul 3//Licenta//app//src//main//assets//SLEEP_1716998492958.csv");
                    for (SleepDataParser.SleepData data : sleepDataList) {
                        Log.d("Date", data.date);
                        System.out.println("Date: " + data.date + ", Hours of Sleep: " + data.hourSleep);
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }
        Log.d("JSON", symptomsList.toString());
    }

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

    public void loadJson(DataSnapshot dataSnapshot) {
        String json = dataSnapshot.getValue(String.class);

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String date = jsonObject.getString("date");
                    // symptomsName.add(name);
                    Symptom symptom = new Symptom(name, date);
                    //Log.d("TAG",symptom.getName());
                    //Log.d("TAG",symptom.getDate());
                    symptomsList.add(symptom);
                    // Log.d("TAG",symptom.getName());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void extractCSV() {

    }
}