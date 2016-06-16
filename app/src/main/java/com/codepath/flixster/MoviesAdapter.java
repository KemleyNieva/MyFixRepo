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

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
    }

    public MoviesAdapter(Context context, List<Movie> movies){
        super(context, R.layout.item_movie,movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Movie movie = getItem(position);


            ViewHolder viewHolder;
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_movie, parent, false);
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
                viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
                convertView.setTag(viewHolder);

            }else {
            viewHolder = (ViewHolder) convertView.getTag();
            }


        // Lookup view for data population

            boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

            //takes out old
            if(isLandscape) {
                ImageView ivBackdrop = (ImageView) convertView.findViewById(R.id.ivBackdrop);
                ivBackdrop.setImageResource(0);
                String url = movie.getBackdrop();
                Picasso.with(getContext()).load(url).placeholder(R.drawable.user_placeholder).transform(new RoundedCornersTransformation(10,10)).into(ivBackdrop);

            } else {
                ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(0);
                Picasso.with(getContext()).load(movie.getPosterPath()).placeholder(R.drawable.user_placeholder).transform(new RoundedCornersTransformation(10,10)).into(ivPoster);
            }

            // Populate the data into the template view using the data object
            viewHolder.tvTitle.setText(movie.title);
            viewHolder.tvOverview.setText(movie.getOverview());



            // Return the completed view to render on screen
            return convertView;

    }
}
