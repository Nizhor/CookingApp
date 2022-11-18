package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MealsOfferedActivity extends AppCompatActivity {
    private ListView mealsOfferedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_offered);

        mealsOfferedList = findViewById(R.id.mealsOfferedList);

        ArrayList<Meal> offeredMeals = (ArrayList) Menu.offeredMeals.clone();

        MealAdapter mealAdapter = new MealAdapter(this, R.layout.menu_list_row, offeredMeals);
    }
}