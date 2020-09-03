package com.levin.gads.gads.leaderboard.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class TopLearnerModel {

    public TopLearnerModel(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    @SerializedName("name")
    public String name;
    @SerializedName("hours")
    public int hours;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String badgeUrl;

    @NonNull
    @Override
    public String toString() {
        return "Name : " + name + ", Hours : " + hours + ", Country : " + country + ". ";
    }
}
