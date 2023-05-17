package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LicenseView extends AppCompatActivity {

    String drivernames[] = {"John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine"};
    String licenses[] = {"X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002"};
    String statuses[] = {"ACTIVE", "CUSTODY", "EXPIRED","ACTIVE", "CUSTODY", "EXPIRED","ACTIVE", "CUSTODY", "EXPIRED"};

    ListView listview;

    CustomAdapter customAdapter;

    SearchView searchView;

    List<ItemsModel> listitems = new ArrayList();
    private Button lBack3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_view);

        listview = (ListView) findViewById(R.id.customListView);

        searchView = findViewById(R.id.searchView);

        lBack3 = (Button) findViewById(R.id.lBack3);


        for(int i = 0; i< drivernames.length; i++ ){

            ItemsModel itemsModel = new ItemsModel(drivernames[i],licenses[i],statuses[i]);
            listitems.add(itemsModel);


        }

        customAdapter = new CustomAdapter(listitems, this);
        listview.setAdapter(customAdapter);

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }

    public class CustomAdapter extends BaseAdapter{

        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFilter;
        private Context context;


        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFilter = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFilter.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.activity_custom_list_view, null);
            TextView txtView= (TextView) view.findViewById(R.id.drivername);
            TextView txtView1= (TextView) view.findViewById(R.id.license);
            TextView txtView2= (TextView) view.findViewById(R.id.status);

            txtView.setText(itemsModelListFilter.get(i).getDrivername());
            txtView1.setText(itemsModelListFilter.get(i).getLicense());
            txtView2.setText(itemsModelListFilter.get(i).getStatus());

            return view;
        }
    }


    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }
}