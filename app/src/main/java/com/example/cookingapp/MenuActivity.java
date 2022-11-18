package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        menuList = findViewById(R.id.menuList);

        ArrayList<Meal> allMeals = (ArrayList) Menu.mealList.clone();

        MealAdapter mealAdapter = new MealAdapter(this, R.layout.menu_list_row, allMeals);

    }
}