package com.levin.gads.gads.leaderboard.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderBoardServiceBuilder {
    private static final String TAG = "LeaderBoardServiceBuilder";
    private static final String BASE_API_URL = "https://gadsapi.herokuapp.com/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <TService> TService buildService(Class<TService> serviceType){
        return retrofit.create(serviceType);
    }
}
