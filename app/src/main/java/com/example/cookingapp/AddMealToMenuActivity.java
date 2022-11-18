package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

public class AddMealToMenuActivity extends AppCompatActivity {
    private EditText editTextMealName, editTextMealType, editTextCuisineType, editTextIngredients,
            editTextAllergens, editTextDescription, editTextPrice;
    private CheckBox chkYes, chkNo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_to_menu);

        editTextMealName = (EditText) findViewById(R.id.editMealName);
        editTextMealType = (EditText) findViewById(R.id.editMealType);
        editTextCuisineType = (EditText) findViewById(R.id.editCuisineType);
        editTextIngredients = (EditText) findViewById(R.id.editIngredients);
        editTextAllergens = (EditText) findViewById(R.id.editAllergens);
        editTextDescription = (EditText) findViewById(R.id.editDescription);
        editTextPrice = (EditText) findViewById(R.id.editPrice);

        chkYes = (CheckBox) findViewById(R.id.checkBoxYes);
        chkYes = (CheckBox) findViewById(R.id.checkBoxNo);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddMeal:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    public void addMeal() {
        String mealName = editTextMealName.getText().toString().trim();
        String mealType = editTextMealType.getText().toString().trim();
        String cuisineType = editTextCuisineType.getText().toString().trim();
        String ingredients = editTextIngredients.getText().toString().trim();
        String allergens = editTextAllergens.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        Boolean isOffered = false;
        Double price;



        if(mealName.isEmpty()){
            editTextMealName.setError("Meal name is required!");
            editTextMealName.requestFocus();
            return;
        }

        if(mealType.isEmpty()){
            editTextMealType.setError("Meal type is required!");
            editTextMealType.requestFocus();
            return;
        }

        if(cuisineType.isEmpty()){
            editTextCuisineType.setError("Cuisine type is required!");
            editTextCuisineType.requestFocus();
            return;
        }

        if(ingredients.isEmpty()){
            editTextIngredients.setError("Ingredients are required!");
            editTextIngredients.requestFocus();
            return;
        }

        if(allergens.isEmpty()){
            editTextAllergens.setError("Allergens are required!");
            editTextAllergens.requestFocus();
            return;
        }

        try {
            price = Double.parseDouble(editTextMealName.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            editTextPrice.setError("Price must be a valid number.");
            editTextPrice.requestFocus();
        } catch (NullPointerException npe) {
            editTextPrice.setError("Price is required!");
            editTextPrice.requestFocus();
        }

        if(description.isEmpty()){
            editTextDescription.setError("Description is required!");
            editTextDescription.requestFocus();
            return;
        }

        if (chkYes.isChecked()) {
            isOffered = true;
        }

        /*
        Add meal to menu of the chef using firebase. I don't know how to do this.

        I think best way is to create new meal, and add that meal to the mealList in Menu.

        If (Chef has not created a menu yet) { Create Menu and Add Meal to Menu } else { Add Meal to Menu }
         */


    }




}