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

import org.w3c.dom.Text;

import java.util.ArrayList;
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
                                diaryPage.setContent(content);
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
        for (int i = 0; i < noteCount; i++) {
            title = sharedPreferences.getString("note_title" + i, "");
            content = sharedPreferences.getString("note_content" + i,"" );
            DiaryPage diaryPage=new DiaryPage();
            diaryPage.setTitle(title);
            diaryPage.setContent(content);
            noteList.add(diaryPage);
        }
    }

    private void savesNotesToPreference() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_NOTE_COUNT, noteList.size());
        for (int i = 0; i < noteList.size(); i++) {
            DiaryPage diaryPage = noteList.get(i);
            editor.putString("note_title" + i, diaryPage.getTitle());
            editor.putString("note_content" + i, diaryPage.getContent());

        }
        editor.apply();
    }

    public void createNoteView(final DiaryPage diaryPage) {
        View noteView = getLayoutInflater().inflate(R.layout.page_item, null);
        TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        TextView contentTextView = noteView.findViewById(R.id.contentTextView);

        titleTextView.setText(diaryPage.getTitle());
        contentTextView.setText(diaryPage.getContent());

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
        noteList.remove(diaryPage);
        savesNotesToPreference();
        refreshNoteViews();
        }
        private void refreshNoteViews(){

        noteContainer.removeAllViews();
        displayNotes();
        }
}