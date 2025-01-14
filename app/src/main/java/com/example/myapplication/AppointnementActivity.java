package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.AddAppointmentsActivity;
import com.example.myapplication.Appointment;
import com.example.myapplication.R;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppointnementActivity extends AppCompatActivity {

    private Button addAppointment;
    private LinearLayout appointmentListView;

    private List<Appointment> appointmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointnement);

        addAppointment = findViewById(R.id.addAppointment);
        appointmentListView = findViewById(R.id.appoitnemetList);

        addAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppointnementActivity.this, AddAppointmentsActivity.class));
            }
        });



        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference()
                    .child("username")
                    .child(userId)
                    .child("appointments");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String json = dataSnapshot.getValue(String.class);
                    appointmentList = new ArrayList<>();
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
                            displayAppointments(appointmentList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
    }

    /**
     *
     * @param appointmentList - lista in care sunt stocate toate programarile unui utilizator
     * functia preia programarile efectuate de utilizator si le salveaza in baza de date adaugand data curenta; ulterior, apeleaza o alta functie ce permite vizualizarea acestora intr-un scroll view
     */
    private void displayAppointments(List<Appointment> appointmentList) {
        appointmentListView.removeAllViews();
        Date currentDate = new Date(); // Get the current date

        for (final Appointment appointment : appointmentList) {
            // Parse the appointment date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
            Date appointmentDate = null;
            try {
                appointmentDate = dateFormat.parse(appointment.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (appointmentDate != null && appointmentDate.after(currentDate)) {
                View appointmentView = getLayoutInflater().inflate(R.layout.appointment_item, null);

                TextView categoryTextView = appointmentView.findViewById(R.id.categoryTextView);
                TextView dateTextView = appointmentView.findViewById(R.id.dateTextView);
                TextView typeTextView = appointmentView.findViewById(R.id.typeTextView);
                TextView addressTextView = appointmentView.findViewById(R.id.addressTextView);

                // Set appointment data
                categoryTextView.setText(appointment.getCategory());
                dateTextView.setText(appointment.getDate());
                typeTextView.setText(appointment.getType());
                addressTextView.setText(appointment.getAdress());

                appointmentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editAppointment(appointment);
                    }
                });

                appointmentView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        showDeleteConfirmationDialog(appointment);
                        return true;
                    }
                });

                appointmentListView.addView(appointmentView);
            }
        }
    }

    /**
     *
     * @param appointment programarea efectuata de utilizator
     * functia este utilizata pentru a edita programarea pe care o primeste ca parametru al functie; totodata, se realizeaza redirectionarea de la activitatea principala la activitatea de editare
     */
    private void editAppointment(Appointment appointment) {
        Intent intent = new Intent(AppointnementActivity.this, EditAppointmentActivity.class);
        intent.putExtra("category", appointment.getCategory());
        intent.putExtra("date", appointment.getDate());
        intent.putExtra("type", appointment.getType());
        intent.putExtra("address", appointment.getAdress());
        startActivity(intent);
    }

    /**
     *
     * @param appointment un obiect de tip Appointment
     * functia primeste ca parametru un appointment si afiseaza un dialog de confirmare pentru stergerea appointmentului primit ca si parametru;
     * in cazul in care raspunsul este pozitiv, se apeleaza o alta functie care va sterge din baza de date appointmentul primit ca si parametru.
     */
    private void showDeleteConfirmationDialog(final Appointment appointment) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sigur vrei să ștergi această programare?")
                .setCancelable(false)
                .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deleteAppointment(appointment);
                    }
                })
                .setNegativeButton("Nu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     *
     * @param appointment - un obiect de tip Appointment
     * functia primeste ca parametru un obiect de tip appointment pe care il sterge din baza de date; concret, functia face o referinta asupra bazei de date; aduce lista de appointmenturi si din lista respectiva sterge appointmentul primit ca si parametru;
     * ulterior, se salveaza lista noua inapoi in baza de date
     */
    private void deleteAppointment(final Appointment appointment) {
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

                                if (!appointment.getCategory().equals(category) || !appointment.getDate().equals(date) ||
                                        !appointment.getType().equals(type) || !appointment.getAdress().equals(address)) {
                                    newJsonArray.put(jsonObject);
                                }
                            }
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                                    .getReference()
                                    .child("username")
                                    .child(userId)
                                    .child("appointments");

                            databaseReference.setValue(newJsonArray.toString());
                            appointmentList.remove(appointment);
                            displayAppointments(appointmentList);
                            Toast.makeText(AppointnementActivity.this, "Programarea a fost ștearsă cu succes!", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                }
            });
        }
    }




}

