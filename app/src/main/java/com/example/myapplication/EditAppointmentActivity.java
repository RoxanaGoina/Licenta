package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditAppointmentActivity extends AppCompatActivity {

    private Spinner categorySpinner, typeSpinner;
    private EditText dateEditText, addressEditText;
    private Button saveAppointmentButton;
    private String originalCategory, originalDate, originalType, originalAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointment);

        // Initialize views
        categorySpinner = findViewById(R.id.categorySpinnerModify);
        typeSpinner = findViewById(R.id.typeSpinnerModify);
        dateEditText = findViewById(R.id.dateEditTextModify);
        addressEditText = findViewById(R.id.addressEditTextModify);
        saveAppointmentButton = findViewById(R.id.editAppointmentButton);
        List<String> categories = new ArrayList<>();
        categories.add("Psiholog");
        categories.add("Psihiatru");
        categories.add("Psihoterapeut");
        List<String> types = new ArrayList<>();
        types.add("Online");
        types.add("Fizic");
        // Set spinners
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

        // Get appointment details from the Intent
        Intent intent = getIntent();
        originalCategory = intent.getStringExtra("category");
        originalDate = intent.getStringExtra("date");
        originalType = intent.getStringExtra("type");
        originalAddress = intent.getStringExtra("address");

        // Set the original details to the views
        categorySpinner.setSelection(getSpinnerIndex(categorySpinner, originalCategory));
        dateEditText.setText(originalDate);
        typeSpinner.setSelection(getSpinnerIndex(typeSpinner, originalType));
        addressEditText.setText(originalAddress);

        // Set up type spinner listener
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = parent.getItemAtPosition(position).toString();
                if (selectedType.equals("Online")) {
                    addressEditText.setText("");
                    addressEditText.setEnabled(false);
                } else {
                    addressEditText.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Date and time picker dialog
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker();
            }
        });

        saveAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAppointment();
            }
        });
    }

    private int getSpinnerIndex(Spinner spinner, String value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(value)) {
                return i;
            }
        }
        return 0;
    }

    private void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date = Calendar.getInstance();
        new DatePickerDialog(EditAppointmentActivity.this, (view, year, month, dayOfMonth) -> {
            date.set(year, month, dayOfMonth);
            new TimePickerDialog(EditAppointmentActivity.this, (view1, hourOfDay, minute) -> {
                date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                date.set(Calendar.MINUTE, minute);
                dateEditText.setText(android.text.format.DateFormat.format("dd.MM.yyyy HH:mm", date));
            }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), true).show();
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }

    private void updateAppointment() {
        final String newCategory = categorySpinner.getSelectedItem().toString();
        final String newDate = dateEditText.getText().toString();
        final String newType = typeSpinner.getSelectedItem().toString();
        final String newAddress = addressEditText.getText().toString();

        if (newType.equals("Fizic") && newAddress.isEmpty()) {

            Toast.makeText(this, "Adresa este obligatorie pentru programarea fizica", Toast.LENGTH_SHORT).show();
            return;
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
                    JSONArray newJsonArray = new JSONArray();
                    if (json != null) {
                        try {
                            JSONArray jsonArray = new JSONArray(json);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String category = jsonObject.getString("category");
                                String date = jsonObject.getString("date");
                                String type = jsonObject.getString("type");
                                String address = jsonObject.getString("adress");

                                if (originalCategory.equals(category) && originalDate.equals(date) &&
                                        originalType.equals(type) && originalAddress.equals(address)) {
                                    jsonObject.put("category", newCategory);
                                    jsonObject.put("date", newDate);
                                    jsonObject.put("type", newType);
                                    jsonObject.put("adress", newAddress);
                                }
                                newJsonArray.put(jsonObject);
                            }
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                                    .getReference()
                                    .child("username")
                                    .child(userId)
                                    .child("appointments");

                            databaseReference.setValue(newJsonArray.toString());
                            Toast.makeText(EditAppointmentActivity.this, "Programarea a fost actualizată cu succes!", Toast.LENGTH_SHORT).show();
                            finish(); // Close the activity
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Handle possible errors
                }
            });
        }
    }
}
