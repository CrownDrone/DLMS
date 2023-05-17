package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class accountView extends AppCompatActivity {

    String accountname[] = {"John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine"};
    String accountid[] = {"X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002"};

    ListView listview;
    private Button lBack3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_view);


        listview = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter1 customBaseAdapter = new CustomBaseAdapter1(getApplicationContext(),accountname,accountid);
        listview.setAdapter(customBaseAdapter);

        lBack3 = (Button) findViewById(R.id.lBack3);

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                back();
            }
        });

    }

    private void back(){
        Intent main = new Intent(this, account.class);
        startActivity(main);
    }
}