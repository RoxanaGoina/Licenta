package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText loginEmail;
    private EditText loginPassword;
    private TextView signUpRedirectText;
    private Button loginButton;
    private TextView passwordForgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FirebaseApp.initializeApp(LoginActivity.this);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
       // EditText editTextPassword = findViewById(R.id.logi);
        loginPassword.setTransformationMethod(new PasswordTransformationMethod());

        loginButton = findViewById(R.id.login_button);
        signUpRedirectText = findViewById(R.id.signupRedirectText);
        passwordForgot=findViewById(R.id.passForgot);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainMenu.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                            }
                        });
                    } else {
                        loginPassword.setError("Password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    loginEmail.setError("Email cannot be empty");
                } else {
                    loginEmail.setError("Please enter a valid email");
                }
            }

        });

        signUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));

            }
        });
        passwordForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,changePasswordLoginActivity.class));
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);
            finish();
        }
    }

}