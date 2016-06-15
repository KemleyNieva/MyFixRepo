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

    public String getOverview() {
        return overview;
    }

    String title;
    String posterPath;
    String overview;

    /*public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }*/
    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
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

    /*public static ArrayList<Movie> getFakeMovies(){
        ArrayList<Movie> movies = new ArrayList<>();

        for(int i =0; i < 60; i++) {
            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));
        }

        return movies;
    }*/

    /*@Override
    public String toString() {
        return title + " - " + rating;
    }   */
}
