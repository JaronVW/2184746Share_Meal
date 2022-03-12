package com.example.a2184746shareameal.Presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private final ArrayList<Meal> MealList;
    private final LayoutInflater inflater;
    private final Context context;


    public RecyclerViewAdapter(Context context, ArrayList<Meal> mealList) {
        this.inflater = LayoutInflater.from(context);
        this.MealList = mealList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_meal_row, parent, false);
        return new MyViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.with(context).load(MealList.get(position).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.image);


//        holder.image.setImageResource(mealList.get(position).getImageUrl());
        holder.name.setText(MealList.get(position).getName());
        holder.date.setText(MealList.get(position).getDateTime().toString());
        holder.city.setText(MealList.get(position).getName());
        holder.price.setText(String.valueOf(MealList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return MealList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public final ImageView image;
        public TextView name;
        public TextView date;
        public final TextView city;
        public final TextView price;
        final RecyclerViewAdapter adapter;

        public MyViewHolder(@NonNull View itemView, RecyclerViewAdapter mAdapter) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            city = itemView.findViewById(R.id.city);
            price = itemView.findViewById(R.id.price);
            // assigns data in recyclerview to variables to pass content from object
            this.adapter = mAdapter;
        }
    }
}
