package com.example.cookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddMealToMenuActivity extends AppCompatActivity {
    private EditText editTextMealName, editTextMealType, editTextCuisineType, editTextIngredients,
            editTextAllergens, editTextDescription, editTextPrice;
    private CheckBox chkYes, chkNo;
    private ProgressBar progressBar;
    private Button btnAddMeal;

    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    String userID;

    private Menu menu;

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

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("Users");
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnAddMeal = (Button) findViewById(R.id.btnAddMeal);

        btnAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeal();
            }
        });
    }


    public void addMeal() {
        String mealName = editTextMealName.getText().toString().trim();
        String mealType = editTextMealType.getText().toString().trim();
        String cuisineType = editTextCuisineType.getText().toString().trim();
        String ingredients = editTextIngredients.getText().toString().trim();
        String allergens = editTextAllergens.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        Boolean isOffered = false;
        Double price = -1.0;



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
            price = Double.parseDouble(editTextPrice.getText().toString().trim());
        } catch (NumberFormatException nfe) {
            editTextPrice.setError("Price must be a valid number.");
            editTextPrice.requestFocus();
            return;
        } catch (NullPointerException npe) {
            editTextPrice.setError("Price is required!");
            editTextPrice.requestFocus();
            return;
        }
            /*
            try {
                price = Double.parseDouble(editTextMealName.getText().toString().trim());
            } catch (NumberFormatException nfe) {
                editTextPrice.setError("Price must be a valid number.");
                editTextPrice.requestFocus();
            } catch (NullPointerException npe) {
                editTextPrice.setError("Price is required!");
                editTextPrice.requestFocus();
            }

             */


        if(description.isEmpty()){
            editTextDescription.setError("Description is required!");
            editTextDescription.requestFocus();
            return;
        }

        if (chkYes.isChecked()) {
            isOffered = true;
        }

        progressBar.setVisibility(View.VISIBLE);

        Meal mealAdded = new Meal(mealName, mealType, cuisineType, ingredients, allergens,
                price, description, isOffered);

        new MenuDatabaseReader().addMealToMenu(mealAdded, new MenuDatabaseReader.DataStatus() {
            @Override
            public void DataIsLoaded(List<Meal> meals, List<String> keys) {

            }

            @Override
            public void DataIsInserted() {
                Toast.makeText(AddMealToMenuActivity.this, "Meal has been added succesfully!", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
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