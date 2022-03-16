package com.example.a2184746shareameal.Presentation;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2184746shareameal.Application.Formatters;
import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private final ArrayList<Meal> MealList;
    private final LayoutInflater inflater;
    private final Context context;
    private final ViewHolder.onNoteListener onNoteListener;
    private final String TAG = getClass().getSimpleName();


    public RecyclerViewAdapter(Context context, ArrayList<Meal> mealList, ViewHolder.onNoteListener onNoteListener) {
        this.inflater = LayoutInflater.from(context);
        this.MealList = mealList;
        this.context = context;
        this.onNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_meal_row, parent, false);
        return new ViewHolder(itemView, this, this.onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.with(context).load(MealList.get(position).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.image);
        // Picasso, a package used to import online images to image resources

        holder.name.setText(MealList.get(position).getName());
        holder.date.setText(Formatters.cleanDate(MealList.get(position).getDateTime()));
        holder.city.setText(MealList.get(position).getCook().getCity());
        holder.price.setText("Price: €" + MealList.get(position).getPrice());
        // values bound to components
        Log.d(TAG,"values bound to components");
    }

    @Override
    public int getItemCount() {
        return MealList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // viewholder inner class

        private final ImageView image;
        private final TextView name, date, city, price;
        onNoteListener onNoteListener;
        private String TAG = getClass().getSimpleName();

        public ViewHolder(@NonNull View itemView, RecyclerViewAdapter mAdapter, onNoteListener onNoteListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            city = itemView.findViewById(R.id.city);
            price = itemView.findViewById(R.id.price);
            // assigns data in recyclerview to variables to pass content from object
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
            Log.d(TAG,"click method");
            // onclick listener method implemented using the interface
        }

        public interface onNoteListener {
            void onNoteClick(int position);
        }

    }


}
