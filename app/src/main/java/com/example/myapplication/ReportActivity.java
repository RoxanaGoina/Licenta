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


    private List<String> symptoms;





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
                       symptoms.add(checkBoxSadness.getText().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSadness.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxSadness.getText().toString());
                }
            }
        });

        checkBoxLowSelfEsteem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableChecked);
                    symptoms.add(checkBoxLowSelfEsteem.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowSelfEsteem.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxLowSelfEsteem.getText().toString());
                }
            }
        });

        checkBoxGuilty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableChecked);
                    symptoms.add(checkBoxGuilty.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxGuilty.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxGuilty.getText().toString());

                }

            }
        });
        checkBoxFear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableChecked);
                    symptoms.add(checkBoxFear.getText().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxFear.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxFear.getText().toString());
                }
            }
        });

        checkBoxConfusion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableChecked);
                    symptoms.add(checkBoxConfusion.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConfusion.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxConfusion.getText().toString());

                }
            }
        });

        checkBoxHopeless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableChecked);
                    symptoms.add(checkBoxHopeless.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHopeless.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxHopeless.getText().toString());
                }
            }
        });

        checkBoxAgitation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableChecked);
                    symptoms.add(checkBoxAgitation.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxAgitation.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxAgitation.getText().toString());
                }
            }
        });

        checkBoxLackOfMotivation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableChecked);
                    symptoms.add(checkBoxLackOfMotivation.getText().toString());


                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLackOfMotivation.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxLackOfMotivation.getText().toString());

                }
            }
        });
        checkBoxIrritability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableChecked);
                    symptoms.add(checkBoxIrritability.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIrritability.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxIrritability.getText().toString());
                }
            }
        });

        checkBoxCrying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableChecked);
                    symptoms.add(checkBoxCrying.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxCrying.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxCrying.getText().toString());

                }
            }
        });

        checkBoxLowEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableChecked);
                    symptoms.add(checkBoxLowEnergy.getText().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLowEnergy.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxLowEnergy.getText().toString());

                }
            }
        });

        checkBoxNervousness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableChecked);
                    symptoms.add(checkBoxNervousness.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxNervousness.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxNervousness.getText().toString());

                }
            }
        });

        checkBoxSelfHarming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableChecked);
                    symptoms.add(checkBoxSelfHarming.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxSelfHarming.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxSelfHarming.getText().toString());

                }

            }
        });
        checkBoxHelpless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableChecked);
                    symptoms.add(checkBoxHelpless.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHelpless.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxHelpless.getText().toString());

                }
            }
        });

        checkBoxConcentrateProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableChecked);
                    symptoms.add(checkBoxConcentrateProblem.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxConcentrateProblem.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxConcentrateProblem.getText().toString());
                }
            }
        });


        checkboxWeightFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableChecked);
                    symptoms.add(checkboxWeightFluctuations.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxWeightFluctuations.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxWeightFluctuations.getText().toString());

                }
            }
        });


        checkboxLackOfEnergy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableChecked);
                    symptoms.add(checkboxLackOfEnergy.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLackOfEnergy.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxLackOfEnergy.getText().toString());

                }
            }
        });


        checkboxInsomnia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableChecked);
                    symptoms.add(checkboxInsomnia.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxInsomnia.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxInsomnia.getText().toString());
                }
            }
        });

        checkboxMusclePain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableChecked);
                    symptoms.add(checkboxMusclePain.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxMusclePain.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxMusclePain.getText().toString());

                }
            }
        });

        checkboxLowSexDrive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableChecked);
                    symptoms.add(checkboxLowSexDrive.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxLowSexDrive.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxLowSexDrive.getText().toString());

                }
            }
        });

        checkboxSleepiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableChecked);
                    symptoms.add(checkboxSleepiness.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxSleepiness.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxSleepiness.getText().toString());

                }
            }
        });

        checkboxAppetiteFluctuations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableChecked);
                    symptoms.add(checkboxAppetiteFluctuations.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkboxAppetiteFluctuations.setBackground(drawableUnchecked);
                    symptoms.remove(checkboxAppetiteFluctuations.getText().toString());


                }
            }
        });

        checkBoxIsolation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableChecked);
                    symptoms.add(checkBoxIsolation.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxIsolation.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxIsolation.getText().toString());

                }
            }
        });
        checkBoxHobbyNeglet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableChecked);
                    symptoms.add(checkBoxHobbyNeglet.getText().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxHobbyNeglet.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxHobbyNeglet.getText().toString());

                }
            }
        });

        checkBoxComunicationLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableChecked);
                    symptoms.add(checkBoxComunicationLow.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationLow.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxComunicationLow.getText().toString());

                }
            }
        });

        checkBoxLifeProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableChecked);
                    symptoms.add(checkBoxLifeProblem.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxLifeProblem.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxLifeProblem.getText().toString());

                }
            }
        });

        checkBoxComunicationProblem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableChecked);
                    symptoms.add(checkBoxComunicationProblem.getText().toString());

                }
                else {
                    Toast.makeText(getApplicationContext(),"Unchecked",Toast.LENGTH_SHORT).show();
                    checkBoxComunicationProblem.setBackground(drawableUnchecked);
                    symptoms.remove(checkBoxComunicationProblem.getText().toString());

                }
            }
        });
    }
}