package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changePasswordLoginActivity extends AppCompatActivity {
    private Button resetPasswordButton;
    private EditText edtEmail;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    private String strEmail;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_login);
        resetPasswordButton = findViewById(R.id.btnReset);
        edtEmail = findViewById(R.id.edtForgotPasswordEmail);
        progressBar = findViewById(R.id.forgetPasswordProgressbar);
        mAuth = FirebaseAuth.getInstance();

        firebaseUser = mAuth.getCurrentUser();
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = edtEmail.getText().toString().trim();
                String emailUserDatabase= firebaseUser.getEmail();
                if(!strEmail.equals(emailUserDatabase))
                    Toast.makeText(changePasswordLoginActivity.this, "Adresa de email introdusa nu este aceeasi cu cea a contului", Toast.LENGTH_LONG).show();

                else  if (!TextUtils.isEmpty(strEmail)) {
                    ResetPassword();
                } else {
                    edtEmail.setError("Email field can't be empty");
                }
            }

            private void ResetPassword() {
                progressBar.setVisibility(View.VISIBLE);
                resetPasswordButton.setVisibility(View.INVISIBLE);

                mAuth.sendPasswordResetEmail(strEmail)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(changePasswordLoginActivity.this, "Reset Password link has been sent to your registered Email", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(changePasswordLoginActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(changePasswordLoginActivity.this, "Error :- " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                                resetPasswordButton.setVisibility(View.VISIBLE);
                            }
                        });

            }
        });

    }
}