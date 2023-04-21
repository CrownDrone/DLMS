package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class LicenseStatus extends AppCompatActivity {

    private Spinner driver,violation,paymentstatus;
    private Button logout;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_status);

       /* driver  = findViewById(R.id.Driver);
        String[] items = new String[]{"John", "Taylor"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        driver.setAdapter(adapter);

        violation  = findViewById(R.id.violation);
        String[] items1 = new String[]{"Speeding", "Traffic Light Violation"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        violation.setAdapter(adapter1);

        paymentstatus  = findViewById(R.id.paymentstatus);
        String[] items2 = new String[]{"Completed", "Pending"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        paymentstatus.setAdapter(adapter2); */


    }

    private void logout(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }


}