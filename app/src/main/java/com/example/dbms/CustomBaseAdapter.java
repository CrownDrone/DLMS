package com.example.dbms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String drivername[];
    String license[];
    String status[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String[] drivername, String[] license, String[] status){

        this.context = ctx;
        this.drivername = drivername;
        this.license = license;
        this.status = status;
        this.inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {

        return  license.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView= (TextView) view.findViewById(R.id.drivername);
        TextView txtView1= (TextView) view.findViewById(R.id.license);
        TextView txtView2= (TextView) view.findViewById(R.id.status);

        txtView.setText(drivername[i]);
        txtView1.setText(license[i]);
        txtView2.setText(status[i]);

        return view;
    }
}
