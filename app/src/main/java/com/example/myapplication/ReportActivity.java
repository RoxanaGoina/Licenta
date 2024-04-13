package com.example.myapplication;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private List<CheckBox> checkBoxList;

    private CheckBox checkBoxSadness;
    private CheckBox checkBoxLowSelfEsteem;

    private CheckBox checkBoxGuilty;

    private CheckBox checkBoxFear;

    private CheckBox checkBoxConfusion;

    private CheckBox checkBoxHopeless;

    private CheckBox checkBoxAgitation;

    private CheckBox checkBoxLackOfMotivation;

    private CheckBox checkBoxIrritability;

    private CheckBox checkBoxCrying;

    private CheckBox checkBoxLowEnergy;

    private CheckBox checkBoxNervousness;

    private CheckBox checkBoxSelfHarming;

    private CheckBox checkBoxHelpless;

    private CheckBox checkBoxConcentrateProblem;

    private CheckBox checkboxWeightFluctuations;
    private CheckBox checkboxLackOfEnergy;

    private CheckBox checkboxInsomnia;

    private CheckBox checkboxMusclePain;

    private CheckBox checkboxLowSexDrive;

    private CheckBox checkboxSleepiness;

    private CheckBox checkboxAppetiteFluctuations;

    private CheckBox checkBoxIsolation;

    private CheckBox checkBoxHobbyNeglet;

    private CheckBox checkBoxComunicationLow;

    private CheckBox checkBoxLifeProblem;

    private CheckBox checkBoxComunicationProblem;

    private Button saveSymptomps;

    private List<Symptom> symptomsList = new ArrayList<>();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = currentDate.format(dateFormatter);

    public boolean listContainsObject(String name, String date) {
        if (symptomsList != null) {
            Symptom symptom = new Symptom(name, date);
            return symptomsList.contains(symptom);
        } else {
            return false; // Return false if symptomsList is not yet initialized
        }
    }

    public void loadJson(DataSnapshot dataSnapshot) {
        String json = dataSnapshot.getValue(String.class);
        // symptomsName=new ArrayList();

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
            Log.d("TAG", "Simptome json: " + symptomsList.toString());
        }
    }
    public void colorSaved(Drawable drawableUnchecked,Drawable drawableChecked){
        for(CheckBox checkBox: checkBoxList){
            if (listContainsObject(checkBox.getText().toString(), dateString)) {
                checkBox.setBackground(drawableChecked);
            } else
                checkBox.setBackground(drawableUnchecked);
        }


    }
    public void updateSymptom(Drawable drawableUnchecked,Drawable drawableChecked){
        for(CheckBox checkBox : checkBoxList){
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Symptom symptom = new Symptom(checkBox.getText().toString(), dateString);
                    if (b) {
                        if (listContainsObject(checkBox.getText().toString(), dateString)) {
                            //Toast.makeText(ReportActivity.this, "A fost inclus", Toast.LENGTH_SHORT).show();
                            symptomsList.remove(symptom);
                            checkBox.setBackground(drawableUnchecked);


                        } else {
                            symptomsList.add(symptom);
                            checkBox.setBackground(drawableChecked);
                        }
                    }

                }
            });

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        checkBoxList=new ArrayList<>();
        checkBoxSadness = findViewById(R.id.checkBoxSadness);
        checkBoxList.add(checkBoxSadness);
        checkBoxLowSelfEsteem = findViewById(R.id.checkBoxLowSelfEsteem);
        checkBoxList.add(checkBoxLowSelfEsteem);
        checkBoxGuilty = findViewById(R.id.checkBoxGuilty);
        checkBoxList.add(checkBoxGuilty);
        checkBoxFear = findViewById(R.id.checkBoxFear);
        checkBoxList.add(checkBoxFear);
        checkBoxConfusion = findViewById(R.id.checkBoxConfusion);
        checkBoxList.add(checkBoxConfusion);
        checkBoxHopeless = findViewById(R.id.checkBoxHopeless);
        checkBoxList.add(checkBoxHopeless);
        checkBoxAgitation = findViewById(R.id.checkBoxAgitation);
        checkBoxList.add(checkBoxAgitation);
        checkBoxLackOfMotivation = findViewById(R.id.checkBoxLackOfMotivation);
        checkBoxList.add(checkBoxLackOfMotivation);
        checkBoxIrritability = findViewById(R.id.checkBoxIrritability);
        checkBoxList.add(checkBoxIrritability);
        checkBoxCrying = findViewById(R.id.checkBoxCrying);
        checkBoxList.add(checkBoxCrying);
        checkBoxLowEnergy = findViewById(R.id.checkBoxLowEnergy);
        checkBoxList.add(checkBoxLowEnergy);
        checkBoxNervousness = findViewById(R.id.checkBoxNervousness);
        checkBoxList.add(checkBoxNervousness);
        checkBoxSelfHarming = findViewById(R.id.checkBoxSelfHarming);
        checkBoxList.add(checkBoxSelfHarming);
        checkBoxHelpless = findViewById(R.id.checkBoxHelpless);
        checkBoxList.add(checkBoxHelpless);
        checkBoxConcentrateProblem = findViewById(R.id.checkBoxConcentrateProblem);
        checkBoxList.add(checkBoxConcentrateProblem);

        checkboxWeightFluctuations = findViewById(R.id.checkboxWeightFluctuations);
        checkBoxList.add(checkboxWeightFluctuations);
        checkboxLackOfEnergy = findViewById(R.id.checkboxLackOfEnergy);
        checkBoxList.add(checkboxLackOfEnergy);
        checkboxInsomnia = findViewById(R.id.checkboxInsomnia);
        checkBoxList.add(checkboxInsomnia);
        checkboxMusclePain = findViewById(R.id.checkboxMusclePain);
        checkBoxList.add(checkboxMusclePain);
        checkboxLowSexDrive = findViewById(R.id.checkboxLowSexDrive);
        checkBoxList.add(checkboxLowSexDrive);
        checkboxSleepiness = findViewById(R.id.checkboxSleepiness);
        checkBoxList.add(checkboxSleepiness);
        checkboxAppetiteFluctuations = findViewById(R.id.checkboxAppetiteFluctuations);
        checkBoxList.add(checkboxAppetiteFluctuations);
        checkBoxIsolation = findViewById(R.id.checkBoxIsolation);
        checkBoxList.add(checkBoxIsolation);
        checkBoxHobbyNeglet = findViewById(R.id.checkBoxHobbyNeglet);
        checkBoxList.add(checkBoxHobbyNeglet);
        checkBoxComunicationLow = findViewById(R.id.checkBoxComunicationLow);
        checkBoxList.add(checkBoxComunicationLow);
        checkBoxLifeProblem = findViewById(R.id.checkBoxLifeProblem);
        checkBoxList.add(checkBoxLifeProblem);
        checkBoxComunicationProblem = findViewById(R.id.checkBoxComunicationProblem);
        checkBoxList.add(checkBoxComunicationProblem);
        saveSymptomps = findViewById(R.id.saveEmotions);
        Drawable drawableUnchecked = ContextCompat.getDrawable(this, R.drawable.transparent_checked);
        Drawable drawableChecked = ContextCompat.getDrawable(this, R.drawable.rounder_border);


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

                    loadJson(dataSnapshot);
                    colorSaved(drawableUnchecked,drawableChecked);
                    updateSymptom(drawableUnchecked,drawableChecked);
//


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }




        saveSymptomps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSymptomsToFirebase();
                startActivity(new Intent(ReportActivity.this, MainMenu.class));
            }

            private void saveSymptomsToFirebase() {
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {
                    String userId = firebaseUser.getUid();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                            .getReference()
                            .child("username")
                            .child(userId)
                            .child("symptomps");

                    JSONArray symptoms = new JSONArray();
                    for (Symptom symptom : symptomsList) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("name", symptom.getName());
                            jsonObject.put("date", symptom.getDate());
                            symptoms.put(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    //JSONArray jsonArray = new JSONArray(ReportActivity.this.symptomsList);
                    databaseReference.setValue(symptoms.toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("Firebase", "Symptoms saved successfully");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.e("Firebase", "Failed to save symptoms", e);
                                }
                            });
                }
            }
        });


    }

}