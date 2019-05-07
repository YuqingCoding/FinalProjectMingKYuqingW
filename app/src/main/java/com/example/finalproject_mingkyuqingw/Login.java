package com.example.finalproject_mingkyuqingw;

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

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;

    private String userEmail;
    private String userPassword;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.enter_username);
        mPassword = (EditText) findViewById(R.id.enter_password);

        mAuth = FirebaseAuth.getInstance();

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
}