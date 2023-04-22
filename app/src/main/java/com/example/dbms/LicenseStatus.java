package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class LicenseStatus extends AppCompatActivity {

    private Button lBack3;
    ListView licenseListA;
    List list = new ArrayList();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_status);

        lBack3 = (Button) findViewById(R.id.lBack3);

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        licenseListA = (ListView)findViewById(R.id.licenseList);
        list.add("Lname, Fname - X00-00-000000 - ACTIVE");
        list.add("Lname, Fname - X00-00-000002 - CUSTODY");
        list.add("Lname, Fname - X00-00-000003 - EXPIRED");
        list.add("Lname, Fname - X00-00-000004 - EXPIRED");
        list.add("Lname, Fname - X00-00-000005 - EXPIRED");
        list.add("Lname, Fname - X00-00-000006 - EXPIRED");
        list.add("Lname, Fname - X00-00-000007 - EXPIRED");
        list.add("Lname, Fname - X00-00-000008 - EXPIRED");
        list.add("Lname, Fname - X00-00-000009 - EXPIRED");
        list.add("Lname, Fname - X00-00-000010 - EXPIRED");
        list.add("Lname, Fname - X00-00-000011 - EXPIRED");
        list.add("Lname, Fname - X00-00-000012 - EXPIRED");
        list.add("Lname, Fname - X00-00-000013 - EXPIRED");
        list.add("Lname, Fname - X00-00-000014 - EXPIRED");
        list.add("Lname, Fname - X00-00-000015 - EXPIRED");
        list.add("Lname, Fname - X00-00-000016 - EXPIRED");
        list.add("Lname, Fname - X00-00-000017 - EXPIRED");
        list.add("Lname, Fname - X00-00-000018 - EXPIRED");
        list.add("Lname, Fname - X00-00-000019 - EXPIRED");
        list.add("Lname, Fname - X00-00-000020 - EXPIRED");
        list.add("Lname, Fname - X00-00-000021 - EXPIRED");
        list.add("Lname, Fname - X00-00-000022 - EXPIRED");
        list.add("Lname, Fname - X00-00-000023 - EXPIRED");
        adapter = new ArrayAdapter(LicenseStatus.this, R.layout.list_orange_div, R.id.list_content,list);
        licenseListA.setAdapter(adapter);


    }

    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }


}