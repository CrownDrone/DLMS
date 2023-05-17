package com.example.dbms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class accountView extends AppCompatActivity {

    String accountname[] = {"John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine","John Vel", "Kaiser Mao", "Blake Justine"};
    String accountid[] = {"X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002","X00-00-000000", "X00-00-000001", "X00-00-000002"};

    ListView listview1;

    CustomAdapter customAdapter1;

    SearchView searchView;

    List<ItemsModel1> listitems = new ArrayList();
    private Button lBack3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_view);


        listview1 = (ListView) findViewById(R.id.customListView);

        searchView = findViewById(R.id.searchView);

        lBack3 = (Button) findViewById(R.id.lBack3);


        for(int i = 0; i< accountname.length; i++ ){

            ItemsModel1 itemsModel = new ItemsModel1(accountname[i],accountid[i]);
            listitems.add(itemsModel);


        }

        customAdapter1 = new CustomAdapter(listitems, this);
        listview1.setAdapter(customAdapter1);


        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                back();
            }
        });

    }

    public class CustomAdapter extends BaseAdapter {

        private List<ItemsModel1> itemsModelList;
        private List<ItemsModel1> itemsModelListFilter;
        private Context context;

        public CustomAdapter(List<ItemsModel1> itemsModelList, Context context) {
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

            view = getLayoutInflater().inflate(R.layout.activity_custom_list_view1, null);
            TextView txtView= (TextView) view.findViewById(R.id.accountname);
            TextView txtView1= (TextView) view.findViewById(R.id.accountid);

            txtView.setText(itemsModelListFilter.get(i).getAccountname());
            txtView1.setText(itemsModelListFilter.get(i).getAccountid());



            return view;
        }
    }


    private void back(){
        Intent main = new Intent(this, account.class);
        startActivity(main);
    }
}