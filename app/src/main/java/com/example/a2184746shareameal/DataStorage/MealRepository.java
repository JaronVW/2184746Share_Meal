package com.example.a2184746shareameal.DataStorage;

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

    }

    public ArrayList<Meal> getMeals() {

        apiConnection.getAPIData(this);
        Log.d(TAG,meals.get(0).getName());
        return meals;
    }

    @Override
    public void OnMealAvailable(ArrayList<Meal> meals) {
        this.meals = meals;
    }


}
