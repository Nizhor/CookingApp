package com.example.cookingapp;
import java.util.*;

public class Meal {
    public String name, mealType, cusineType, description;
    public ArrayList<String> ingredients, allergens;
    public Double price;
    public boolean isOffered;

    public Meal(){

    }

    public Meal(String name, String mealType, String cusineType, ArrayList<String> ingredients,
                ArrayList<String> allergens, Double price, String description, Boolean isOffered) {
        this.name = name;
        this.mealType = mealType;
        this.cusineType = cusineType;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.price = price;
        this.description = description;
        this.isOffered = isOffered;

    }

}
