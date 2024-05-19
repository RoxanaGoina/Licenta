package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
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

            // Calculate time difference
            long timeDifference = appointmentDate.getTime() - System.currentTimeMillis();
            long oneHourInMillis = 60 * 60 * 1000; // 1 hour in milliseconds

            // If time difference is less than or equal to 1 hour, show notification
            if (timeDifference <= oneHourInMillis && timeDifference > 0) {
                showNotification("Appointment Reminder", "You have an appointment in one hour.", this);
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

                // Set OnLongClickListener for appointment item
                appointmentView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        showDeleteConfirmationDialog(appointment);
                        return true;
                    }
                });

                // Add the appointment view to the LinearLayout
                appointmentListView.addView(appointmentView);
            }
        }
    }

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

    private void showNotification(String title, String message, Context context) {
        // Create a notification channel
        createNotificationChannel(context);

        // Create notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "appointment_channel")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Create an explicit intent for an activity in your app
        Intent intent = new Intent(context, AppointnementActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Show notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1001, builder.build());
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Appointment Channel";
            String description = "Channel for appointment notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("appointment_channel", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}

