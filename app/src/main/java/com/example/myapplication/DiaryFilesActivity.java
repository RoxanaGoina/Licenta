package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DiaryPage;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DiaryFilesActivity extends AppCompatActivity {

    private List<DiaryPage> journal;
    private Button saveNote;
    private EditText titleEditText;
    private EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_files);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        saveNote = findViewById(R.id.saveNotes);



        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });


        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference()
                    .child("username")
                    .child(userId)
                    .child("dairyPages");

//            databaseReference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    String jsonArray = dataSnapshot.getValue(String.class);
//                    try {
//                        JSONArray jsonArrayLocal = new JSONArray(jsonArray);
//
//                        // Iterate through the JSONArray to extract DiaryPage objects
//                        for (int i = 0; i < jsonArrayLocal.length(); i++) {
//                            JSONObject jsonDiaryPage = jsonArrayLocal.getJSONObject(i);
//
//                            DiaryPage diaryPage = new DiaryPage();
//                           // diaryPage.setTitle(jsonDiaryPage.getString("title"));
//                           // diaryPage.setContent(jsonDiaryPage.getString("content"));
//                          //  diaryPage.setDate(LocalDate.now());
//                         //   diaryPage.setEmailUser("");
//
//                            journal.add(diaryPage);
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
////
////
////
////                    if (dataSnapshot.exists()) {
////                        journal = new ArrayList<>();
////                        DiaryPage jsonSymptoms = dataSnapshot.getValue(D.class);
////
////                        JSONArray jsonArray = new JSONArray(journal);
////                        for (int i = 0; i < jsonArray.length(); i++) {
////                            DiaryPage diaryPage = jsonArray.getValue(i);
////                            journal.add(diaryPage);
////                        }
////
////                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                            DiaryPage diaryPage = snapshot.getValue(DiaryPage.class);
////                            journal.add(diaryPage);
////                        }
////                    }
////
////
////
////
//                }
//
//                //
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
        }
    }

    public void saveNote() {
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
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String json = dataSnapshot.getValue(String.class);
                        List<DiaryPage> journal = new ArrayList<>();
                        if (json != null) {
                            try {
                                JSONArray jsonArray = new JSONArray(json);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String title = jsonObject.getString("title");
                                    String content = jsonObject.getString("content");
                                    String date = jsonObject.getString("date");
                                    DiaryPage journalPage = new DiaryPage(date, title, content);
                                    journal.add(journalPage);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dateString = currentDate.format(dateFormatter);

                        DiaryPage diaryPage = new DiaryPage(dateString, titleEditText.getText().toString(), contentEditText.getText().toString());
                        journal.add(diaryPage);

                        // Convert journal list to JSON
                        JSONArray updatedJsonArray = new JSONArray();
                        for (DiaryPage journalPage : journal) {
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("title", journalPage.getTitle());
                                jsonObject.put("content", journalPage.getContent());
                                jsonObject.put("date", journalPage.getDate());
                                updatedJsonArray.put(jsonObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        String updatedJson = updatedJsonArray.toString();
                        databaseReference.setValue(updatedJson);

                        Intent data = new Intent();
                        data.putExtra("title", title);
                        data.putExtra("content", content);
                        setResult(RESULT_OK, data);
                        finish();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle error
                    }
                });
            }
        }
    }

}
