package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signUpEmail;
    private EditText signUpPassword;
    private Button signUpButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FirebaseApp.initializeApp(SignUpActivity.this);
        setContentView(R.layout.activity_sign_up);
        auth=FirebaseAuth.getInstance();
        signUpEmail=findViewById(R.id.signup_email);
        signUpPassword=findViewById(R.id.signup_password);
        signUpButton=findViewById(R.id.signup_button);
        loginRedirectText=findViewById(R.id.loginRedirectText);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= signUpEmail.getText().toString().trim();
                String pass=signUpPassword.getText().toString().trim();


                if(user.isEmpty()){
                    signUpEmail.setError("Email cannot be empty");

                }

                if(pass.isEmpty()){
                    signUpPassword.setError("Password cannot be empty");
                }
                else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this,"SignUp Successfully", Toast.LENGTH_SHORT).show();
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
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}