package com.example.cookingapp;

import static org.junit.Assert.assertEquals;

import com.google.firebase.auth.FirebaseUser;

import org.junit.Test;

public class MealTest {
    @Test
    public void checkMealName() {
        Meal aMeal = new Meal("ravioli", "pasta", "italian", "tomato sauce",
                "none", 10.0, "tasty pasta", true);
        assertEquals("ravioli", aMeal.getMealName());
    }

    @Test
    public void checkMealType() {
        Meal aMeal = new Meal("ravioli", "pasta", "italian", "tomato sauce",
                "none", 10.0, "tasty pasta", true);
        assertEquals("pasta", aMeal.getMealType());
    }

    @Test
    public void checkCuisineType() {
        Meal aMeal = new Meal("ravioli", "pasta", "italian", "tomato sauce",
                "none", 10.0, "tasty pasta", true);
        assertEquals("italian", aMeal.getCusineType());
    }

    @Test
    public void checkIngredients() {
        Meal aMeal = new Meal("ravioli", "pasta", "italian", "tomato sauce",
                "none", 10.0, "tasty pasta", true);
        assertEquals("tomato sauce", aMeal.getIngredients());
    }

}