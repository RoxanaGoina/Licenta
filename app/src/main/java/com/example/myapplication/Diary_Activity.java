package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Diary_Activity extends AppCompatActivity {
    private static final String PREFS_NAME = "NotePrefs";

    private static final String KEY_NOTE_COUNT = "NoteCount";

    private LinearLayout noteContainer;
    private List<DiaryPage> noteList;

    private Button addPage;


    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult activityResult) {
                            int result = activityResult.getResultCode();
                            Intent data = activityResult.getData();

                            if (result == RESULT_OK) {
                                DiaryPage diaryPage = new DiaryPage();
                                String title = data.getStringExtra("title");
                                diaryPage.setTitle(title);
                                String content = data.getStringExtra("content");
                               // String email=data.getStringExtra("emailUser");
                                diaryPage.setContent(content);
                                LocalDate today;
                                today = LocalDate.now();

                               // diaryPage.setEmailUser(email);
                                noteList.add(diaryPage);
                                savesNotesToPreference();
                                createNoteView(diaryPage);
                               // clearInputFields();
                            } else {
                                Toast.makeText(Diary_Activity.this, "Operatie invalida", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        noteContainer = findViewById(R.id.diaryPages);
        addPage = findViewById(R.id.addPage);
        noteList = new ArrayList<>();
        addPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Diary_Activity.this, DiaryFilesActivity.class);
                activityResultLauncher.launch(intent);
                //   startActivityForResult(new Intent(Diary_Activity.this, DiaryFilesActivity.class), 1);
            }
        });
        loadNotesFromPreferences();
        displayNotes();
    }

//    private void clearInputFields() {
//        EditText titleEditText=findViewById(R.id.titleEditText);
//        EditText contentEditText=findViewById(R.id.contentEditText);
//        titleEditText.getText().clear();
//        contentEditText.getText().clear();
//    }

    private void loadNotesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int noteCount = sharedPreferences.getInt(KEY_NOTE_COUNT, 0);
        String title;
        String content;
        String date;
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
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
                noteList = new ArrayList<>(); // Initialize noteList
                if (json != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(json);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String title = jsonObject.getString("title");
                            String content = jsonObject.getString("content");
                            String date = jsonObject.getString("date");
                            DiaryPage journalPage = new DiaryPage(date, title, content);
                            noteList.add(journalPage);
                        }
                        // Display the notes after loading from Firebase
                        displayNotes();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }


    private void savesNotesToPreference() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putInt(KEY_NOTE_COUNT, noteList.size());
        for (int i = 0; i < noteList.size(); i++) {
            DiaryPage diaryPage = noteList.get(i);
            editor.putString("note_title" + i, diaryPage.getTitle());
            editor.putString("note_content" + i, diaryPage.getContent());
            editor.putString("note_date"+i,diaryPage.getDate());

        }
        editor.apply();
    }

    public void createNoteView(final DiaryPage diaryPage) {
        View noteView = getLayoutInflater().inflate(R.layout.page_item, null);
        TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        TextView contentTextView = noteView.findViewById(R.id.contentTextView);
        TextView dateTextView=noteView.findViewById(R.id.dateTextView);
        titleTextView.setText(diaryPage.getTitle());
        contentTextView.setText(diaryPage.getContent());
       // contentTextView.setText(diaryPage.getDate());
        //LocalDate today;
       // today = LocalDate.now();
        dateTextView.setText(diaryPage.getDate());

        noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteDialog(diaryPage);
                return true;
            }
        });

        noteContainer.addView(noteView);
    }
        private void displayNotes(){

        for (DiaryPage diaryPage : noteList){
            createNoteView(diaryPage);
        }
        }
        private void showDeleteDialog(final DiaryPage diaryPage){

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Sigur stergi aceasta pagina?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteNoteAndRefresh(diaryPage);
            }
        });
        builder.setNegativeButton("Cancel",null);
        builder.show();


        }

        private void deleteNoteAndRefresh(DiaryPage diaryPage){
//        noteList.remove(diaryPage);
//        savesNotesToPreference();
//        refreshNoteViews();
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
                        if (json != null) {
                            try {
                                JSONArray jsonArray = new JSONArray(json);
                                JSONArray updatedJsonArray = new JSONArray();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String title = jsonObject.getString("title");
                                    String content = jsonObject.getString("content");
                                    String date = jsonObject.getString("date");
                                    if (!title.equals(diaryPage.getTitle()) || !content.equals(diaryPage.getContent()) || !date.equals(diaryPage.getDate())) {
                                        // If it's not the diaryPage to be deleted, add it to the updatedJsonArray
                                        updatedJsonArray.put(jsonObject);
                                    }
                                }
                                // Save the updated JSON array back to Firebase
                                databaseReference.setValue(updatedJsonArray.toString());

                                // Update the local noteList variable to reflect the deletion
                                noteList.remove(diaryPage);

                                // Refresh the UI
                                refreshNoteViews();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle error
                    }
                });
            }
        }
        private void refreshNoteViews(){

        noteContainer.removeAllViews();
        displayNotes();
        }
}