package com.levin.gads.gads.leaderboard.models;

import com.google.gson.annotations.SerializedName;

public class SubmissionModel{
    @SerializedName("entry.1877115667")
    public String firstName;
    @SerializedName("entry.2006916086")
    public String lastName;
    @SerializedName("entry.1824927963")
    public String email;
    @SerializedName("entry.284483984")
    public String projectUrl;

    public SubmissionModel(String firstName, String lastName, String email, String projectUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projectUrl = projectUrl;
    }

    @Override
    public String toString() {
        return "SubmissionModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", projectUrl='" + projectUrl + '\'' +
                '}';
    }
}
