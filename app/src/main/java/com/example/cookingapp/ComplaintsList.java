package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class ComplaintsList extends AppCompatActivity{

    String complaints[] = {"My steak was burned", "The burgers have mold in them", "The chicken is raw", "Somebody spit in the food", "The chef was very rude"};

    ListView listView;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_list);
        listView = (ListView) findViewById(R.id.complaintListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),complaints);
        listView.setAdapter(customBaseAdapter);


    }
}