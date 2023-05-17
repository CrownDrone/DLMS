package com.example.dbms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
            TextView txtView= (TextView) view.findViewById(R.id.drivername);
            TextView txtView1= (TextView) view.findViewById(R.id.license);
            TextView txtView2= (TextView) view.findViewById(R.id.status);

            txtView.setText(itemsModelListFilter.get(i).getDrivername());
            txtView1.setText(itemsModelListFilter.get(i).getLicense());
            txtView2.setText(itemsModelListFilter.get(i).getStatus());

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