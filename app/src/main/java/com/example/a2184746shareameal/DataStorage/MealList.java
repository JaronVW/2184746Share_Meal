package com.example.a2184746shareameal.DataStorage;

import java.util.ArrayList;

import com.example.a2184746shareameal.Domain.Meal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealList {

    @SerializedName("result")
    @Expose
    private ArrayList<Meal> result;

    public ArrayList<Meal> getResult() {
        return result;
    }
}
