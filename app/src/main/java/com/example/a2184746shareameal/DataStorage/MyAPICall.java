package com.example.a2184746shareameal.DataStorage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    @GET("/api/meal")
    Call<MealList> getMeals();

}
