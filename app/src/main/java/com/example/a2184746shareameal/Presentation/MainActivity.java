package com.example.a2184746shareameal.Presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2184746shareameal.DataStorage.APIConnection;
import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements APIConnection.MealListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


    }


    @Override
    public void OnMealAvailable(ArrayList<Meal> meals) {
        this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, meals);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}