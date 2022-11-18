package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddMealToOfferedMealsActivity extends AppCompatActivity {
    String unwantedMeal;

    EditText mealInput;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_to_offered_meals);

        mealInput = (EditText) findViewById(R.id.editMeal);

        submit = (Button) findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unwantedMeal = mealInput.getText().toString().trim();


                Menu menu = Chef.menu;
                ArrayList<Meal> allMeals = (ArrayList) menu.mealList.clone();

                for (int i = 0; i < (allMeals.size() - 1);i++) {
                    Meal meal = allMeals.get(i);
                    if (meal.mealName.toLowerCase() == unwantedMeal.toLowerCase()) {
                        if (meal.isOffered == false) {
                            meal.isOffered = true;
                            showToast(unwantedMeal + " has been added to the offered items list.");
                        }
                    }
                }
            }
        });;
    }

    public void showToast(String toast) {
        Toast.makeText(AddMealToOfferedMealsActivity.this, toast, Toast.LENGTH_LONG).show();
    }
}