package com.example.a2184746shareameal.Presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;


import com.example.a2184746shareameal.Domain.Meal;
import com.example.a2184746shareameal.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Meal> list = new ArrayList<>();
        list.add(new Meal(1,"bruh","lorem ipsum",true,true,true,true,LocalDate.now() ,50,2.50,"f",new ArrayList<String>(),new ArrayList<String>()));
        list.add(new Meal(1,"F","lorem ipsum",true,true,true,true,LocalDate.now() ,50,2.50,"f",new ArrayList<String>(),new ArrayList<String>()));
        list.add(new Meal(1,"L","lorem ipsum",true,true,true,true,LocalDate.now() ,50,2.50,"f",new ArrayList<String>(),new ArrayList<String>()));
        list.add(new Meal(1,"lmao","lorem ipsum",true,true,true,true,LocalDate.now() ,50,2.50,"f",new ArrayList<String>(),new ArrayList<String>()));
        recyclerViewAdapter = new RecyclerViewAdapter(this,list);


        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}