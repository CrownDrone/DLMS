package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Drivers extends AppCompatActivity {

    private Button dBack,dateButton,licenseExp,addBTN,editBTN,updateBTN,deleteBTn;  //dateButton is birthday button
    private DatePickerDialog datePickerDialog,datePickerDialog1;

    private EditText name, weight, height, address,licenseno,agencycode,dlcode,conditions;
    Spinner blood,status1,eye,national,genders;

    ItemsModel itemsModel;

    DatabaseReference DBMS;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);

        DBMS = FirebaseDatabase.getInstance().getReference().child("driver");

        initDatePicker();
        initDatePicker1();

        dBack = (Button) findViewById(R.id.dBack);

        dateButton = findViewById(R.id.birthday);
        dateButton.setText(getTodaysDate());

        licenseExp = findViewById(R.id.licenseEx);
        licenseExp.setText(getTodaysDate1());

        name = findViewById(R.id.Fdrivername);
        licenseno = findViewById(R.id.licenseno);
        status1 = (Spinner) findViewById(R.id.Status);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        address = findViewById(R.id.address);
        agencycode = findViewById(R.id.agencycode);
        dlcode = findViewById(R.id.dlcode);
        conditions = findViewById(R.id.conditions);


        addBTN = findViewById(R.id.addBTN);
        editBTN = findViewById(R.id.editBTN);
        updateBTN= findViewById(R.id.updateBTN);
        deleteBTn = findViewById(R.id.deleteBTN);



        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
        String[] gender = new String[] {
                "Sex","Male", "Female"
        };
        genders = (Spinner) findViewById(R.id.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genders.setAdapter(adapter);

        genders.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(genders.getSelectedItem() == "Sex")
                {

                    //Do nothing.
                }
                else{

                   // Toast.makeText(Drivers.this, genders.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
        String[] bloodType = new String[] {
                "Blood Type","A", "A+", "A-","B", "B+", "B-","AB", "AB+", "AB-","O", "O+", "O-",
        };
        blood = (Spinner) findViewById(R.id.BloodType);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bloodType);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blood.setAdapter(adapter1);

        blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(blood.getSelectedItem() == "Blood Type")
                {

                    //Do nothing.
                }
                else{

                   // Toast.makeText(Drivers.this, blood.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
        String[] status = new String[] {
                "License Status","Active", "Expired", "Custody"
        };
        status1 = (Spinner) findViewById(R.id.Status);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, status);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status1.setAdapter(adapter2);

        status1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(status1.getSelectedItem() == "License Status")
                {

                    //Do nothing.
                }
                else{

                   // Toast.makeText(Drivers.this, status1.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
        String[] eyeColor = new String[] {
                "Eye Color","Brown", "Black", "Blue","Gray", "Hazel", "Amber",
        };
         eye = (Spinner) findViewById(R.id.eyecolor);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, eyeColor);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eye.setAdapter(adapter3);

        eye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(eye.getSelectedItem() == "Eye Color")
                {

                    //Do nothing.
                }
                else{

                    //Toast.makeText(Drivers.this, eye.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
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

                   // Toast.makeText(Drivers.this, national.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });


        // buong function nito is set yung text sa editText sa LicenseView
        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");

            name.setText(itemsModel.getDrivername());
            licenseno.setText(itemsModel.getLicense());

            if(itemsModel.getStatus().equals("Active")){  //set license status depende itemsModel.getStatus na text or string
                status1.setSelection(1);
            } else if (itemsModel.getStatus().equals("Expired")){
                status1.setSelection(2);
            } else if (itemsModel.getStatus().equals("Custody")){
                status1.setSelection(3);
            } else {
                status1.setSelection(0);
            }

        }

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDriver();
            }
        });


    }

    private void addDriver() {

        //hold them values ayt
        String names = name.getText().toString().trim();
        String licensenos = licenseno.getText().toString().trim();
        String statuss = status1.getSelectedItem().toString();
        String genderss = genders.getSelectedItem().toString();
        String bloods = blood.getSelectedItem().toString();
        String nationals = national.getSelectedItem().toString();
        String eyes = eye.getSelectedItem().toString();
        String weightt = weight.getText().toString().trim();
        String heightt = height.getText().toString().trim();
        String adresss = address.getText().toString().trim();
        String agencycodes = agencycode.getText().toString().trim();
        String dlcodes = dlcode.getText().toString().trim();
        String conditionss = conditions.getText().toString().trim();

            //gate keep
            if(names.isEmpty() || licensenos.isEmpty()||weightt.isEmpty() || heightt.isEmpty()||adresss.isEmpty() || agencycodes.isEmpty()||dlcodes.isEmpty()){
                Toast.makeText(Drivers.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            } else if (genderss.equals("Sex")) {
                Toast.makeText(Drivers.this, "Please enter your Sex", Toast.LENGTH_SHORT).show();
            } else if (bloods.equals("Blood Type")) {
                Toast.makeText(Drivers.this, "Please enter your Blood Type", Toast.LENGTH_SHORT).show();
            } else if (statuss.equals("License Status")) {
                Toast.makeText(Drivers.this, "Please enter your License Status", Toast.LENGTH_SHORT).show();
            } else if (eyes.equals("Eye Color")) {
                Toast.makeText(Drivers.this, "Please enter your Eye Color", Toast.LENGTH_SHORT).show();
            } else if (nationals.equals("Nationality")) {
                Toast.makeText(Drivers.this, "Please enter your Nationality", Toast.LENGTH_SHORT).show();
             }else{
                //fetch them values ayt
                driverAdder add = new driverAdder(names, licensenos, statuss, genderss, bloods, nationals, eyes, weightt, heightt, adresss, agencycodes, dlcodes, conditionss);
                DBMS.push().setValue(add);
                Toast.makeText(Drivers.this, "Added", Toast.LENGTH_SHORT).show();
            }
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

    private String getTodaysDate1()
    {
        Calendar cal1 = Calendar.getInstance();
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        month1 = month1 + 1;
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day1, month1, year1);
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

    private void initDatePicker1()
    {
        DatePickerDialog.OnDateSetListener dateSetListener1 = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker1, int year1, int month1, int day1)
            {
                month1 = month1 + 1;
                String date1 = makeDateString1(day1, month1, year1);
                licenseExp.setText(date1);
            }
        };

        Calendar cal1 = Calendar.getInstance();
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);

        int style1 = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog1 = new DatePickerDialog(this, style1, dateSetListener1, year1, month1, day1);

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String makeDateString1(int day1, int month1, int year1)
    {
        return getMonthFormat1(month1) + " " + day1 + " " + year1;
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

    private String getMonthFormat1(int month)
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

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }

    public void openDatePicker1(View view) {
        datePickerDialog1.show();
    }
}