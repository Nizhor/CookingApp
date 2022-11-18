package com.example.cookingapp;
import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

public class Menu {
    public static ArrayList<Meal> mealList;
    public static ArrayList<Meal> offeredMeals;

    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    String userID;

    public Menu() {

    }

    public Menu(ArrayList<Meal> mealList, ArrayList<Meal> offeredMeals) {
        this.mealList = mealList;
        this.offeredMeals = offeredMeals;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public ArrayList<Meal> getOfferedMeals() {
        return offeredMeals;
    }

    public void setOfferedMeals(ArrayList<Meal> offeredMeals) {
        this.offeredMeals = offeredMeals;
    }

    public static void addMealToMenu(Meal meal) {
        mealList.add(meal);
    }

    public void removeMealFromMenu(@NonNull Meal meal) {
        if (meal.isOffered) {
            //Tell user meal cannot be taken off because it is still offered
        } else if (meal.isOffered == false) {
            mealList.remove(meal);
        } else {
            mealList.remove(meal);
        }
    }

    public static void addMealToOfferedMeals(Meal meal) {
        offeredMeals.add(meal);
    }

    public static void removeMealFromOfferedMeals(Meal meal) {
        offeredMeals.remove(meal);
    }




}
