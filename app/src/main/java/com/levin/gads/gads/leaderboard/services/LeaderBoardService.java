package com.levin.gads.gads.leaderboard.services;

import com.levin.gads.gads.leaderboard.models.SkillIQModel;
import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.models.TopLearnerModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeaderBoardService {
    String API_PART_HOURS = "api/hours";
    String API_PART_SKILL_IQ = "api/skilliq";
    String SUBMISSION_PART_FORM_ID =
            "1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

    @GET(API_PART_HOURS)
    Call<ArrayList<TopLearnerModel>> getTopLearners();

    @GET(API_PART_SKILL_IQ)
    Call<ArrayList<SkillIQModel>> getTopSkillIQImprovementLearners();

    @POST(SUBMISSION_PART_FORM_ID)
    Call<SubmissionModel> submitProject(@Body SubmissionModel model);
}
