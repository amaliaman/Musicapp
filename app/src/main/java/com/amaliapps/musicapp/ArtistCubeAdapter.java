package com.amaliapps.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class ArtistCubeAdapter extends ArrayAdapter<Artist> {
    ArtistCubeAdapter(@NonNull Activity context, @NonNull ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_cube, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // set artist name in layout
        TextView nameTextView = listItemView.findViewById(R.id.artist_name);
        if (currentArtist != null) {
            nameTextView.setText(currentArtist.getArtistName());
        }

        // set artist image in layout
        ImageView artistArt = listItemView.findViewById(R.id.art);
        if (currentArtist != null) {
            artistArt.setImageResource(currentArtist.getArtistArt());
            artistArt.setContentDescription(currentArtist.getArtistName());
        }

        return listItemView;
    }
}
