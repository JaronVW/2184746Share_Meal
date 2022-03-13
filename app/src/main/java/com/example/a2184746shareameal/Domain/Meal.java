package com.example.a2184746shareameal.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meal implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isVega")
    @Expose
    private Boolean isVega;
    @SerializedName("isVegan")
    @Expose
    private Boolean isVegan;
    @SerializedName("isToTakeHome")
    @Expose
    private Boolean isToTakeHome;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("maxAmountOfParticipants")
    @Expose
    private Integer maxAmountOfParticipants;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("allergenes")
    @Expose
    private List<String> allergenes = null;
    @SerializedName("participants")
    @Expose
    private List<Person> participants = null;

    @SerializedName("city")
    @Expose
    private String city;



    /**
     *  @param id
     * @param name
     * @param description
     * @param isActive
     * @param isVega
     * @param isVegan
     * @param isToTakeHome
     * @param dateTime
     * @param maxAmountOfParticipants
     * @param price
     * @param imageUrl
     * @param allergenes
     * @param participants
     * @param city
     */
    public Meal(Integer id, String name, String description, Boolean isActive, Boolean isVega, Boolean isVegan, Boolean isToTakeHome, String dateTime, Integer maxAmountOfParticipants, Double price, String imageUrl, List<String> allergenes, List<Person> participants, String city) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.isVega = isVega;
        this.isVegan = isVegan;
        this.isToTakeHome = isToTakeHome;
        this.dateTime = dateTime;
        this.maxAmountOfParticipants = maxAmountOfParticipants;
        this.price = price;
        this.imageUrl = imageUrl;
        this.allergenes = allergenes;
        this.participants = participants;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    private void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVega() {
        return isVega;
    }

    private void setIsVega(Boolean isVega) {
        this.isVega = isVega;
    }

    public Boolean getIsVegan() {
        return isVegan;
    }

    private void setIsVegan(Boolean isVegan) {
        this.isVegan = isVegan;
    }

    public Boolean getIsToTakeHome() {
        return isToTakeHome;
    }

    private void setIsToTakeHome(Boolean isToTakeHome) {
        this.isToTakeHome = isToTakeHome;
    }

    public String getDateTime() {
        return dateTime;
    }



    public Integer getMaxAmountOfParticipants() {
        return maxAmountOfParticipants;
    }

    private void setMaxAmountOfParticipants(Integer maxAmountOfParticipants) {
        this.maxAmountOfParticipants = maxAmountOfParticipants;
    }

    public Double getPrice() {
        return price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getAllergenes() {
        return allergenes;
    }

    private void setAllergenes(List<String> allergenes) {
        this.allergenes = allergenes;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    private void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}