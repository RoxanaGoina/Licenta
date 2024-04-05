package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class TestsActivity extends AppCompatActivity {
    private Button phq_9;
    private Button gad_7;
    private Button score;

    private Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        phq_9 = findViewById(R.id.phq9);
        gad_7 = findViewById(R.id.gad7);
        score = findViewById(R.id.score);
        myDialog = new Dialog(this);
        findViewById(R.id.phq9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestsActivity.this, PhqActivity.class));
            }
        });

        findViewById(R.id.gad7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestsActivity.this, GadActivity.class));
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.pop);
                myDialog.show();
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {
                    String userEmail = firebaseUser.getEmail();
                    DatabaseReference usersRef = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("username");
                    Query query = usersRef.orderByChild("email").equalTo(userEmail);

                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int userPHQScore = userSnapshot.child("phqscore").getValue(int.class);
                                int userGADScore = userSnapshot.child("gadscore").getValue(int.class);


                                TextView textviewPHQ = myDialog.findViewById(R.id.phqScore);
                                TextView textviewGAD = myDialog.findViewById(R.id.gadScore);
                                textviewPHQ.setText("Scorul testului PHQ-9 este: " + String.valueOf(userPHQScore));
                                textviewGAD.setText("Scorul testului GAD-7 este: " + String.valueOf(userGADScore));

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
