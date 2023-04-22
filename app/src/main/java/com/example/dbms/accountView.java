package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class accountView extends AppCompatActivity {

    private Button lBack3;
    ListView licenseListA;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_view);


        licenseListA = (ListView)findViewById(R.id.licenseList);
        list.add("Fname mName Lname - AD00002");
        list.add("Fname mName Lname - AD00003");
        list.add("Fname mName Lname - AD00004");
        list.add("Fname mName Lname - AD00005");
        list.add("Fname mName Lname - AD00006");
        list.add("Fname mName Lname - AD00007");
        list.add("Fname mName Lname - AD00008");
        list.add("Fname mName Lname - AD00009");
        list.add("Fname mName Lname - AD00010");
        list.add("Fname mName Lname - AD00011");
        list.add("Fname mName Lname - AD00012");
        list.add("Fname mName Lname - AD00013");
        list.add("Fname mName Lname - AD00014");
        list.add("Fname mName Lname - AD00015");
        list.add("Fname mName Lname - AD00016");
        list.add("Fname mName Lname - AD00017");
        list.add("Fname mName Lname - AD00018");
        adapter = new ArrayAdapter(accountView.this, R.layout.list_orange_div, R.id.list_content,list);
        licenseListA.setAdapter(adapter);

    }
}