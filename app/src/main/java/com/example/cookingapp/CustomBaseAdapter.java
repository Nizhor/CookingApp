package com.example.cookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter{

    Context context;
    String complaints[];
    LayoutInflater inflater;


    public CustomBaseAdapter(Context ctx, String[] complaints){
        this.context = ctx;
        this.complaints = complaints;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return complaints.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        txtView.setText(complaints[position]);


        return convertView;
    }
}
