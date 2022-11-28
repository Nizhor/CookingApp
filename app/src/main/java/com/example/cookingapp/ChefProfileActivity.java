package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ChefProfileActivity extends AppCompatActivity {
    private Button btnMenu;
    private Button btnMealsOffered;
    private Button btnAddMealToMenu;
    private Button btnRemoveMealFromMenu;
    private Button btnAddMealToOfferedMeals;
    private Button btnRemoveMealFromOfferedMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_profile);

        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenuActivity();
            }
        });

        btnMealsOffered = (Button) findViewById(R.id.btnMealsOffered);
        btnMealsOffered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMealsOfferedActivity();
            }
        });

        btnAddMealToMenu = (Button) findViewById(R.id.btnAddMealToMenu);
        btnAddMealToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMealToMenuActivity();
            }
        });

        btnAddMealToOfferedMeals = (Button) findViewById(R.id.btnAddMealToOfferedMeals);
        btnRemoveMealFromMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMealToOfferedMealsActivity();
            }
        });

        btnRemoveMealFromMenu = (Button) findViewById(R.id.btnRemoveMealFromMenu);
        btnRemoveMealFromMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemoveMealFromOfferedMealsActivity();
            }
        });

        btnRemoveMealFromOfferedMeals = (Button) findViewById(R.id.btnRemoveMealFromOfferedMeals);
        btnRemoveMealFromMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemoveMealFromOfferedMealsActivity();

            }
        });
    }

    public void openMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void openMealsOfferedActivity() {
        Intent intent = new Intent(this, MealsOfferedActivity.class);
        startActivity(intent);
    }

    public void openAddMealToMenuActivity() {
        Intent intent = new Intent(this, AddMealToMenuActivity.class);
        startActivity(intent);
    }

    public void openAddMealToOfferedMealsActivity() {
        Intent intent = new Intent(this, AddMealToOfferedMealsActivity.class);
        startActivity(intent);
    }

    public void openRemoveMealFromMenuActivity() {
        Intent intent = new Intent(this, RemoveMealFromMenuActivity.class);
        startActivity(intent);
    }

    public void openRemoveMealFromOfferedMealsActivity() {
        Intent intent = new Intent(this, RemoveMealFromOfferedMealsActivity.class);
        startActivity(intent);
    }


}