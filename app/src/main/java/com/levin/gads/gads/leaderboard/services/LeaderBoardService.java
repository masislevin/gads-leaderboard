package com.levin.gads.gads.leaderboard.services;

import com.levin.gads.gads.leaderboard.models.SkillIQModel;
import com.levin.gads.gads.leaderboard.models.TopLearnerModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardService {
    String API_PART_HOURS = "api/hours";
    String API_PART_SKILL_IQ = "api/skilliq";

    @GET(API_PART_HOURS)
    Call<ArrayList<TopLearnerModel>> getTopLearners();

    @GET(API_PART_SKILL_IQ)
    Call<ArrayList<SkillIQModel>> getTopSkillIQImprovementLearners();
}
