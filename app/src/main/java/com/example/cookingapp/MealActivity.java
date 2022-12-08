package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MealActivity extends AppCompatActivity {

    private EditText editMealName;
    private EditText editMealType;
    private EditText editCuisineType;
    private EditText editIngredients;
    private EditText editAllergens;
    private EditText editPrice;
    private EditText editDescription;

    private CheckBox chkOffered;
    private CheckBox chkNotOffered;

    private Button btnUpdate;
    private Button btnDeleteMeal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        editMealName = (EditText) findViewById(R.id.editMealName);
        editMealType = (EditText) findViewById(R.id.editMealType);
        editCuisineType = (EditText) findViewById(R.id.editCuisineType);
        editIngredients = (EditText) findViewById(R.id.editIngredients);
        editAllergens = (EditText) findViewById(R.id.editAllergens);
        editPrice = (EditText) findViewById(R.id.editPrice);
        editDescription = (EditText) findViewById(R.id.editDescription);

        chkOffered = (CheckBox) findViewById(R.id.checkBoxOffered);
        chkNotOffered = (CheckBox) findViewById(R.id.checkBoxNotOffered);

        btnUpdate = (Button) findViewById(R.id.btnUpdateMeal);
        btnDeleteMeal = (Button) findViewById(R.id.btnDeleteMeal);


    }
}