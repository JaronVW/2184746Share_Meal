package com.example.a2184746shareameal.Presentation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2184746shareameal.Application.Formatters;
import com.example.a2184746shareameal.DataStorage.APIConnection;
import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements APIConnection.MealListener, RecyclerViewAdapter.ViewHolder.onNoteListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private APIConnection apiConnection = null;
    private ArrayList<Meal> mealList = new ArrayList<>();
    private ArrayList<Meal> veganMealList = new ArrayList<>();
    private ArrayList<Meal> vegaMealList = new ArrayList<>();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String TAG = getClass().getSimpleName();




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        this.apiConnection = new APIConnection("https://shareameal-api.herokuapp.com");
        this.apiConnection.getAPIData(this);

        Log.d(TAG,"APIConnection succeded");

    }


    @Override
    public void getMeals(ArrayList<Meal> meals) {

        this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, meals, this);
        recyclerView.setAdapter(recyclerViewAdapter);

        CharSequence text = meals.size() + " items";
        Log.d(TAG,text.toString());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        this.mealList = meals;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            ArrayList<Meal>[] filteredLists = Formatters.filterMeals(meals, veganMealList, veganMealList);
            veganMealList = filteredLists[0];
            vegaMealList = filteredLists[1];

        }

    }

    @Override
    public void onNoteClick(int position) {

        Intent intent = new Intent(this, MealDetailActivity.class);
        intent.putExtra("meal", (Serializable) mealList.get(position));
        startActivity(intent);
    }

    public void newRecyclerView(View view) {
        radioGroup = findViewById(R.id.radioGroup);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);

        try {

            CharSequence text;
            int duration;
            Toast toast;
            switch (String.valueOf(radioButton.getText())) {
                // checks the value of radiogroup to change recyclerview data
                case "vegan":

                    this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, veganMealList, this);
                    recyclerView.setAdapter(recyclerViewAdapter);

                    text = veganMealList.size() + " items";
                    Log.d(TAG,text.toString());
                    duration = Toast.LENGTH_SHORT;
                    toast = Toast.makeText(this, text, duration);
                    toast.show();

                    break;
                case "vega":

                    this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, vegaMealList, this);
                    recyclerView.setAdapter(recyclerViewAdapter);

                    text = vegaMealList.size() + " items";
                    Log.d(TAG,text.toString());
                    duration = Toast.LENGTH_SHORT;
                    toast = Toast.makeText(this, text, duration);
                    toast.show();

                    break;
                case "all":

                    this.recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, mealList, this);
                    recyclerView.setAdapter(recyclerViewAdapter);

                    text = mealList.size() + " items";
                    Log.d(TAG,text.toString());
                    duration = Toast.LENGTH_SHORT;
                    toast = Toast.makeText(this, text, duration);
                    toast.show();

                    break;
                default:
                    break;
            }
        } catch (NullPointerException nullPointerException) {
            CharSequence text = "please select a filter first";
            Log.d(TAG,text.toString());
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }


}