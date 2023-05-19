package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class account extends AppCompatActivity {
    private Button aBack,dateButton,aBack2;
    private DatePickerDialog datePickerDialog;

    private EditText fullname,address,agencycode,age,email,contactno,accountID,licenseno;

    Spinner s, national;

    ItemsModel1 itemsModel1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        aBack = (Button) findViewById(R.id.aBack);
        aBack2 = (Button) findViewById(R.id.aBack2);

        initDatePicker();
        dateButton = findViewById(R.id.birthday);
        dateButton.setText(getTodaysDate());

        fullname = findViewById(R.id.fullname);
        accountID = findViewById(R.id.accountno);


        aBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        aBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccList();
            }
        });
        String[] gender = new String[] {
                "Sex","Male", "Female"
        };
        s = (Spinner) findViewById(R.id.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(s.getSelectedItem() == "Sex")
                {

                    //Do nothing.
                }
                else{

                    Toast.makeText(account.this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] nationality = new String[] {
                "Nationality","Filipino", "Spanish", "Finnish","Chinese", "Japanese", "Korean","American"
        };
        national = (Spinner) findViewById(R.id.nationality);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nationality);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        national.setAdapter(adapter4);

        national.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(national.getSelectedItem() == "Nationality")
                {

                    //Do nothing.
                }
                else{

                    Toast.makeText(account.this, national.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel1 = (ItemsModel1) intent.getSerializableExtra("item");

            fullname.setText(itemsModel1.getAccountname());
            accountID.setText(itemsModel1.getAccountid());

        }


    }

    private void AccList() {
        Intent main = new Intent(this, accountView.class);
        startActivity(main);
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }


    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

}