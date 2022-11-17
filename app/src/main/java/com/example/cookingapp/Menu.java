package com.example.cookingapp;
import java.util.*;

public class Menu {
    public ArrayList<Meal> mealList;
    public ArrayList<Meal> offeredMeals;

    public Menu() {

    }

    public Menu(ArrayList<Meal> mealList, ArrayList<Meal> offeredMeals) {
        this.mealList = mealList;
        this.offeredMeals = offeredMeals;

    }

    public void addMealToMenu(Meal meal) {
        mealList.add(meal);
    }

    public void removeMealFromMenu(Meal meal) {
        if (meal.isOffered) {
            //Tell user meal cannot be taken off because it is still offered
        } else if (meal.isOffered == false) {
            mealList.remove(meal);
        } else {
            mealList.remove(meal);
        }


    }


}
