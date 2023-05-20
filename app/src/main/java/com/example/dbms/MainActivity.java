package com.example.dbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private FirebaseAuth mAuth;

    EditText email, password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.EmailAddress);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){

        String em = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(em.isEmpty() || pass.isEmpty()){
            Toast.makeText(MainActivity.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();

        }
        else{

            if (Patterns.EMAIL_ADDRESS.matcher(em).matches()){
                mAuth.signInWithEmailAndPassword(em, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Homepage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
            else {
                Toast.makeText(MainActivity.this, "Please enter an email address", Toast.LENGTH_SHORT).show();

            }

        }

    }

}