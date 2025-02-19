package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainMenu extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    private ImageView imageView;
    private Button anxietyButton;

    private FirebaseAuth firebaseAuth;
    private boolean isAnimating = false;
    private Animation scaleUpAnimation;
    private Animation scaleDownAnimation;
    private TextView wellBeingText;
    private Handler handler = new Handler();
    private Random random = new Random();

    private List<Appointment> appointmentList = new ArrayList<>();
    private  boolean isNotificationShown=false;
    private List<Integer> heartRateData= new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        anxietyButton = findViewById(R.id.anxietyButton);
        wellBeingText = findViewById(R.id.wellBeingchecked);
        int backgroundColor = ContextCompat.getColor(this, R.color.white);
        int colorBlack = ContextCompat.getColor(this, R.color.black);
        firebaseAuth = FirebaseAuth.getInstance();
        HeartRateView heartRateView = findViewById(R.id.heartRateView);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        imageView = findViewById(R.id.imageMenu);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference()
                    .child("heartBeat")
                    .child(userId)
                    .child("values");

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loadHeartBeat(dataSnapshot);
                    Log.d("heartBeats", heartRateData.toString());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (currentIndex < heartRateData.size()) {
                                int newValue = heartRateData.get(currentIndex);
                                heartRateView.addValue(newValue);
                                currentIndex++;
                                handler.postDelayed(this, 100);
                            } else {
                                // Reset the index to loop through the data again
                                currentIndex = 0;
                                handler.postDelayed(this, 100);
                            }
                        }
                    }, 100);

                }
                @Override
                public void onCancelled(DatabaseError error) {
                    System.err.println("Error fetching data: " + error.getMessage());
                }
            });
        }
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setBackgroundColor(backgroundColor);


        navigationView.setItemIconTintList(ColorStateList.valueOf(colorBlack));
        menu();

        scaleUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaledowntransition);
        scaleDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaleuptransition);

        anxietyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnimating) {
                    anxietyButton.clearAnimation();
                    isAnimating = false;
                } else {
                    anxietyButton.startAnimation(scaleUpAnimation);
                    isAnimating = true;
                    wellBeingText.setText("Inspira");
                }
            }
        });

        scaleUpAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isAnimating) {
                    anxietyButton.startAnimation(scaleDownAnimation);
                    wellBeingText.setText("Expira");
                } else {
                    wellBeingText.setText("Cum te simti azi?");
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

// Listener pentru animația de micșorare
        scaleDownAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if (isAnimating) {
                    anxietyButton.startAnimation(scaleUpAnimation);
                    wellBeingText.setText("Inspira");
                } else {
                    wellBeingText.setText("Cum te simti azi?");
                }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else
            super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference()
                    .child("username")
                    .child(userId)
                    .child("appointments");

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                Date currentDate = new Date(); // Data curenta

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loadJson(dataSnapshot);
                    try {
                        processAppointments(appointmentList);

                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                }
                @Override
                public void onCancelled(DatabaseError error) {
                    System.err.println("Error fetching data: " + error.getMessage());
                }
            });
        }




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null); // Remove callbacks when the activity is destroyed
    }



    /**
     * functia procesează o lista de programări pentru a verifica dacă trebuie să se afișeze o notificare pentru o programare curentă.
     * verifica data si ora curenta comparandu-le cu fiecare programare din lista data. Dacă data programarii coincide cu data curenta
     * si notificarea nu a fost incă afisata, se va afișa o notificare.
     *
     * @param appointmentList lista de obiecte Appointment ce conține toate programarile de verificat.
     */

    private void processAppointments(List<Appointment> appointmentList) throws  ParseException {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        Date currentDate = new Date(); // Current date and time
        String currentDateString = dateFormat.format(currentDate);
        Date currentDateTime = dateTimeFormat.parse(dateTimeFormat.format(currentDate));

        for (final Appointment appointment : appointmentList) {
            // Parse the appointment date and time
            Date appointmentDate = dateTimeFormat.parse(appointment.getDate());

            String appointmentDateString = dateFormat.format(appointmentDate);

            if (appointmentDateString.equals(currentDateString) && !isNotificationShown) {
                if (appointmentDate.after(currentDateTime)) {
                    // Display the notification
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        NotificationChannel channel = new NotificationChannel("notification", "notification", NotificationManager.IMPORTANCE_HIGH);
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        manager.createNotificationChannel(channel);
                        final int NOTIFICATION_ID = 1;
                        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification, null);
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                        Bitmap largeIcon = bitmapDrawable.getBitmap();
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification notification = new Notification.Builder(MainMenu.this)
                                .setLargeIcon(largeIcon)
                                .setSmallIcon(R.drawable.notification)
                                .setContentText(" Informatii necesare: " + appointment.getType() + "  " + appointment.getAdress() + " " + appointment.getDate())
                                .setContentTitle("Programare la " + appointment.getCategory())
                                .setChannelId("My Channel")
                                .build();
                        manager.createNotificationChannel(new NotificationChannel("My Channel", "New Channel", NotificationManager.IMPORTANCE_HIGH));
                        nm.notify(NOTIFICATION_ID, notification);
                    }
                    isNotificationShown = true;
                }
            }
        }

    }
    /**
     * seteaza funcționalitatea pentru meniul de navigație.
     * meniul contine optiuni pentru navigarea în diverse activitati ale aplicatiei.
     * ofera funcționalitatea de a deschide activitati specifice in functie de elementul selectat din meniu.

     */

    private void menu() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                if (item.getItemId() == R.id.account) {
                    //  Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, MyAccountActivity.class));
                }
                if (item.getItemId() == R.id.tests) {
                    //Toast.makeText(MainMenu.this, "Test" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, TestsActivity.class));

                }
                if (item.getItemId() == R.id.diary) {
                    startActivity(new Intent(MainMenu.this, Diary_Activity.class));

                }
                if (item.getItemId() == R.id.report) {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, ReportActivity.class));

                }
                if (item.getItemId() == R.id.historic) {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, HistoricActivity.class));

                }
//                if (item.getItemId()==R.id.news)
//                {
//                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainMenu.this, NewsActivity.class));
//
//                }
                if (item.getItemId() == R.id.result) {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, ResultActivity.class));

                }

                if (item.getItemId() == R.id.appoitnemet) {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, AppointnementActivity.class));

                }
                if (item.getItemId() == R.id.logout) {
                    firebaseAuth.signOut();
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(MainMenu.this, LoginActivity.class));


                }
                return false;
            }
        });


    }
//    public void fetchAppointments() {
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
//                .getReference()
//                .child("appointments");
//
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                appointmentList.clear(); // Clear the list before adding new data
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Appointment appointment = snapshot.getValue(Appointment.class);
//                    appointmentList.add(appointment);
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                System.err.println("Error fetching data: " + error.getMessage());
//            }
//        });
//    }

    /**
     * incarca datele despre programari dintr-un obiect DataSnapshot al Firebase intr-o lista de obiecte Appointment.
     *
     * @param dataSnapshot Obiectul DataSnapshot care conține datele JSON despre programari.
     */
    private void loadJson(DataSnapshot dataSnapshot) {
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * functia incarca datele despre puls dintr-un obiect DataSnapshot al Firebase intr-o lista de valori.
     *
     * @param dataSnapshot obiectul DataSnapshot care conține datele JSON despre puls.
     */
    private void loadHeartBeat(DataSnapshot dataSnapshot){
        String json = dataSnapshot.getValue(String.class);

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Integer value = jsonObject.getInt("value");
                    heartRateData.add(value);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}





