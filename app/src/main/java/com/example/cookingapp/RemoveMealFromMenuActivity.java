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

public class RemoveMealFromMenuActivity extends AppCompatActivity {
    String unwantedMeal;

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
        setContentView(R.layout.activity_remove_meal_from_menu);

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
                unwantedMeal = mealInput.getText().toString().trim();


                Menu menu = Chef.menu;
                ArrayList<Meal> allMeals = (ArrayList) menu.mealList.clone();

                for (int i = 0; i < (allMeals.size() - 1);i++) {
                    Meal meal = allMeals.get(i);
                    if (meal.mealName.toLowerCase() == unwantedMeal.toLowerCase()) {
                        if (meal.isOffered) {
                            mealInput.setError("Cannot delete a meal that is currently offered!");
                            mealInput.requestFocus();
                        } else {
                            menu.removeMealFromMenu(meal);
                            showToast(unwantedMeal + " has been removed from the menu.");
                        }
                    }
                }

                myRef.child("Users").child(userID).child("Menu").setValue(Chef.menu);
            }
        });;
    }

    public void showToast(String toast) {
        Toast.makeText(RemoveMealFromMenuActivity.this, toast, Toast.LENGTH_LONG).show();
    }
}