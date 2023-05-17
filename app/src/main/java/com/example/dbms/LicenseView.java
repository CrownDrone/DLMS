package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class LicenseView extends AppCompatActivity {

    String drivernames[] = {"John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine"};
    String licenses[] = {"X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002"};
    String statuses[] = {"ACTIVE", "CUSTODY", "EXPIRED","ACTIVE", "CUSTODY", "EXPIRED","ACTIVE", "CUSTODY", "EXPIRED"};

    ListView listview;
    private Button lBack3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_view);

        listview = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),drivernames,licenses,statuses);
        listview.setAdapter(customBaseAdapter);

        lBack3 = (Button) findViewById(R.id.lBack3);

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }
    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }
}