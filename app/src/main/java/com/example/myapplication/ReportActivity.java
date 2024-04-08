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

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

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

    private List<String> symptomsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        checkBoxSadness = findViewById(R.id.checkBoxSadness);
        checkBoxLowSelfEsteem = findViewById(R.id.checkBoxLowSelfEsteem);
        checkBoxGuilty = findViewById(R.id.checkBoxGuilty);
        checkBoxFear = findViewById(R.id.checkBoxFear);
        checkBoxConfusion = findViewById(R.id.checkBoxConfusion);
        checkBoxHopeless = findViewById(R.id.checkBoxHopeless);
        checkBoxAgitation = findViewById(R.id.checkBoxAgitation);
        checkBoxLackOfMotivation = findViewById(R.id.checkBoxLackOfMotivation);
        checkBoxIrritability = findViewById(R.id.checkBoxIrritability);
        checkBoxCrying = findViewById(R.id.checkBoxCrying);
        checkBoxLowEnergy = findViewById(R.id.checkBoxLowEnergy);
        checkBoxNervousness = findViewById(R.id.checkBoxNervousness);
        checkBoxSelfHarming = findViewById(R.id.checkBoxSelfHarming);
        checkBoxHelpless = findViewById(R.id.checkBoxHelpless);
        checkBoxConcentrateProblem = findViewById(R.id.checkBoxConcentrateProblem);

        checkboxWeightFluctuations = findViewById(R.id.checkboxWeightFluctuations);
        checkboxLackOfEnergy = findViewById(R.id.checkboxLackOfEnergy);
        checkboxInsomnia = findViewById(R.id.checkboxInsomnia);
        checkboxMusclePain = findViewById(R.id.checkboxMusclePain);
        checkboxLowSexDrive = findViewById(R.id.checkboxLowSexDrive);
        checkboxSleepiness = findViewById(R.id.checkboxSleepiness);
        checkboxAppetiteFluctuations = findViewById(R.id.checkboxAppetiteFluctuations);
        checkBoxIsolation = findViewById(R.id.checkBoxIsolation);
        checkBoxHobbyNeglet = findViewById(R.id.checkBoxHobbyNeglet);
        checkBoxComunicationLow = findViewById(R.id.checkBoxComunicationLow);
        checkBoxLifeProblem = findViewById(R.id.checkBoxLifeProblem);
        checkBoxComunicationProblem = findViewById(R.id.checkBoxComunicationProblem);
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
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String jsonSymptoms = dataSnapshot.getValue(String.class);
                    if (jsonSymptoms != null) {
                        try {
                            JSONArray jsonArray = new JSONArray(jsonSymptoms);
                            symptomsList = new ArrayList<>();
                            if (symptomsList != null)
                                symptomsList.clear();


                            for (int i = 0; i < jsonArray.length(); i++) {
                                String symptom = jsonArray.getString(i);
                                symptomsList.add(symptom);
                            }

                            if (symptomsList.contains(checkBoxSadness.getText().toString()))
                                checkBoxSadness.setBackground(drawableChecked);
                            else
                                checkBoxSadness.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkBoxLowSelfEsteem.getText().toString()))
                                checkBoxLowSelfEsteem.setBackground(drawableChecked);
                            else
                                checkBoxLowSelfEsteem.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkBoxGuilty.getText().toString()))
                                checkBoxGuilty.setBackground(drawableChecked);
                            else
                                checkBoxGuilty.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkBoxFear.getText().toString()))
                                checkBoxFear.setBackground(drawableChecked);
                            else
                                checkBoxFear.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxConfusion.getText().toString()))
                                checkBoxConfusion.setBackground(drawableChecked);
                            else
                                checkBoxConfusion.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxHopeless.getText().toString()))
                                checkBoxHopeless.setBackground(drawableChecked);
                            else
                                checkBoxHopeless.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxAgitation.getText().toString()))
                                checkBoxAgitation.setBackground(drawableChecked);
                            else
                                checkBoxAgitation.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxLackOfMotivation.getText().toString()))
                                checkBoxLackOfMotivation.setBackground(drawableChecked);
                            else
                                checkBoxLackOfMotivation.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxIrritability.getText().toString()))
                                checkBoxIrritability.setBackground(drawableChecked);
                            else
                                checkBoxIrritability.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxCrying.getText().toString()))
                                checkBoxCrying.setBackground(drawableChecked);
                            else
                                checkBoxCrying.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxLowEnergy.getText().toString()))
                                checkBoxLowEnergy.setBackground(drawableChecked);
                            else
                                checkBoxLowEnergy.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkBoxNervousness.getText().toString()))
                                checkBoxNervousness.setBackground(drawableChecked);
                            else
                                checkBoxNervousness.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxSelfHarming.getText().toString()))
                                checkBoxSelfHarming.setBackground(drawableChecked);
                            else
                                checkBoxSelfHarming.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxHelpless.getText().toString()))
                                checkBoxHelpless.setBackground(drawableChecked);
                            else
                                checkBoxHelpless.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkBoxConcentrateProblem.getText().toString()))
                                checkBoxConcentrateProblem.setBackground(drawableChecked);
                            else
                                checkBoxConcentrateProblem.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkboxWeightFluctuations.getText().toString()))
                                checkboxWeightFluctuations.setBackground(drawableChecked);
                            else
                                checkboxWeightFluctuations.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkboxLackOfEnergy.getText().toString()))
                                checkboxLackOfEnergy.setBackground(drawableChecked);
                            else
                                checkboxLackOfEnergy.setBackground(drawableUnchecked);


                            if (symptomsList.contains(checkboxInsomnia.getText().toString()))
                                checkboxInsomnia.setBackground(drawableChecked);
                            else
                                checkboxInsomnia.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkboxMusclePain.getText().toString()))
                                checkboxMusclePain.setBackground(drawableChecked);
                            else
                                checkboxMusclePain.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkboxLowSexDrive.getText().toString()))
                                checkboxLowSexDrive.setBackground(drawableChecked);
                            else
                                checkboxLowSexDrive.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkboxSleepiness.getText().toString()))
                                checkboxSleepiness.setBackground(drawableChecked);
                            else
                                checkboxSleepiness.setBackground(drawableUnchecked);
                            if (symptomsList.contains(checkboxAppetiteFluctuations.getText().toString()))
                                checkboxAppetiteFluctuations.setBackground(drawableChecked);
                            else
                                checkboxAppetiteFluctuations.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxIsolation.getText().toString()))
                                checkBoxIsolation.setBackground(drawableChecked);
                            else
                                checkBoxIsolation.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxHobbyNeglet.getText().toString()))
                                checkBoxHobbyNeglet.setBackground(drawableChecked);
                            else
                                checkBoxHobbyNeglet.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxComunicationLow.getText().toString()))
                                checkBoxComunicationLow.setBackground(drawableChecked);
                            else
                                checkBoxComunicationLow.setBackground(drawableUnchecked);


                            if (symptomsList.contains(checkBoxLifeProblem.getText().toString()))
                                checkBoxLifeProblem.setBackground(drawableChecked);
                            else
                                checkBoxLifeProblem.setBackground(drawableUnchecked);

                            if (symptomsList.contains(checkBoxComunicationProblem.getText().toString()))
                                checkBoxComunicationProblem.setBackground(drawableChecked);
                            else
                                checkBoxComunicationProblem.setBackground(drawableUnchecked);

                            //ACTUALIZARE
                            // Convertim lista actualizată într-un șir JSON
