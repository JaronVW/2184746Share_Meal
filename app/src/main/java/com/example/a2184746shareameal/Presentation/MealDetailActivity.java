package com.example.a2184746shareameal.Presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2184746shareameal.Application.Formatters;
import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;
import com.squareup.picasso.Picasso;

public class MealDetailActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_meal_detail);

        if (getIntent().getExtras() != null) {
            Meal passedMeal = (Meal) getIntent().getSerializableExtra("meal");

            TextView mealName = findViewById(R.id.mealName);
            TextView description = findViewById(R.id.description);
            TextView mealPrice = findViewById(R.id.mealPrice);
            TextView isVega = findViewById(R.id.isVega);
            TextView isVegan = findViewById(R.id.isVegan);
            TextView cookName = findViewById(R.id.cookName);
            TextView mealCity = findViewById(R.id.mealCity);

            ImageView mealImage = findViewById(R.id.mealImage);
            Picasso.with(this)
                    .load(passedMeal.getImageUrl())
                    .into(mealImage);


            Log.d("debug", passedMeal.getName());

            mealName.setText(passedMeal.getName());
            description.setText(passedMeal.getDescription());
            mealPrice.setText("Price: €" + passedMeal.getPrice());
            isVega.setText("Vega " + Formatters.returnCheckmarkorX(passedMeal.getIsVega()));
            isVegan.setText("Vegan " + Formatters.returnCheckmarkorX(passedMeal.getIsVegan()));
            cookName.setText(passedMeal.getCook().getFirstName()+ " "+ passedMeal.getCook().getLastName());
            mealCity.setText(passedMeal.getCook().getCity());


        }


    }

}
