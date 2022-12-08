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


}