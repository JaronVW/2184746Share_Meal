package com.example.a2184746shareameal.DataStorage;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.a2184746shareameal.Domain.Meal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {

    private final MyAPICall service;
    public final String TAG = getClass().getSimpleName();

    public APIConnection(String baseURL) {

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

                Log.d(TAG, String.valueOf(response.code()));

                if (response.isSuccessful()) {
                    listener.OnMealAvailable(response.body().getResult());
                    Log.d("Debug", String.valueOf(response.body().getResult()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<MealList> call, @NonNull Throwable t) {
                Log.d("debug", t.toString());
            }
        });

    }

    public interface MealListener{
        public void OnMealAvailable(ArrayList<Meal> meals);

    }

}
