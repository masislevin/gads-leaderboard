package com.levin.gads.gads.leaderboard.utilities;

import android.util.Log;

import com.levin.gads.gads.leaderboard.models.SkillIQModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHelperSkillIQ {

    private static final String TAG = "JsonHelperSkillIQ";

    //
    private static final String NAME = "name";
    private static final String SCORE = "score";
    private static final String COUNTRY = "country";
    private static final String BADGE_URL = "badgeUrl";

    //
    private static final String LEARNERS = "learners";
    private static ArrayList<SkillIQModel> skillIQLearners;

    private JsonHelperSkillIQ() {
        skillIQLearners = new ArrayList<>();
    }

    public static ArrayList<SkillIQModel> getTopSKillIQLearners(){
        if(1 == 1){
            skillIQLearners = new ArrayList<>();
            SkillIQModel t1 = new SkillIQModel("Jane Doe",
                    200,
                    "Kenya",
                    "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
            SkillIQModel t2 = new SkillIQModel("John Doe",
                    300,
                    "Egypt",
                    "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
            skillIQLearners.add(t1);
            skillIQLearners.add(t2);
            return skillIQLearners;
        }

        try{
            String learners = ApiUtility.getLearnersJsonFromWeb(ApiUtility.getSkillIQUrl());

            JSONObject jsonLearners = new JSONObject(learners);
            JSONArray jsonArrayLearners = jsonLearners.getJSONArray(LEARNERS);
            int learnersCount = jsonArrayLearners.length();
            Log.d(TAG, "getTopSKillIQLearners: " + learnersCount + " top Skill IQ learners");

            for(int i = 0; i < learnersCount; i++){
                JSONObject learnerJSON = jsonArrayLearners.getJSONObject(i);
                SkillIQModel learner = new SkillIQModel(learnerJSON.getString(NAME),
                        learnerJSON.getInt(SCORE), learnerJSON.getString(COUNTRY),
                        learnerJSON.getString(BADGE_URL));

                skillIQLearners.add(learner);
            }
            return skillIQLearners ;
        } catch (Exception exception){
            Log.d(TAG, "getTopSKillIQLearners: " + exception.getStackTrace());
            return null;
        }
    }
}
