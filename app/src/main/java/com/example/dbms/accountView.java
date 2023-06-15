package com.example.dbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class accountView extends AppCompatActivity {

    List<String> accountname = new ArrayList<>();
    List<String> accountid = new ArrayList<>();
    String name, account, passID;
    ListView listview1;

    CustomAdapter customAdapter1;

    SearchView searchView;

    List<ItemsModel1> listitems = new ArrayList();
    private Button lBack3;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_view);


        listview1 = (ListView) findViewById(R.id.customListView);

        searchView = findViewById(R.id.searchView);

        lBack3 = (Button) findViewById(R.id.lBack3);

        ref = FirebaseDatabase.getInstance().getReference().child("account");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                accountname.clear();
                accountid.clear();
                listitems.clear();

                for (DataSnapshot ds : datasnapshot.getChildren()){

                    name = ds.child("names").getValue().toString();
                    account = ds.child("accountIDs").getValue().toString();

                    accountname.add(name);
                    accountid.add(account);
                }
                String[] accountnameB = accountname.toArray(new String[0]);
                String[] accountidB = accountid.toArray(new String[0]);

                for(int i = 0; i< accountnameB.length; i++ ){

                    ItemsModel1 itemsModel = new ItemsModel1(accountnameB[i],accountidB[i]);
                    listitems.add(itemsModel);
                }
                customAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                customAdapter1.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customAdapter1.getFilter().filter(newText);
                return false;
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public class CustomAdapter extends BaseAdapter implements Filterable {

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
            passID = "";

            view = getLayoutInflater().inflate(R.layout.activity_custom_list_view1, null);
            TextView txtView1= (TextView) view.findViewById(R.id.accountid);
            TextView txtView= (TextView) view.findViewById(R.id.accountname);

            txtView1.setText(itemsModelListFilter.get(i).getAccountid());
            txtView.setText(itemsModelListFilter.get(i).getAccountname());

            passID = itemsModelListFilter.get(i).getAccountid();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(accountView.this, account.class).putExtra("item",itemsModelListFilter.get(i)));
                    forGate fg = new forGate();
                    System.out.println("pass onto "+passID);
                    fg.setPassID(passID);
                }
            });


            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {

                    FilterResults filterResults = new FilterResults();

                    if(charSequence == null || charSequence.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    } else{
                        String searchStr = charSequence.toString();
                        List<ItemsModel1> resultData = new ArrayList<>();

                        for(ItemsModel1 itemsModel:itemsModelList){
                            if(itemsModel.getAccountname().contains(searchStr) ||itemsModel.getAccountid().contains(searchStr)){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    itemsModelListFilter = (List<ItemsModel1>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }


    private void back(){
        Intent main = new Intent(this, account.class);
        startActivity(main);
    }
}