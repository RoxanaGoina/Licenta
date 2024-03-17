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
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSadness.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxLowSelfEsteem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxGuilty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableUnchecked);
                }

            }
        });
        checkBoxFear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxConfusion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxHopeless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxAgitation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxLackOfMotivation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableUnchecked);
                }
            }
        });
        checkBoxIrritability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxCrying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxLowEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxNervousness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxSelfHarming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableUnchecked);
                }

            }
        });
        checkBoxHelpless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxConcentrateProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableUnchecked);
                }
            }
        });


        checkboxWeightFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableUnchecked);
                }
            }
        });


        checkboxLackOfEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableUnchecked);
                }
            }
        });


        checkboxInsomnia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableUnchecked);
                }
            }
        });

        checkboxMusclePain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableUnchecked);
                }
            }
        });

        checkboxLowSexDrive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableUnchecked);
                }
            }
        });

        checkboxSleepiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableUnchecked);
                }
            }
        });

        checkboxAppetiteFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxIsolation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableUnchecked);
                }
            }
        });
        checkBoxHobbyNeglet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxComunicationLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxLifeProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableUnchecked);
                }
            }
        });

        checkBoxComunicationProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableUnchecked);
                }
            }
        });
    }
}