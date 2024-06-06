package com.example.myapplication;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyAccountActivity extends AppCompatActivity {
    private Spinner spinner;
    private Calendar calendar;

    private EditText dp1;

    private EditText name;

    private EditText CNP;

    private EditText height;

    private EditText weight;

    private EditText IMC;


    private Spinner yearSpinner;

    private Button saveButton;

    private TextView changePasswordRedirectText;
    private EditText email;

    private final String DatabaseURL="https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_account);
        spinner = (Spinner) findViewById(R.id.spinner);
        yearSpinner = (Spinner) findViewById(R.id.spinnerYear);
        dp1 = findViewById(R.id.dp);
        name = findViewById(R.id.name);
        CNP = findViewById(R.id.cnp);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        IMC = findViewById(R.id.imc);
        saveButton = findViewById(R.id.save_button);
        changePasswordRedirectText = findViewById(R.id.changePasswordRedirectText);

        spinnerSets();
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.spinner_item);
//        adapter.setDropDownViewResource(R.layout.spinner_item);
//        spinner.setAdapter(adapter);
//
//        final boolean[] isSpinnerFirstSelection = {true};
//        final boolean[] isSpinnerFirstSelectionSecondSpinner = {true};
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                if (isSpinnerFirstSelection[0]) {
//                    isSpinnerFirstSelection[0] = false;
//                } else {
//                    TextView selectedTextView = (TextView) selectedItemView;
//                    selectedTextView.setTextColor(getResources().getColor(R.color.blue));
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//
//            }
//        });
//
//
//        ArrayAdapter<CharSequence> adapterSpinnerYear = ArrayAdapter.createFromResource(this, R.array.years, R.layout.spinner_for_years);
//        adapterSpinnerYear.setDropDownViewResource(R.layout.spinner_for_years);
//        yearSpinner.setAdapter(adapterSpinnerYear);
//
//        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                if (isSpinnerFirstSelectionSecondSpinner[0]) {
//                    isSpinnerFirstSelectionSecondSpinner[0] = false;
//                } else {
//                    TextView selectedTextView = parentView.getChildAt(0).findViewById(android.R.id.text2);
//                    selectedTextView.setTextColor(getResources().getColor(R.color.blue));
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//
//            }
//        });

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateCalendar();
            }

            private void updateCalendar() {
                String Format = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                dp1.setText(sdf.format(calendar.getTime()));


            }
        };
        dp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MyAccountActivity.this,
                        date,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                datePickerDialog.show();

            }
        });


        FirebaseUser firebaseUseruser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUseruser != null) {
            String userEmail = firebaseUseruser.getEmail();
            DatabaseReference usersRef = FirebaseDatabase.getInstance(DatabaseURL).getReference().child("username");
            Query query = usersRef.orderByChild("email").equalTo(userEmail);
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loadDatabaseContent(dataSnapshot);

//                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
//                        String username = userSnapshot.child("name").getValue(String.class);
//                        name.setText(username);
//                        String CNPDB = userSnapshot.child("cnp").getValue(String.class);
//                        CNP.setText(CNPDB);
//                        boolean sex = userSnapshot.child("sex").getValue(boolean.class);
//                        int position = sex ? 1 : 0;
//                        spinner.setSelection(position);
//                        if (sex) {
//                            spinner.setSelection(0);
//                        } else {
//                            spinner.setSelection(1);
//                        }
//                        String dateOfBirth = userSnapshot.child("dateOfBirth").getValue(String.class);
//
//                        dp1.setText(dateOfBirth);
//                        double userHeight = userSnapshot.child("height").getValue(double.class);
//                        height.setText(String.valueOf(userHeight));
//                        double userWeight = userSnapshot.child("weight").getValue(double.class);
//                        weight.setText(String.valueOf(userWeight));
//                        double imcUser = userSnapshot.child("imc").getValue(double.class);
//                        IMC.setText(String.valueOf(imcUser));
//                        int yearOfStudy = userSnapshot.child("yearOfStudy").getValue(int.class);
//                        String[] yearsArray = getResources().getStringArray(R.array.years);
//                        int pozitie = -1;
//                        for (int i = 0; i < yearsArray.length; i++) {
//                            if (Integer.parseInt(yearsArray[i]) == yearOfStudy) {
//                                pozitie = i;
//                                break;
//                            }
//                        }
//
//
//                        if (pozitie != -1) {
//                            yearSpinner.setSelection(pozitie);
//                        }
//
//                        int PHQScore = userSnapshot.child("phqscore").getValue(int.class);
//                        int GADScore = userSnapshot.child("gadscore").getValue(int.class);
//                        String userName = username;
//
//                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle database errors
                }
            });


        }


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveIntoDatabase();

                }



        });

        changePasswordRedirectText.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                startActivity(new Intent(MyAccountActivity.this,changePasswordLoginActivity.class));
            }

            private void ResetPassword(String userEmail) {

                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.sendPasswordResetEmail(userEmail)

                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MyAccountActivity.this, "Reset Password link has been sent to your registered Email", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MyAccountActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MyAccountActivity.this, "Error :- " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void saveIntoDatabase(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            DatabaseReference database = FirebaseDatabase.getInstance(DatabaseURL).getReference();
            String userEmail = user.getEmail();
            String text = name.getText().toString();
            String cnp = CNP.getText().toString();
            String gender = spinner.getSelectedItem().toString();
            String DOB = dp1.getText().toString();
            String userHeight = height.getText().toString();
            String userWeight = weight.getText().toString();
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.');
            DecimalFormat df = new DecimalFormat("#.##", symbols);
            String year = yearSpinner.getSelectedItem().toString();
            double imc = Double.parseDouble(userWeight) / (Math.pow(Double.parseDouble(userHeight) / 100, 2));
            String imcFormatted = df.format(imc);
            double imcFromFormatted = Double.parseDouble(imcFormatted);
            LocalDate today = LocalDate.now();
            LocalDate birthDate = parseDate(DOB);
            Period period = Period.between(birthDate, today);
            int age = period.getYears();
            if(checks(cnp,text)) {
                startActivity(new Intent(MyAccountActivity.this, MainMenu.class));
                if (gender.equals("Feminin"))
                    database.child("username").child(userId).child("sex").setValue(false);
                else
                    database.child("username").child(userId).child("sex").setValue(true);

                database.child("username").child(userId).child("name").setValue(text);
                database.child("username").child(userId).child("cnp").setValue(cnp);
                database.child("username").child(userId).child("dateOfBirth").setValue(DOB);
                database.child("username").child(userId).child("height").setValue(Double.parseDouble(userHeight));
                database.child("username").child(userId).child("weight").setValue(Double.parseDouble(userWeight));
                database.child("username").child(userId).child("imc").setValue(imcFromFormatted);
                database.child("username").child(userId).child("yearOfStudy").setValue(Integer.parseInt(year));
                database.child("username").child(userId).child("age").setValue(age);

            }
            else{
                Toast.makeText(MyAccountActivity.this, "Introdu date valide", Toast.LENGTH_SHORT).show();

            }

        }

    }

    private void loadDatabaseContent(DataSnapshot dataSnapshot){
        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
            String username = userSnapshot.child("name").getValue(String.class);
            name.setText(username);
            String CNPDB = userSnapshot.child("cnp").getValue(String.class);
            CNP.setText(CNPDB);
            boolean sex = userSnapshot.child("sex").getValue(boolean.class);
            int position = sex ? 1 : 0;
            spinner.setSelection(position);
            if (sex) {
                spinner.setSelection(0);
            } else {
                spinner.setSelection(1);
            }
            String dateOfBirth = userSnapshot.child("dateOfBirth").getValue(String.class);
            dp1.setText(dateOfBirth);
            double userHeight = userSnapshot.child("height").getValue(double.class);
            height.setText(String.valueOf(userHeight));
            double userWeight = userSnapshot.child("weight").getValue(double.class);
            weight.setText(String.valueOf(userWeight));
            double imcUser = userSnapshot.child("imc").getValue(double.class);
            IMC.setText(String.valueOf(imcUser));
            int yearOfStudy = userSnapshot.child("yearOfStudy").getValue(int.class);
            String[] yearsArray = getResources().getStringArray(R.array.years);
            int pozitie = -1;
            for (int i = 0; i < yearsArray.length; i++) {
                if (Integer.parseInt(yearsArray[i]) == yearOfStudy) {
                    pozitie = i;
                    break;
                }
            }
            if (pozitie != -1) {
                yearSpinner.setSelection(pozitie);
            }
            int PHQScore = userSnapshot.child("phqscore").getValue(int.class);
            int GADScore = userSnapshot.child("gadscore").getValue(int.class);
            String userName = username;
        }
    }
    public static LocalDate parseDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid date format", dateStr, 0);
        }
    }
    public boolean checks(String CNP,String name){
        String containsDigit= StringUtils.getDigits(name);
        if(CNP.length()==13 && containsDigit.isEmpty() && containsDigit!=null)
            return true;
        return false;
    }
    public void spinnerSets(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        final boolean[] isSpinnerFirstSelection = {true};
        final boolean[] isSpinnerFirstSelectionSecondSpinner = {true};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (isSpinnerFirstSelection[0]) {
                    isSpinnerFirstSelection[0] = false;
                } else {
                    TextView selectedTextView = (TextView) selectedItemView;
                    selectedTextView.setTextColor(getResources().getColor(R.color.blue));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });


        ArrayAdapter<CharSequence> adapterSpinnerYear = ArrayAdapter.createFromResource(this, R.array.years, R.layout.spinner_for_years);
        adapterSpinnerYear.setDropDownViewResource(R.layout.spinner_for_years);
        yearSpinner.setAdapter(adapterSpinnerYear);

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (isSpinnerFirstSelectionSecondSpinner[0]) {
                    isSpinnerFirstSelectionSecondSpinner[0] = false;
                } else {
                    TextView selectedTextView = parentView.getChildAt(0).findViewById(android.R.id.text2);
                    selectedTextView.setTextColor(getResources().getColor(R.color.blue));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

    }
}