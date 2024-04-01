package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.Editable;
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

import java.lang.reflect.Type;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_account);
        spinner=(Spinner)findViewById(R.id.spinner);
        yearSpinner=(Spinner)findViewById(R.id.spinnerYear);
        dp1=findViewById(R.id.dp);
        name=findViewById(R.id.name);
        CNP=findViewById(R.id.cnp);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        IMC=findViewById(R.id.imc);
        saveButton=findViewById(R.id.save_button);
        changePasswordRedirectText=findViewById(R.id.changePasswordRedirectText);


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

        Calendar calendar=Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);
                updateCalendar();
            }
            private void updateCalendar(){
                String Format="dd/MM/yy";
                SimpleDateFormat sdf= new SimpleDateFormat(Format,Locale.US);
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
            DatabaseReference usersRef = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("username");
            Query query = usersRef.orderByChild("email").equalTo(userEmail);

            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        String username = userSnapshot.child("name").getValue(String.class);
                        Toast.makeText(MyAccountActivity.this,username,Toast.LENGTH_SHORT).show();
                        name.setText(username);
                        String email= userSnapshot.child("email").getValue(String.class);
                        Toast.makeText(MyAccountActivity.this,email,Toast.LENGTH_SHORT).show();
                        String CNPDB=userSnapshot.child("cnp").getValue(String.class);
                        boolean sex = userSnapshot.child("sex").getValue(boolean.class);
                        String dateOfBirth=userSnapshot.child("dateOfBirth").getValue(String.class);
                        double height=userSnapshot.child("height").getValue(double.class);
                        double weight=userSnapshot.child("weight").getValue(double.class);
                        double IMC=userSnapshot.child("imc").getValue(double.class);
                        int yearOfStudy=userSnapshot.child("yearOfStudy").getValue(int.class);
                        int PHQScore=userSnapshot.child("phqscore").getValue(int.class);
                        int GADScore=userSnapshot.child("gadscore").getValue(int.class);
                        String userName=username;
                        //name.setText(userName);

                        name.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });


                    }

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



                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    String userId = user.getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference();
                    String userEmail = user.getEmail();
                    String text=name.getText().toString();
                    database.child("username").child(userId).child("name").setValue(text);
                }


                startActivity(new Intent(MyAccountActivity.this,MainMenu.class));
            }
        });


    }
}