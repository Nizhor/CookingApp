package com.example.cookingapp;
import java.util.*;

public class Meal {
    public String mealName, mealType, cusineType, description;
    public ArrayList<String> ingredients, allergens;
    public Double price;
    public boolean isOffered;

    public Meal(){

    }

    public Meal(String mealName, String mealType, String cusineType, ArrayList<String> ingredients,
                ArrayList<String> allergens, Double price, String description, Boolean isOffered) {
        this.mealName = mealName;
        this.mealType = mealType;
        this.cusineType = cusineType;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.price = price;
        this.description = description;
        this.isOffered = isOffered;

    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getCusineType() {
        return cusineType;
    }

    public void setCusineType(String cusineType) {
        this.cusineType = cusineType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(ArrayList<String> allergens) {
        this.allergens = allergens;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }
}
