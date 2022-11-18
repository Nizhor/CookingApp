package com.example.cookingapp;
import androidx.annotation.NonNull;

import java.util.*;

public class Menu {
    public static ArrayList<Meal> mealList;
    public ArrayList<Meal> offeredMeals;

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

    public void addMealToMenu(Meal meal) {
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


}
