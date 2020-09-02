package com.levin.gads.gads.leaderboard.utilities;

import android.util.Log;

import com.levin.gads.gads.leaderboard.models.TopLearnerModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHelperTopLearner {
    private static final String TAG = "JsonHelperTopLearner";

    //
    private static final String NAME = "name";
    private static final String HOURS = "hours";
    private static final String COUNTRY = "country";
    private static final String BADGE_URL = "badgeUrl";

    //
    private static final String LEARNERS = "learners";
    private static ArrayList<TopLearnerModel> topLearners;

    private JsonHelperTopLearner() {
        topLearners = new ArrayList<>();
    }

    public static ArrayList<TopLearnerModel> getTopLearners()
    {
        if(1 == 1){
            topLearners = new ArrayList<>();
            TopLearnerModel t1 = new TopLearnerModel("John Doe",
                    200,
                    "Kenya",
                    "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
            TopLearnerModel t2 = new TopLearnerModel("Jane Doe",
                    300,
                    "Egypt",
                    "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
            topLearners.add(t1);
            topLearners.add(t2);
            return topLearners;
        }
        try{
            String learners = ApiUtility.getLearnersJsonFromWeb(ApiUtility.getHoursURL());

            JSONObject jsonLearners = new JSONObject(learners);
            JSONArray jsonArrayLearners = jsonLearners.getJSONArray(LEARNERS);
            int learnersCount = jsonArrayLearners.length();
            Log.d(TAG, "getTopLearners: " + learnersCount + " top learners");

            for(int i = 0; i < learnersCount; i++){
                JSONObject learnerJSON = jsonArrayLearners.getJSONObject(i);
                TopLearnerModel learner = new TopLearnerModel(learnerJSON.getString(NAME),
                        learnerJSON.getInt(HOURS), learnerJSON.getString(COUNTRY),
                        learnerJSON.getString(BADGE_URL));

                topLearners.add(learner);
            }
            return topLearners;
        }catch (Exception exception){
            Log.d(TAG, "getTopLearners: " + exception.getStackTrace());
            return null;
        }
    }
}