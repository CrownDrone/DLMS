package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {

    private Button logout, licenseStats, drivers, account;
    TextView text;
    FirebaseAuth auth;
    FirebaseUser user;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);
        logout = (Button) findViewById(R.id.logout);
        licenseStats = (Button) findViewById(R.id.license);
        drivers = (Button) findViewById(R.id.Driver);
        account = (Button) findViewById(R.id.account);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        licenseStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                license();
            }
        });

        drivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null){
            Toast.makeText(Homepage.this, "Session Timed Out", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void license(){
        Intent main = new Intent(this, LicenseView.class);
        startActivity(main);
    }
    private void driver(){
        Intent main = new Intent(this, Drivers.class);
        startActivity(main);
    }

    private void account(){
        Intent main = new Intent(this, account.class);
        startActivity(main);
    }
}