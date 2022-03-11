package com.example.a2184746shareameal.DataStorage;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a2184746shareameal.Domain.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnection {
    private final String baseURL;

    private final MutableLiveData<String> data;

    public APIConnection(String baseURL) {
        this.baseURL = baseURL;
        data = new MutableLiveData<>();
    }

    public LiveData<String> getData() {
        return data;
    }

    public void getAPIData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyAPICall service = retrofit.create(MyAPICall.class);

        Call<DataModel> call = service.getTestData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call,Response<DataModel> response) {

                assert response.body() != null;

                if (response.isSuccessful()) {
                    StringBuilder j = new StringBuilder();
                    j.append("Title= ").append(response.body().getTitle());

                    data.postValue(j.toString());
                    Log.d("debug", j.toString());
                }
            }

            @Override
            public void onFailure(Call<DataModel> call,Throwable t) {
                Log.d("debug", "failed");
            }
        });

    }


}
