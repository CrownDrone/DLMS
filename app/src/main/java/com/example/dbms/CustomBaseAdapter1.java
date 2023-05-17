package com.example.dbms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter1 extends BaseAdapter {

    Context context;
    String accountname[];
    String accountid[];
    LayoutInflater inflater;

    public CustomBaseAdapter1(Context ctx, String[] accountname, String[] accountid){

        this.context = ctx;
        this.accountname = accountname;
        this.accountid = accountid;
        this.inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return accountid.length;
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
        view = inflater.inflate(R.layout.activity_custom_list_view1, null);
        TextView txtView= (TextView) view.findViewById(R.id.accountname);
        TextView txtView1= (TextView) view.findViewById(R.id.accountid);

        txtView.setText(accountname[i]);
        txtView1.setText(accountid[i]);

        return view;
    }
}
