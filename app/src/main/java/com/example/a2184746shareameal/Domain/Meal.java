package com.example.a2184746shareameal.Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meal {
    private final String name, description, imageURL;
    private final LocalDateTime dateTime;

    private final ArrayList<Ingredient> ingredientList;
    private final ArrayList<String> allergyInfoList;

    private final boolean isVegetarian, isVegan, isToTakeHome, isActive;

    private final int maxAmountParticipants;

    public Meal(String name, String description, String imageURL, LocalDateTime dateTime, ArrayList<Ingredient> ingredientList, ArrayList<String> allergyInfoList, boolean isVegetarian, boolean isVegan, boolean isToTakeHome, boolean isActive, int maxAmountParticipants) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.dateTime = dateTime;
        this.ingredientList = ingredientList;
        this.allergyInfoList = allergyInfoList;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isToTakeHome = isToTakeHome;
        this.isActive = isActive;
        this.maxAmountParticipants = maxAmountParticipants;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public ArrayList<String> getAllergyInfoList() {
        return allergyInfoList;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isToTakeHome() {
        return isToTakeHome;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getMaxAmountParticipants() {
        return maxAmountParticipants;
    }
}