package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

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

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private CheckBox checkBoxAnxiety;
    private CheckBox checkBoxSuicideAttemp;
    private CheckBox chekBoxDepressionDiagnosis;

    private CheckBox checkBoxDepressionTreatment;
    private CheckBox checkBoxAnxietyDiagnosis;
    private CheckBox checkBoxAnxietyTreatment;

    private boolean anxietyChecked;
    private boolean suicideAttempChecked;
    private boolean depressionDiagnosisChecked;

    private boolean depressionTreatmentChecked;

    private boolean anxietyDiagnosisChecked;
    private boolean anxietyTreatmentChecked;

    private List<Float> data = new ArrayList<>();
    private final String DatabaseURL = "https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app";

    private Button showResult;

    public void loadData(DataSnapshot dataSnapshot) {
        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
            Integer schoolYear = userSnapshot.child("yearOfStudy").getValue(Integer.class);
            if (schoolYear != null) {
                data.add(Float.valueOf(schoolYear));
            }

            Integer age = userSnapshot.child("age").getValue(Integer.class);
            if (age != null)
                data.add(Float.valueOf(age));

            Float bmi = userSnapshot.child("imc").getValue(Float.class);
            if (bmi != null)
                data.add(bmi);
            Integer phqScore = userSnapshot.child("phqscore").getValue(Integer.class);
            if (phqScore != null)
                data.add(Float.valueOf(phqScore));
            Integer gadScore = userSnapshot.child("gadscore").getValue(Integer.class);
            if (gadScore != null)
                data.add(Float.valueOf(gadScore));


            boolean gender = userSnapshot.child("sex").getValue(boolean.class);
            Log.d("TAG gender", String.valueOf(gender));
            if (!gender) {
                data.add(Float.valueOf(1));
                data.add(Float.valueOf(0));

            } else {
                data.add(Float.valueOf(0));
                data.add(Float.valueOf(1));
            }
            Log.d("TAG LIST", data.toString());
//
//
//


        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        checkBoxAnxiety = findViewById(R.id.checkBoxAnxietyFeeling);
        checkBoxSuicideAttemp = findViewById(R.id.checkBoxSuicideAttemp);
        chekBoxDepressionDiagnosis = findViewById(R.id.checkBoxDepressionDiagnosis);
        checkBoxDepressionTreatment = findViewById(R.id.checkBoxDepressionTreatment);
        checkBoxAnxietyDiagnosis = findViewById(R.id.checkBoxAnxietyDiagnosis);
        checkBoxAnxietyTreatment = findViewById(R.id.checkBoxAnxietyTreatment);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance(DatabaseURL)
                .getReference()
                .child("username");
        String userEmail = firebaseUser.getEmail();
        DatabaseReference usersRef = FirebaseDatabase.getInstance(DatabaseURL).getReference().child("username");
        Query query = usersRef.orderByChild("email").equalTo(userEmail);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                loadData(dataSnapshot);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }


    public void addCheck() {
        suicideAttempChecked = checkChecked(checkBoxSuicideAttemp);
        if (!suicideAttempChecked) {
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));

        }
        depressionDiagnosisChecked=checkChecked(chekBoxDepressionDiagnosis);
        if(!depressionDiagnosisChecked){
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));

        }
        depressionTreatmentChecked=checkChecked(checkBoxDepressionTreatment);
        if(!depressionTreatmentChecked){
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));

        }
        anxietyChecked=checkChecked(checkBoxAnxiety);
        if(!anxietyChecked){
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));
        }

        anxietyDiagnosisChecked=checkChecked(checkBoxAnxietyDiagnosis);
        if(!anxietyDiagnosisChecked){
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));
        }
        anxietyTreatmentChecked=checkChecked(checkBoxAnxietyTreatment);
        if(!anxietyTreatmentChecked){
            data.add(Float.valueOf(1));
            data.add(Float.valueOf(0));
        } else {
            data.add(Float.valueOf(0));
            data.add(Float.valueOf(1));

        }






    }

    public boolean checkChecked(CheckBox checkbox) {
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    checkbox.setChecked(true);
                else
                    checkbox.setChecked(false);
            }
        });
        return false;
    }


}