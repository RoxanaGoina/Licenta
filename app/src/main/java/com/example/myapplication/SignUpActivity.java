package com.example.myapplication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signUpEmail;
    private EditText signUpPassword;
    private Button signUpButton;
    private TextView loginRedirectText;

    private DatabaseReference database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sign_up);
        auth=FirebaseAuth.getInstance();
        signUpEmail=findViewById(R.id.signup_email);
        signUpPassword=findViewById(R.id.signup_password);
        signUpButton=findViewById(R.id.signup_button);
        loginRedirectText=findViewById(R.id.loginRedirectText);
        signUpPassword.setTransformationMethod(new PasswordTransformationMethod());
        LocalDate today;
        today = LocalDate.now();
        List<Symptom> symptomList = new ArrayList<>();
        List<DiaryPage> dairyPage=new ArrayList<>();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= signUpEmail.getText().toString().trim();
                String pass=signUpPassword.getText().toString().trim();


                if(username.isEmpty()){
                    signUpEmail.setError("Email cannot be empty");

                }

                if(pass.isEmpty()){
                    signUpPassword.setError("Password cannot be empty");
                }
                else{
                    auth.createUserWithEmailAndPassword(username,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this,"SignUp Successfully", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                if (user != null) {
                                    String userId = user.getUid();
                                    //TestObject testObject = new TestObject("Incerc", "Sa vad daca merge");
                                    User newUser=new User(username,"","",false,"",0,0,0,0,0,0,symptomList,dairyPage,0,0,0);
                                    database = FirebaseDatabase.getInstance("https://licenta-87184-default-rtdb.europe-west1.firebasedatabase.app").getReference();
                                    database.child("username").child(userId).setValue(newUser);
                                    //JSONArray jsonArray = new JSONArray(list);
                                    JSONArray symptoms=new JSONArray();
                                    for(Symptom symptom: symptomList){
                                        JSONObject jsonObject=new JSONObject();
                                        try {
                                            jsonObject.put("name","");
                                            jsonObject.put("date","");
                                            symptoms.put(jsonObject);
                                        }catch (JSONException e){
                                            e.printStackTrace();
                                        }

                                    }



                                    //JSONArray jsonArrayPages = new JSONArray(dairyPage);
                                    JSONArray jsonArrayForJournal = new JSONArray();
                                    for(DiaryPage journalPage: dairyPage){
                                        JSONObject jsonObject = new JSONObject();
                                         try {
                                             jsonObject.put("title","");
                                             jsonObject.put("content","");
                                             jsonObject.put("date","");
                                             jsonArrayForJournal.put(jsonObject);
                                         }
                                         catch (JSONException e){
                                             e.printStackTrace();
                                         }
                                    }
                                    database.child("username").child(userId).child("symptomps").setValue(symptoms.toString());
                                    String json = jsonArrayForJournal.toString();
                                    database.child("username").child(userId).child("dairyPages").setValue(json);

                                }
                                else {
                                    Toast.makeText(SignUpActivity.this, "Utilizatorul nu este autentificat", Toast.LENGTH_SHORT).show();
                                }
                                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

                                } else{
                                Toast.makeText(SignUpActivity.this,"SignUp Fail"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                Log.d("SignUp error", task.getException().getMessage());
                            }
                        }
                    });
                }

            }
        });





//
//
//
//        } else {
//            Toast.makeText(SignUpActivity.this, "Utilizatorul nu este autentificat", Toast.LENGTH_SHORT).show();
//        }

//        TestObject testObject=new TestObject("Incerc","Sa vad daca merge");
//        database = FirebaseDatabase.getInstance().getReference();
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        database.child("test").child(userId).setValue(testObject);
//        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}