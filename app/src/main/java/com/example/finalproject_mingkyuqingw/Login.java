package com.example.finalproject_mingkyuqingw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mGoogleButton;
    public static final int RC_SIGN_IN = 1;

    private String userEmail;
    private String userPassword;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.enter_username);
        mPassword = (EditText) findViewById(R.id.enter_password);
        mGoogleButton = (Button) findViewById(R.id.auth_button);

        mAuth = FirebaseAuth.getInstance();

        mGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            Toast.makeText(Login.this, "You're now signed in. ", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivityForResult(
                                    AuthUI.getInstance().createSignInIntentBuilder().setIsSmartLockEnabled(false).setAvailableProviders(

                                            Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build()
                                            ))
                                            .build(),
                                    RC_SIGN_IN);
                        }
                    }
                });
        }




    public void login(View view) {
        userEmail = mEmail.getText().toString();
        userPassword = mPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Login.this, Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, Objects.requireNonNull(task.getResult()).getUser().getEmail() + "log in successful", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

    public void signUp(View view) {
        userEmail = mEmail.getText().toString();
        userPassword = mPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Login.this, Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, Objects.requireNonNull(task.getResult()).getUser().getEmail() + "sign up successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
                finish();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }


}