package com.example.myapplication;

import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DiaryFilesActivity extends AppCompatActivity {

    private List<DiaryPage> journal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_files);

        Button saveNote = findViewById(R.id.saveNotes);
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                saveNote();
            }
        });

    }

    public void saveNote() {
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText contentEditText = findViewById(R.id.contentEditText);
        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();
        if (content.isEmpty()) {
            Toast.makeText(DiaryFilesActivity.this, "Continutul paginii nu poate fi gol", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            if (firebaseUser != null) {
                String userId = firebaseUser.getUid();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                        .getReference()
                        .child("username")
                        .child(userId)
                        .child("dairyPages");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            List<DiaryPage> journal = new ArrayList<>();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                DiaryPage diaryPage = snapshot.getValue(DiaryPage.class);
                                journal.add(diaryPage);
                            }

                        } else {

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Manejarea erorilor în timpul citirii din baza de date
                        Log.w("TAG", "Eroare la citirea datelor", databaseError.toException());
                    }
                });

                Intent data = new Intent();
                data.putExtra("title", title);
                data.putExtra("content", content);
                setResult(RESULT_OK, data);
                finish();

//        if(!title.isEmpty() && !content.isEmpty()){
//
//            DiaryPage diaryPage=new DiaryPage();
//            diaryPage.setTitle(title);
//            diaryPage.setContent(content);
//
//        }


            }
        }
    }
}