package com.levin.gads.gads.leaderboard.models;

public class TopLearnerModel {
    public String name;

    public TopLearnerModel(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public int hours;
    public String country;
    public String badgeUrl;
}