//                            JSONArray updatedJsonArray = new JSONArray(symptomsList);
//
//                            // Salvăm lista actualizată înapoi în baza de date Firebase
//                            databaseReference.setValue(updatedJsonArray.toString())
//                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                        @Override
//                                        public void onSuccess(Void aVoid) {
//                                            // Operatia de salvare a reusit
//                                            Log.d("Firebase", "Updated symptoms saved successfully");
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            // Operatia de salvare a esuat
//                                            Log.e("Firebase", "Failed to save updated symptoms", e);
//                                        }
//                                    });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Log.e("FirebaseError", "Error fetching data", databaseError.toException());
                }
            });
        }


        checkBoxSadness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxSadness.getText().toString())) {

                        symptomsList.remove(checkBoxSadness.getText().toString());
                        checkBoxSadness.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxSadness.getText().toString());
                        checkBoxSadness.setBackground(drawableChecked);


                    }
                }

            }
        });


        checkBoxLowSelfEsteem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxLowSelfEsteem.getText().toString())) {

                        symptomsList.remove(checkBoxLowSelfEsteem.getText().toString());
                        checkBoxLowSelfEsteem.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxLowSelfEsteem.getText().toString());
                        checkBoxLowSelfEsteem.setBackground(drawableChecked);


                    }

                }
            }
        });

        checkBoxGuilty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxGuilty.getText().toString())) {

                        symptomsList.remove(checkBoxGuilty.getText().toString());
                        checkBoxGuilty.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxGuilty.getText().toString());
                        checkBoxGuilty.setBackground(drawableChecked);


                    }

                }

            }
        });
        checkBoxFear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxFear.getText().toString())) {

                        symptomsList.remove(checkBoxFear.getText().toString());
                        checkBoxFear.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxFear.getText().toString());
                        checkBoxFear.setBackground(drawableChecked);


                    }

                }
            }
        });

        checkBoxConfusion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxConfusion.getText().toString())) {

                        symptomsList.remove(checkBoxConfusion.getText().toString());
                        checkBoxConfusion.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxConfusion.getText().toString());
                        checkBoxConfusion.setBackground(drawableChecked);


                    }
                }
            }
        });

        checkBoxHopeless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxHopeless.getText().toString())) {

                        symptomsList.remove(checkBoxHopeless.getText().toString());
                        checkBoxHopeless.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxHopeless.getText().toString());
                        checkBoxHopeless.setBackground(drawableChecked);


                    }
                }
            }
        });

        checkBoxAgitation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxAgitation.getText().toString())) {

                        symptomsList.remove(checkBoxAgitation.getText().toString());
                        checkBoxAgitation.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxAgitation.getText().toString());
                        checkBoxAgitation.setBackground(drawableChecked);


                    }

                }
            }
        });

        checkBoxLackOfMotivation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxLackOfMotivation.getText().toString())) {

                        symptomsList.remove(checkBoxLackOfMotivation.getText().toString());
                        checkBoxLackOfMotivation.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxLackOfMotivation.getText().toString());
                        checkBoxLackOfMotivation.setBackground(drawableChecked);


                    }

                }
            }
        });
        checkBoxIrritability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxIrritability.getText().toString())) {

                        symptomsList.remove(checkBoxIrritability.getText().toString());
                        checkBoxIrritability.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxIrritability.getText().toString());
                        checkBoxIrritability.setBackground(drawableChecked);


                    }
                }
            }
        });

        checkBoxCrying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxCrying.getText().toString())) {

                        symptomsList.remove(checkBoxCrying.getText().toString());
                        checkBoxCrying.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxCrying.getText().toString());
                        checkBoxCrying.setBackground(drawableChecked);


                    }

                }
            }
        });

        checkBoxLowEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxLowEnergy.getText().toString())) {

                        symptomsList.remove(checkBoxLowEnergy.getText().toString());
                        checkBoxLowEnergy.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxLowEnergy.getText().toString());
                        checkBoxLowEnergy.setBackground(drawableChecked);
                    }
                }
            }
        });

        checkBoxNervousness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxNervousness.getText().toString())) {

                        symptomsList.remove(checkBoxNervousness.getText().toString());
                        checkBoxNervousness.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxNervousness.getText().toString());
                        checkBoxNervousness.setBackground(drawableChecked);
                    }
                }
            }
        });

        checkBoxSelfHarming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if (b) {
                    if (symptomsList.contains(checkBoxSelfHarming.getText().toString())) {

                        symptomsList.remove(checkBoxSelfHarming.getText().toString());
                        checkBoxSelfHarming.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxSelfHarming.getText().toString());
                        checkBoxSelfHarming.setBackground(drawableChecked);
                    }
                }

            }
        });
        checkBoxHelpless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxHelpless.getText().toString())) {

                        symptomsList.remove(checkBoxHelpless.getText().toString());
                        checkBoxHelpless.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxHelpless.getText().toString());
                        checkBoxHelpless.setBackground(drawableChecked);
                    }

                }
            }
        });

        checkBoxConcentrateProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    if (symptomsList.contains(checkBoxConcentrateProblem.getText().toString())) {

                        symptomsList.remove(checkBoxConcentrateProblem.getText().toString());
                        checkBoxConcentrateProblem.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkBoxConcentrateProblem.getText().toString());
                        checkBoxConcentrateProblem.setBackground(drawableChecked);
                    }
                }
            }
        });


        checkboxWeightFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxWeightFluctuations.getText().toString())) {

                        symptomsList.remove(checkboxWeightFluctuations.getText().toString());
                        checkboxWeightFluctuations.setBackground(drawableUnchecked);


                    } else {
                        symptomsList.add(checkboxWeightFluctuations.getText().toString());
                        checkboxWeightFluctuations.setBackground(drawableChecked);
                    }

                }
            }
        });


        checkboxLackOfEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxLackOfEnergy.getText().toString())) {

                        symptomsList.remove(checkboxLackOfEnergy.getText().toString());
                        checkboxLackOfEnergy.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxLackOfEnergy.getText().toString());
                        checkboxLackOfEnergy.setBackground(drawableChecked);
                    }

                }
            }
        });


        checkboxInsomnia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxInsomnia.getText().toString())) {

                        symptomsList.remove(checkboxInsomnia.getText().toString());
                        checkboxInsomnia.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxInsomnia.getText().toString());
                        checkboxInsomnia.setBackground(drawableChecked);
                    }
                }
            }
        });

        checkboxMusclePain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxMusclePain.getText().toString())) {

                        symptomsList.remove(checkboxMusclePain.getText().toString());
                        checkboxMusclePain.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxMusclePain.getText().toString());
                        checkboxMusclePain.setBackground(drawableChecked);
                    }
                }
            }
        });

        checkboxLowSexDrive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxLowSexDrive.getText().toString())) {

                        symptomsList.remove(checkboxLowSexDrive.getText().toString());
                        checkboxLowSexDrive.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxLowSexDrive.getText().toString());
                        checkboxLowSexDrive.setBackground(drawableChecked);
                    }
                }
            }
        });

        checkboxSleepiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxSleepiness.getText().toString())) {

                        symptomsList.remove(checkboxSleepiness.getText().toString());
                        checkboxSleepiness.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxSleepiness.getText().toString());
                        checkboxSleepiness.setBackground(drawableChecked);
                    }

                }
            }
        });

        checkboxAppetiteFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkboxAppetiteFluctuations.getText().toString())) {

                        symptomsList.remove(checkboxAppetiteFluctuations.getText().toString());
                        checkboxAppetiteFluctuations.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkboxAppetiteFluctuations.getText().toString());
                        checkboxAppetiteFluctuations.setBackground(drawableChecked);
                    }


                }
            }
        });

        checkBoxIsolation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxIsolation.getText().toString())) {

                        symptomsList.remove(checkBoxIsolation.getText().toString());
                        checkBoxIsolation.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkBoxIsolation.getText().toString());
                        checkBoxIsolation.setBackground(drawableChecked);
                    }

                }
            }
        });
        checkBoxHobbyNeglet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxHobbyNeglet.getText().toString())) {

                        symptomsList.remove(checkBoxHobbyNeglet.getText().toString());
                        checkBoxHobbyNeglet.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkBoxHobbyNeglet.getText().toString());
                        checkBoxHobbyNeglet.setBackground(drawableChecked);
                    }

                }
            }
        });

        checkBoxComunicationLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxComunicationLow.getText().toString())) {

                        symptomsList.remove(checkBoxComunicationLow.getText().toString());
                        checkBoxComunicationLow.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkBoxComunicationLow.getText().toString());
                        checkBoxComunicationLow.setBackground(drawableChecked);
                    }

                }
            }
        });

        checkBoxLifeProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxLifeProblem.getText().toString())) {

                        symptomsList.remove(checkBoxLifeProblem.getText().toString());
                        checkBoxLifeProblem.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkBoxLifeProblem.getText().toString());
                        checkBoxLifeProblem.setBackground(drawableChecked);
                    }

                }
            }
        });

        checkBoxComunicationProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (symptomsList.contains(checkBoxComunicationProblem.getText().toString())) {

                        symptomsList.remove(checkBoxComunicationProblem.getText().toString());
                        checkBoxComunicationProblem.setBackground(drawableUnchecked);

                    } else {
                        symptomsList.add(checkBoxComunicationProblem.getText().toString());
                        checkBoxComunicationProblem.setBackground(drawableChecked);
                    }

                }
            }
        });

        saveSymptomps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSymptomsToFirebase();
                startActivity(new Intent(ReportActivity.this,MainMenu.class));
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

                    JSONArray jsonArray = new JSONArray(ReportActivity.this.symptomsList);
                    databaseReference.setValue(jsonArray.toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("Firebase", "Symptoms saved successfully");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Operatia de salvare a esuat
                                    Log.e("Firebase", "Failed to save symptoms", e);
                                }
                            });
                }
            }
        });


    }
}