package com.example.myapplication;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultActivity";

    private CheckBox checkBoxAnxiety;
    private CheckBox checkBoxSuicideAttemp;
    private CheckBox chekBoxDepressionDiagnosis;
    private CheckBox checkBoxDepressionTreatment;
    private CheckBox checkBoxAnxietyDiagnosis;
    private CheckBox checkBoxAnxietyTreatment;
    private TextView resultTextView;

    private boolean anxietyChecked;
    private boolean suicideAttempChecked;
    private boolean depressionDiagnosisChecked;
    private boolean depressionTreatmentChecked;
    private boolean anxietyDiagnosisChecked;
    private boolean anxietyTreatmentChecked;

    private List<Float> data = new ArrayList<>();
    private final String serverUrl = "http://192.168.1.103:5000/predict"; // Adresa IP a serverului Flask

    private Button showResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        checkBoxAnxiety = findViewById(R.id.checkBoxAnxietyFeeling);
        checkBoxSuicideAttemp = findViewById(R.id.checkBoxSuicideAttemp);
        chekBoxDepressionDiagnosis = findViewById(R.id.checkBoxDepressionDiagnosis);
        checkBoxDepressionTreatment = findViewById(R.id.checkBoxDepressionTreatment);
        checkBoxAnxietyDiagnosis = findViewById(R.id.checkBoxAnxietyDiagnosis);
        checkBoxAnxietyTreatment = findViewById(R.id.checkBoxAnxietyTreatment);
        showResult = findViewById(R.id.showResult);
        //resultTextView = findViewById(R.id.resultTextView);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userEmail = firebaseUser.getEmail();
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("username");
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
                addCheck();
                sendPostRequest();
            }
        });
        showResult.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(ResultActivity.this, "Rezultat diagnostic : Pozitiv", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ResultActivity.this, MainMenu.class));

                    }
                }, 500); // Delay de 500 milisecunde
            }
        });
    }

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
            Log.d(TAG, "Gender: " + gender);
            if (!gender) {
                data.add(1f);
                data.add(0f);
            } else {
                data.add(0f);
                data.add(1f);
            }
            Log.d(TAG, "Data: " + data.toString());
        }
    }

    public void addCheck() {
        suicideAttempChecked = checkChecked(checkBoxSuicideAttemp);
        if (!suicideAttempChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }

        depressionDiagnosisChecked = checkChecked(chekBoxDepressionDiagnosis);
        if (!depressionDiagnosisChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }

        depressionTreatmentChecked = checkChecked(checkBoxDepressionTreatment);
        if (!depressionTreatmentChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }

        anxietyChecked = checkChecked(checkBoxAnxiety);
        if (!anxietyChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }

        anxietyDiagnosisChecked = checkChecked(checkBoxAnxietyDiagnosis);
        if (!anxietyDiagnosisChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }

        anxietyTreatmentChecked = checkChecked(checkBoxAnxietyTreatment);
        if (!anxietyTreatmentChecked) {
            data.add(1f);
            data.add(0f);
        } else {
            data.add(0f);
            data.add(1f);
        }
    }

    public boolean checkChecked(CheckBox checkbox) {
        return checkbox.isChecked();
    }

    public void sendPostRequest() {
        new SendPostRequest().execute();
    }

    private class SendPostRequest extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                JSONObject postDataParams = new JSONObject();
                JSONArray dataJsonArray = new JSONArray(data);
                postDataParams.put("data", dataJsonArray);

                URL url = new URL(serverUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                os.write(postDataParams.toString().getBytes());
                os.flush();
                os.close();

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }
                    in.close();
                    return sb.toString();
                } else {
                    return "Error: " + responseCode;
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
        }

//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            Log.d(TAG, "Response: " + result);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        JSONArray jsonArray = new JSONArray(result);
//                        int prediction = jsonArray.getInt(0);
//                        Log.d(TAG, "Prediction: " + prediction);
//                        if (prediction == 1) {
//                            Toast.makeText(ResultActivity.this, "Depression", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(ResultActivity.this, "NOT Depression", Toast.LENGTH_LONG).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        Toast.makeText(ResultActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//        }
protected void onPostExecute(String result) {
    super.onPostExecute(result);
    Log.d(TAG, "Response: " + result);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            try {
                int prediction = Integer.parseInt(result);
                Log.d(TAG, "Prediction: " + prediction);
                if (prediction == 1) {
                            Toast.makeText(ResultActivity.this, "Depression", Toast.LENGTH_LONG).show();
                } else {
                            Toast.makeText(ResultActivity.this, "NOT Depression", Toast.LENGTH_LONG).show();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(ResultActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}
    }
}
