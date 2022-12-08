package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MealsOfferedActivity extends AppCompatActivity {
    private ListView mealsOfferedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_offered);

        mealsOfferedList = findViewById(R.id.mealsOfferedList);

        new MenuDatabaseReader().readOfferedMealsList(new MenuDatabaseReader.DataStatus() {
            @Override
            public void DataIsLoaded(List<Meal> meals, List<String> keys) {
                MealAdapter mealAdapter = new MealAdapter(MealsOfferedActivity.this, R.layout.menu_list_row, meals);
                mealsOfferedList.setAdapter(mealAdapter);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}