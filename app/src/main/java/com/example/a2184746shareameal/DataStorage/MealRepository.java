package com.example.a2184746shareameal.DataStorage;

import android.location.GnssAntennaInfo;
import android.util.Log;

import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.Presentation.MainActivity;
import com.example.a2184746shareameal.Presentation.RecyclerViewAdapter;

import java.util.ArrayList;

public class MealRepository implements APIConnection.MealListener {
    private ArrayList<Meal> meals;
    private final APIConnection apiConnection;
    private final String TAG;


    public MealRepository() {
        apiConnection = new APIConnection("https://shareameal-api.herokuapp.com");
        TAG = getClass().getSimpleName();
        apiConnection.getAPIData(this);
    }

    @Override
    public ArrayList<Meal> OnMealAvailable(ArrayList<Meal> meals) {
        this.meals = meals;

        return meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }
}
