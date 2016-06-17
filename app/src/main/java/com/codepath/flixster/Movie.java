package com.codepath.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kemleynieva on 6/15/16.
 */
public class Movie {


    public String getTitle() {
        return title;
    }

    //public String posterUrl;
    //public int rating;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdrop() {
        return String.format("https://image.tmdb.org/t/p/w780/%s",backdrop);
    }

    public String getOverview() {
        return overview;
    }

    public float getRating(){
        return rating;
    }

    String title;
    String posterPath;
    String overview;
    String backdrop;
    float rating;


    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdrop = jsonObject.getString("backdrop_path");
        this.rating = jsonObject.getInt("vote_average")/2;
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) throws JSONException {
        ArrayList<Movie> results = new ArrayList<>();

        for(int x =0; x<array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }


}
