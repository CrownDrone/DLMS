package com.example.dbms;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class account extends AppCompatActivity {

    private Button aBack,dateButton,aBack2,addBTN2,editBTN2,updateBTN2,deleteBTN2;  //dateButton is birthday button
    private DatePickerDialog datePickerDialog;

    private DatePicker datebutton;
    private EditText fullname, accountID, address,agencycode,contactno,age,email;

    public String idnum;
    Spinner genders,national;
    ItemsModel1 itemsModel1;
    DatabaseReference DBMS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        aBack = (Button) findViewById(R.id.aBack);
        aBack2 = (Button) findViewById(R.id.aBack2);
        addBTN2 = (Button)  findViewById(R.id.addBTN2);
        editBTN2 =(Button)  findViewById(R.id.editBTN2);
        updateBTN2= (Button) findViewById(R.id.updateBTN2);
        deleteBTN2 = (Button) findViewById(R.id.deleteBTN2);

        initDatePicker();
        dateButton = findViewById(R.id.birthday);
        dateButton.setText(getTodaysDate());

        fullname = findViewById(R.id.fullname);
        accountID = findViewById(R.id.accountno);
        address = findViewById(R.id.address);
        agencycode = findViewById(R.id.agencycode);
        contactno = findViewById(R.id.contactno);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        genders = (Spinner) findViewById(R.id.gender);
        national = (Spinner) findViewById(R.id.nationality);


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


        //pag may ganto, ito yung gumawa ako spinner at nag import ng static items sa loob para may choices
        String[] gender = new String[] {
                "Sex","Male", "Female"
        };
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

                  //  Toast.makeText(account.this, genders.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

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

                  //  Toast.makeText(account.this, national.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // buong function nito is magset nung text sa editText sa accountView
        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel1 = (ItemsModel1) intent.getSerializableExtra("item");

            fullname.setText(itemsModel1.getAccountname());
            accountID.setText(itemsModel1.getAccountid());

        }

        addBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAccount();
            }
        });


    }

    private void AccList() {
        Intent homepage = new Intent(this, accountView.class);
        startActivity(homepage);
    }


    private void addAccount() {
        idnum = accountID.getText().toString();
        DBMS = FirebaseDatabase.getInstance().getReference();
        DatabaseReference driverRef = DBMS.child("account");
        Query accountno = driverRef.orderByChild("accountIDs").equalTo(idnum);
        accountno.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){//check for duplicate
                    System.out.println("account exists");
                    Toast.makeText(account.this, "account already exists", Toast.LENGTH_SHORT).show();
                }
                else{
                    System.out.println("Does not exists");
                    passData();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void passData(){
        String names = fullname.getText().toString().trim();
        String accountIDs = accountID.getText().toString();
        String adresss = address.getText().toString().trim();
        String agencycodes = agencycode.getText().toString().trim();
        String contactnos = contactno.getText().toString().trim();
        String ages = age.getText().toString().trim();
        String emails = email.getText().toString().trim();
        String genderss = genders.getSelectedItem().toString();
        String nationals = national.getSelectedItem().toString();
        String birth = dateButton.getText().toString();


        if(names.isEmpty() || accountIDs.isEmpty() || contactnos.isEmpty()||adresss.isEmpty() || agencycodes.isEmpty()||ages.isEmpty() || emails.isEmpty()){
            Toast.makeText(account.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
        } else if (genderss.equals("Sex")){
            Toast.makeText(account.this, "Please enter your Sex", Toast.LENGTH_SHORT).show();
        }else if ( nationals.equals("Nationality")){
            Toast.makeText(account.this, "Please enter your Nationality", Toast.LENGTH_SHORT).show();
        } else{
            if (!emails.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emails).matches()){
                Toast.makeText(account.this, "Added", Toast.LENGTH_SHORT).show();
                accountAdder add = new accountAdder(names, accountIDs, adresss, agencycodes, contactnos, ages, emails, genderss, nationals, birth);
                DBMS = FirebaseDatabase.getInstance().getReference().child("account");
                DBMS.push().setValue(add);
            } else {
                Toast.makeText(account.this, "Please enter an email address", Toast.LENGTH_SHORT).show();
            }
        }
        idnum = "";
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

    public void setIDnum(String string){
        idnum = string;
    }

}