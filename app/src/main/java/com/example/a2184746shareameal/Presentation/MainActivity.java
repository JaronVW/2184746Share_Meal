package com.example.a2184746shareameal.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2184746shareameal.Application.Formatters;
import com.example.a2184746shareameal.DataStorage.APIConnection;
import com.example.a2184746shareameal.DataStorage.MealList;
import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements APIConnection.MealListener, RecyclerViewAdapter.ViewHolder.onNoteListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private APIConnection apiConnection = null;
    private ArrayList<Meal> mealList = new ArrayList<>();
    private ArrayList<Meal> veganMealList = new ArrayList<>();
    private ArrayList<Meal> vegaMealList = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        this.apiConnection = new APIConnection("https://shareameal-api.herokuapp.com");
        this.apiConnection.getAPIData(this);



    }


    @Override
    public void getMeals(ArrayList<Meal> meals) {
        this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, meals,this);
        recyclerView.setAdapter(recyclerViewAdapter );

        CharSequence text = meals.size()+ " items";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        this.mealList = meals;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            ArrayList<Meal>[] filteredLists = Formatters.filterMeals(meals,veganMealList,veganMealList);
            veganMealList = filteredLists[0];
            vegaMealList = filteredLists[1];

        }

    }


    @Override
    public void onNoteClick(int position) {

        Intent intent = new Intent(this,MealDetailActivity.class);
        intent.putExtra("meal", (Serializable)  mealList.get(position));
        startActivity(intent);
    }
}