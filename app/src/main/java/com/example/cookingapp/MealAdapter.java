package com.example.cookingapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MealAdapter extends ArrayAdapter<Meal> {
    private Context mContext;
    private int mResource;

    public MealAdapter(@NonNull Context context, int resource, @NonNull List<Meal> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtMealTitle = convertView.findViewById(R.id.txtMealTitle);

        TextView txtMealDescription = convertView.findViewById(R.id.txtMealDescription);

        txtMealTitle.setText(getItem(position).getMealName());

        txtMealDescription.setText(getItem(position).getDescription());

        return convertView;
    }
}
