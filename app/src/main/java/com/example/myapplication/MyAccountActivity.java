package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;
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

        //ArrayAdapter<CharSequence> adapterSpinnerYear = ArrayAdapter.createFromResource(this, R.array.years, R.layout.spinner_item);
        //adapterSpinnerYear.setDropDownViewResource(R.layout.spinner_item);
        //yearSpinner.setAdapter(adapterSpinnerYear);

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
    }
}