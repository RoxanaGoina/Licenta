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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiaryFilesActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_files);

        Button saveNote=findViewById(R.id.saveNotes);
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                saveNote();
            }
        });

    }
    public  void saveNote(){
        EditText titleEditText=findViewById(R.id.titleEditText);
        EditText contentEditText=findViewById(R.id.contentEditText);
        String title=titleEditText.getText().toString();
        String content=contentEditText.getText().toString();
        Intent data= new Intent();
        data.putExtra("title", title);
        data.putExtra("content",content);
        setResult(RESULT_OK,data);
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