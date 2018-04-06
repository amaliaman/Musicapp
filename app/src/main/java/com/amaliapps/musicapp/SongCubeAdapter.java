package com.amaliapps.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class SongCubeAdapter extends ArrayAdapter<Song> {
    SongCubeAdapter(@NonNull Activity context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_cube, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        // set the song name in the layout
        TextView nameTextView = listItemView.findViewById(R.id.song_name);
        if (currentSong != null) {
            nameTextView.setText(currentSong.getSongName());
        }

        // set the artist name in the layout
        TextView numberTextView = listItemView.findViewById(R.id.artist_name);
        if (currentSong != null) {
            numberTextView.setText(currentSong.getArtist().getArtistName());
        }

        return listItemView;
    }
}
