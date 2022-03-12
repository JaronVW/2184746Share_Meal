package com.example.a2184746shareameal.DataStorage;

import com.example.a2184746shareameal.Domain.DataModel;
import com.example.a2184746shareameal.Domain.Meal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    @GET("")
    Call<DataModel> getTestData();

    @GET("api/meal")
    Call<MealList> getMeals();

}
