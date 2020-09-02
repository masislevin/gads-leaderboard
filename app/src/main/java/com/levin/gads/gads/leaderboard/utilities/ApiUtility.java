package com.levin.gads.gads.leaderboard.utilities;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiUtility {
    private ApiUtility(){}

    private static final String TAG = "ApiUtility";

    public static final String BASE_API_URL = "https://gadsapi.herokuapp.com/";
    public static final String API_PART_HOURS = "api/hours";
    public static final String API_PART_SKILL_IQ = "api/skilliq";

    public static URL getHoursURL() {
        try{
            return new URL(BASE_API_URL + API_PART_HOURS);
        }catch (MalformedURLException exception) {
            Log.d(TAG, "getHoursURL: " + exception.getStackTrace());
            return null;
        }
    }

    public static URL getSkillIQUrl(){
        try{
            return new URL(BASE_API_URL + API_PART_SKILL_IQ);
        }catch (MalformedURLException exception) {
            Log.d(TAG, "getSkillIQUrl: " + exception.getStackTrace());
            return null;
        }
    }

    public static String getLearnersJsonFromWeb(URL url) throws IOException {
        String result = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Log.d(TAG, "getLearnersJsonFromWeb: Opened HTTP Url Connection ");

        try{
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream).useDelimiter("\\A");
            if(scanner.hasNext()){
                Log.d(TAG, "getLearnersJsonFromWeb: Scanner with data ");
                result = scanner.next();
            }

        }catch(Exception exception){
            Log.d(TAG, "getLearnersJsonFromWeb: " + exception.getStackTrace());
            return null;
        }finally {
            connection.disconnect();
            return result;
        }
    }
}
