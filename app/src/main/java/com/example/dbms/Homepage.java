package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    private Button logout, licenseStats, drivers, account;

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



    }

    private void logout(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    private void license(){
        Intent main = new Intent(this, LicenseStatus.class);
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