package com.example.cookingapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MenuDatabaseReader {
    private String userID;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<Meal> meals = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<Meal> meals, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public MenuDatabaseReader() {
        mDatabase = FirebaseDatabase.getInstance();
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mReference = mDatabase.getReference("Users").child(userID)
                .child("menu").child("mealList");
    }

    public void readMealList(final DataStatus dataStatus) {
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                meals.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Meal meal = keyNode.getValue(Meal.class);
                    meals.add(meal);
                }
                dataStatus.DataIsLoaded(meals, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void readOfferedMealsList(final DataStatus dataStatus) {
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                meals.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Meal meal = keyNode.getValue(Meal.class);
                    if (meal.isOffered) {
                        meals.add(meal);
                    }
                }
                dataStatus.DataIsLoaded(meals, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addMealToMenu(Meal meal, final DataStatus dataStatus) {
        String key = mReference.push().getKey();
        mReference.child(key).setValue(meal).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void deleteMealFromMenu(String key, final DataStatus dataStatus) {
        mReference.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsDeleted();
            }
        });
    }

    public void updateMeal(String key, Meal meal, final DataStatus dataStatus) {
        mReference.child(key).setValue(meal).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsUpdated();
            }
        });
    }

}
