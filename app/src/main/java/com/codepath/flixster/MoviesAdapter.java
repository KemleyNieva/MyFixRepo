package com.codepath.flixster;

/**
 * Created by kemleynieva on 6/15/16.
 */

import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends ArrayAdapter<Movie> {


    public MoviesAdapter(Context context, List<Movie> movies){
        super(context, R.layout.item_movie,movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Movie movie = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            }

            // Lookup view for data population
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

            //ImageView ivBackdrop = (ImageView) convertView.findViewById(R.id.ivBackdrop);
            //ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);

            boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

            //takes out old
            if(isLandscape) {
                ImageView ivBackdrop = (ImageView) convertView.findViewById(R.id.ivBackdrop);
                ivBackdrop.setImageResource(0);
                String url = movie.getBackdrop();
                Picasso.with(getContext()).load(url).into(ivBackdrop);

            } else {
                ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(0);
                Picasso.with(getContext()).load(movie.getPosterPath()).into(ivPoster);
            }

            // Populate the data into the template view using the data object
            tvTitle.setText(movie.title);
            tvOverview.setText(movie.getOverview());

            /*Log.d("MoviesAdapter","Position: " + position);

            String imageUri = "https://i.imgur.com/tGbaZCY.jpg";*/
            //Picasso.with(getContext()).load(movie.getBackdrop()).into(ivBackdrop);
            //Picasso.with(getContext()).load(movie.getPosterPath()).into(ivPoster);

            // Return the completed view to render on screen
            return convertView;

    }
}
