package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddAppointmentsActivity extends AppCompatActivity {
    private Spinner categorySpinner, typeSpinner;
    private EditText dateEditText, addressEditText;
    private Button saveAppointmentButton;
    private Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointments);
        categorySpinner = findViewById(R.id.categorySpinner);
        typeSpinner = findViewById(R.id.typeSpinner);
        dateEditText = findViewById(R.id.dateEditText);
        addressEditText = findViewById(R.id.addressEditText);
        saveAppointmentButton = findViewById(R.id.saveAppointmentButton);
        List<String> categories = new ArrayList<>();
        categories.add("Psiholog");
        categories.add("Psihiatru");
        categories.add("Psihoterapeut");
        List<String> types = new ArrayList<>();
        types.add("Online");
        types.add("Fizic");
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        typeSpinner.setAdapter(typeAdapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, R.layout.spinner_to_look_nice);
        adapter.setDropDownViewResource(R.layout.spinner_app);
        categorySpinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapterForTypes = ArrayAdapter.createFromResource(this, R.array.type_array, R.layout.spinner_to_look_nice);
        adapter.setDropDownViewResource(R.layout.spinner_app);
        typeSpinner.setAdapter(adapterForTypes);

        calendar = Calendar.getInstance();

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker();
            }
        });

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectType = typeSpinner.getSelectedItem().toString();
                if (selectType.equals("Online")) {   // realizeaza validarile de rigoare ; in cazul in care o programare e online, adresa acesteia e goala si nemodificabila
                    addressEditText.setFocusable(false);
                    addressEditText.setClickable(false);
                    addressEditText.setFocusableInTouchMode(false);
                    addressEditText.setText("");
                } else {
                    addressEditText.setFocusable(true);
                    addressEditText.setClickable(true);
                    addressEditText.setFocusableInTouchMode(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });


        saveAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAppointment();
                String selectedCategory = categorySpinner.getSelectedItem().toString();
                String selectType = typeSpinner.getSelectedItem().toString();
                String dateAndHour = dateEditText.getText().toString();
                String address = addressEditText.getText().toString();
                Log.d("AddAppointmentsActivity", "selectedCategory: " + selectedCategory);
                Log.d("AddAppointmentsActivity", "selectType: " + selectType);
                Log.d("AddAppointmentsActivity", "dateAndHour: " + dateAndHour);
                Log.d("AddAppointmentsActivity", "address: " + address);
                startActivity(new Intent(AddAppointmentsActivity.this, AppointnementActivity.class));
            }



        });

    }

    /**
     * functia e utilizata pentru a realiza salvarea unei programari in baza de date
     * in mod concret, se adauga o programare noua in lista de programari deja existenta, se converteste in JSON si se salveaza in baza de date
     */

    private void saveAppointment() {
        String selectedCategory = categorySpinner.getSelectedItem().toString();
        String selectType = typeSpinner.getSelectedItem().toString();
        String dateAndHour = dateEditText.getText().toString();
        String address = addressEditText.getText().toString();

        // Verificare dacă toate câmpurile sunt completate
        if (selectedCategory.isEmpty() || selectType.isEmpty() || dateAndHour.isEmpty() ||
                (selectType.equals("Fizic") && address.isEmpty())) {
            Toast.makeText(this, "Te rog completează toate câmpurile", Toast.LENGTH_SHORT).show();
            return; // Întrerupe funcția înainte de a salva programarea
        }

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference()
                    .child("username")
                    .child(userId)
                    .child("appointments");
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String json = dataSnapshot.getValue(String.class);
                    List<Appointment> appointmentList = new ArrayList<>();
                    if (json != null) {
                        try {
                            JSONArray jsonArray = new JSONArray(json);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String category = jsonObject.getString("category");
                                String date = jsonObject.getString("date");
                                String type = jsonObject.getString("type");
                                String address = jsonObject.getString("adress");
                                Appointment appointment = new Appointment(category, date, type, address);
                                appointmentList.add(appointment);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    Appointment appointment = new Appointment(selectedCategory, dateAndHour, selectType, address);
                    appointmentList.add(appointment);

                    // Convertirea listei de programări în JSON
                    JSONArray updatedJsonArray = new JSONArray();
                    for (Appointment appointmentObject : appointmentList) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("category", appointmentObject.getCategory());
                            jsonObject.put("date", appointmentObject.getDate());
                            jsonObject.put("type", appointmentObject.getType());
                            jsonObject.put("adress", appointmentObject.getAdress());
                            updatedJsonArray.put(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    String updatedJson = updatedJsonArray.toString();
                    databaseReference.setValue(updatedJson);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Tratarea erorii
                }
            });
        }
    }

    /**
     * functia este utilizata pentru a afisa data calendaristica, se utilizeaza un obiect de tipul DatePickerDialog
     */
    private void showDateTimePicker() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        showTimePicker();
                    }
                }, year, month, day);

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    /**
     * functia este utilizata pentru a afisa ora în cadrul unui datePickerDialog; pentru acest lucru se utilizeaza un TimePickerDialog
     */
    private void showTimePicker() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        updateDateTime();
                    }
                }, hour, minute, true);

        timePickerDialog.show();
    }

    /**
     * functia e utilizata pentru formatarea unei date calendaristice
     */
    private void updateDateTime() {
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        dateEditText.setText(dateTimeFormat.format(calendar.getTime()));

    }


}