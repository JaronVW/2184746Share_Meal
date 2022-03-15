package com.example.a2184746shareameal.Application;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a2184746shareameal.Domain.Meal;

import java.util.ArrayList;

public class Formatters {

    public static String cleanDate(String d){
        String[] date = d.split("T");
        // cleans date retrieved from API
        return date[0];

    }

    public static String returnCheckmarkorX(boolean b){
        if(b){
            return "✔";
        }
        return "❌";
        // returns checkmarks and X
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<Meal>[] filterMeals(ArrayList<Meal> list, ArrayList<Meal> veganList, ArrayList<Meal> vegaList){
        for (Meal meal: list) {
            if(meal.getIsVegan()) {
                veganList.add(meal);
            }
            else if(meal.getIsVega()) {
                vegaList.add(meal);
            }
        }
        // filters list of meals and puts them in two araylists
        return new ArrayList[]{veganList, vegaList};
    }
}
