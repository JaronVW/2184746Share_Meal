package com.example.a2184746shareameal.DataStorage;

import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.Presentation.MainActivity;
import com.example.a2184746shareameal.Presentation.RecyclerViewAdapter;

import java.util.ArrayList;

public class MealRepository implements APIConnection.MealListener {
    private ArrayList<Meal> meals;

    public MealRepository() {
//        this.meals = OnMealAvailable();
    }

    @Override
    public ArrayList<Meal> OnMealAvailable(ArrayList<Meal> meals) {
        this.meals = meals;
        return this.meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }
}
