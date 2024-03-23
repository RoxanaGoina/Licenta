package com.example.myapplication;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

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

    private CheckBox  checkBoxComunicationLow;

    private CheckBox checkBoxLifeProblem;

    private CheckBox checkBoxComunicationProblem;


    private List<Symptoms> symptoms;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        checkBoxSadness=findViewById(R.id.checkBoxSadness);
        checkBoxLowSelfEsteem=findViewById(R.id.checkBoxLowSelfEsteem);
        checkBoxGuilty=findViewById(R.id.checkBoxGuilty);
        checkBoxFear=findViewById(R.id.checkBoxFear);
        checkBoxConfusion=findViewById(R.id.checkBoxConfusion);
        checkBoxHopeless=findViewById(R.id.checkBoxHopeless);
        checkBoxAgitation=findViewById(R.id.checkBoxAgitation);
        checkBoxLackOfMotivation=findViewById(R.id.checkBoxLackOfMotivation);
        checkBoxIrritability=findViewById(R.id.checkBoxIrritability);
        checkBoxCrying=findViewById(R.id.checkBoxCrying);
        checkBoxLowEnergy=findViewById(R.id.checkBoxLowEnergy);
        checkBoxNervousness=findViewById(R.id.checkBoxNervousness);
        checkBoxSelfHarming=findViewById(R.id.checkBoxSelfHarming);
        checkBoxHelpless=findViewById(R.id.checkBoxHelpless);
        checkBoxConcentrateProblem=findViewById(R.id.checkBoxConcentrateProblem);
        checkboxWeightFluctuations=findViewById(R.id.checkboxWeightFluctuations);
        checkboxLackOfEnergy=findViewById(R.id.checkboxLackOfEnergy);
        checkboxInsomnia=findViewById(R.id.checkboxInsomnia);
        checkboxMusclePain=findViewById(R.id.checkboxMusclePain);
        checkboxLowSexDrive=findViewById(R.id.checkboxLowSexDrive);
        checkboxSleepiness=findViewById(R.id.checkboxSleepiness);
        checkboxAppetiteFluctuations=findViewById(R.id.checkboxAppetiteFluctuations);
        checkBoxIsolation=findViewById(R.id.checkBoxIsolation);
        checkBoxHobbyNeglet=findViewById(R.id.checkBoxHobbyNeglet);
        checkBoxComunicationLow=findViewById(R.id.checkBoxComunicationLow);
        checkBoxLifeProblem=findViewById(R.id.checkBoxLifeProblem);
        checkBoxComunicationProblem=findViewById(R.id.checkBoxComunicationProblem);

        symptoms=new ArrayList<>();

        Drawable drawableUnchecked = ContextCompat.getDrawable(this,R.drawable.transparent_checked);
        Drawable drawableChecked=ContextCompat.getDrawable(this, R.drawable.rounder_border);

        //Drawable drawableUnchecked = ContextCompat.getDrawable(this, R.drawable.rounder_border);
       // Drawable drawableChecked=ContextCompat.getDrawable(this,R.drawable.transparent_checked);
        checkBoxSadness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                       checkBoxSadness.setBackground(drawableChecked);
                       symptoms.add(Symptoms.Sadness);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSadness.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Sadness);
                }
            }
        });

        checkBoxLowSelfEsteem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LowEsteem);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LowEsteem);
                }
            }
        });

        checkBoxGuilty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Guilty);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Guilty);

                }

            }
        });
        checkBoxFear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Fear);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Fear);
                }
            }
        });

        checkBoxConfusion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Confusion);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Confusion);

                }
            }
        });

        checkBoxHopeless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LackOfHope);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LackOfHope);
                }
            }
        });

        checkBoxAgitation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Restlessness);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Restlessness);
                }
            }
        });

        checkBoxLackOfMotivation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LackOfMotivation);


                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LackOfMotivation);

                }
            }
        });
        checkBoxIrritability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Irritability);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Irritability);
                }
            }
        });

        checkBoxCrying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Teary);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Teary);

                }
            }
        });

        checkBoxLowEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Tiredness);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Tiredness);

                }
            }
        });

        checkBoxNervousness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Nervousness);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Nervousness);

                }
            }
        });

        checkBoxSelfHarming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableChecked);
                    symptoms.add(Symptoms.SelfMutilation);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.SelfMutilation);

                }

            }
        });
        checkBoxHelpless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Helpless);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Helpless);

                }
            }
        });

        checkBoxConcentrateProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableChecked);
                    symptoms.add(Symptoms.ConcentrationProblems);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.ConcentrationProblems);
                }
            }
        });


        checkboxWeightFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableChecked);
                    symptoms.add(Symptoms.WeightFlucturations);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.WeightFlucturations);

                }
            }
        });


        checkboxLackOfEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LackOfEnergy);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LackOfEnergy);

                }
            }
        });


        checkboxInsomnia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Sleeplessness);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Sleeplessness);
                }
            }
        });

        checkboxMusclePain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableChecked);
                    symptoms.add(Symptoms.PainMuscle);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.PainMuscle);

                }
            }
        });

        checkboxLowSexDrive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LowSexDrive);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LowSexDrive);

                }
            }
        });

        checkboxSleepiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableChecked);
                    symptoms.add(Symptoms.Sleepiness);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.Sleepiness);

                }
            }
        });

        checkboxAppetiteFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableChecked);
                    symptoms.add(Symptoms.AppetiteFluctuations);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.AppetiteFluctuations);


                }
            }
        });

        checkBoxIsolation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableChecked);
                    symptoms.add(Symptoms.IsolationDesire);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.IsolationDesire);

                }
            }
        });
        checkBoxHobbyNeglet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableChecked);
                    symptoms.add(Symptoms.HobbyNeglet);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.HobbyNeglet);

                }
            }
        });

        checkBoxComunicationLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableChecked);
                    symptoms.add(Symptoms.ComunicationLow);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.ComunicationLow);

                }
            }
        });

        checkBoxLifeProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableChecked);
                    symptoms.add(Symptoms.LifeProblem);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.LifeProblem);

                }
            }
        });

        checkBoxComunicationProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableChecked);
                    symptoms.add(Symptoms.ComunicationProblem);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableUnchecked);
                    symptoms.remove(Symptoms.ComunicationProblem);

                }
            }
        });
    }
}