package com.example.dbms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LicenseView extends AppCompatActivity {

    /*String drivernames[];
    String licenses[];
    String statuses[];*/

    List<String> drivernames = new ArrayList<>();
    List<String> licenses = new ArrayList<>();
    List<String> statuses = new ArrayList<>();

    String name, license, status, passLicense;

    ListView listview;

    CustomAdapter customAdapter;

    SearchView searchView;

    List<ItemsModel> listitems = new ArrayList();
    private Button lBack3;
    DatabaseReference ref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_view);

        listview = (ListView) findViewById(R.id.customListView);

        searchView = findViewById(R.id.searchView);

        lBack3 = (Button) findViewById(R.id.lBack3);

        ref = FirebaseDatabase.getInstance().getReference().child("driver");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                //remove all leftover data; prevents stacking
                listitems.clear();
                drivernames.clear();
                licenses.clear();
                statuses.clear();

                for (DataSnapshot ds : datasnapshot.getChildren()){//loop for retrieving data from database

                    name = ds.child("names").getValue().toString();
                    license = ds.child("licensenos").getValue().toString();
                    status = ds.child("statuss").getValue().toString();
                    System.out.println("and thems the fact: "+name+" "+license+" "+status);

                    //add retrieve data to arraylist
                    drivernames.add(name);
                    licenses.add(license);
                    statuses.add(status);
                }

                //convert arraylists into list strings
                String[] drivernamesB = drivernames.toArray(new String[0]);
                String[] licensesB = licenses.toArray(new String[0]);
                String[] statusesB = statuses.toArray(new String[0]);


                //loop to convert 3 list strings into 1 array, firebase maarte ayaw rekta tatlo hmpp
                for(int i = 0; i< drivernamesB.length; i++ ){

                    ItemsModel itemsModel = new ItemsModel(drivernamesB[i],licensesB[i],statusesB[i]);
                    listitems.add(itemsModel);

                }//EA SPORTS IT'S IN THE GAME

                System.out.println("DM33: "+ Arrays.toString(drivernamesB) +" "+Arrays.toString(licensesB)+" "+Arrays.toString(statusesB));
                System.out.println("3BM42: "+listitems); //print stuff so I know I'm not hallucinating

                customAdapter.notifyDataSetChanged();//update listview
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        customAdapter = new CustomAdapter(listitems, this);
        listview.setAdapter(customAdapter);

        lBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                customAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                customAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

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
            TextView txtView1= (TextView) view.findViewById(R.id.license);
            TextView txtView= (TextView) view.findViewById(R.id.drivername);
            TextView txtView2= (TextView) view.findViewById(R.id.status);

            txtView1.setText(itemsModelListFilter.get(i).getLicense());
            txtView.setText(itemsModelListFilter.get(i).getDrivername());
            txtView2.setText(itemsModelListFilter.get(i).getStatus());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    passLicense = "";
                    passLicense = itemsModelListFilter.get(i).getLicense();
                    startActivity(new Intent(LicenseView.this, Drivers.class).putExtra("item",itemsModelListFilter.get(i)));
                    System.out.println("pass onto "+passLicense);
                    forGate fg = new forGate();
                    fg.setPassLicense(passLicense);
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
                        List<ItemsModel> resultData = new ArrayList<>();

                        for(ItemsModel itemsModel:itemsModelList){
                            if(itemsModel.getDrivername().contains(searchStr) ||itemsModel.getLicense().contains(searchStr) || itemsModel.getStatus().contains(searchStr) ){
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
                    itemsModelListFilter = (List<ItemsModel>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }

    private void back(){
        Intent main = new Intent(this, Homepage.class);
        startActivity(main);
    }
}