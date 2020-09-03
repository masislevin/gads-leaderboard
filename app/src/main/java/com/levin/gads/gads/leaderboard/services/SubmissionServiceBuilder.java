package com.levin.gads.gads.leaderboard.services;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionServiceBuilder {
    private static final String TAG = "SubmissionServiceBuilder";

    private static final String BASE_API_URL = "https://docs.google.com/forms/d/e/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <TService> TService buildService(Class<TService> serviceType){
        Log.d(TAG, "SubmissionServiceBuilder creating services" );
        return retrofit.create(serviceType);
    }
}
