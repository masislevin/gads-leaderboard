package com.levin.gads.gads.leaderboard.models;

public class SkillIQModel {
    public SkillIQModel(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String name;
    public int score;
    public String country;
    public String badgeUrl;
}
