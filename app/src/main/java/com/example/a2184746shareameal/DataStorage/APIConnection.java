package com.example.a2184746shareameal.DataStorage;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.a2184746shareameal.Domain.Meal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {

    private final String baseURL;
    private MyAPICall service;

    public APIConnection(String baseURL) {
        this.baseURL = baseURL;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.service = retrofit.create(MyAPICall.class);
    }


    public void getAPIData(MealListener listener) {



        Call<MealList> call = service.getMeals();
        call.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                assert response.body() != null;
                if (response.isSuccessful()) {
                    listener.OnMealAvailable(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {
                Log.d("debug", "failed");
            }
        });

    }

    public interface MealListener{
        public ArrayList<Meal> OnMealAvailable(ArrayList<Meal> meals);

    }

}
