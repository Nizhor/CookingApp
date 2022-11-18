package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddMealToOfferedMealsActivity extends AppCompatActivity {
    String wantedMeal;

    EditText mealInput;
    Button submit;

    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_to_offered_meals);

        mealInput = (EditText) findViewById(R.id.editMeal);

        submit = (Button) findViewById(R.id.btnSubmit);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wantedMeal = mealInput.getText().toString().trim();


                Menu menu = Chef.menu;
                ArrayList<Meal> allMeals = (ArrayList) menu.mealList.clone();

                for (int i = 0; i < (allMeals.size() - 1);i++) {
                    Meal meal = allMeals.get(i);
                    if (meal.mealName.toLowerCase() == wantedMeal.toLowerCase()) {
                        if (meal.isOffered == false) {
                            meal.isOffered = true;
                            showToast(wantedMeal + " has been added to the offered items list.");
                        } else {
                            showToast(wantedMeal + " is already not being offered.");
                        }
                    }
                }

                myRef.child("Users").child(userID).child("Menu").setValue(Chef.menu);
            }
        });;
    }

    public void showToast(String toast) {
        Toast.makeText(AddMealToOfferedMealsActivity.this, toast, Toast.LENGTH_LONG).show();
    }
}