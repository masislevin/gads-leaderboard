package com.levin.gads.gads.leaderboard.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


public class SkillIQModel {
    public SkillIQModel(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;

    }

    @SerializedName("name")
    public String name;
    @SerializedName("score")
    public int score;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String badgeUrl;

    @NonNull
    @Override
    public String toString() {
        return "Name : " + name + ", Score : " + score + ", Country : " + country + ". ";
    }
}
