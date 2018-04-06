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

public class SongAdapter extends ArrayAdapter<Song> {
    SongAdapter(@NonNull Activity context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        // set song name in layout
        TextView nameTextView = listItemView.findViewById(R.id.song_name);
        if (currentSong != null) {
            nameTextView.setText(currentSong.getSongName());
        }

        // set artist name in layout
        TextView numberTextView = listItemView.findViewById(R.id.artist_name);
        if (currentSong != null) {
            numberTextView.setText(currentSong.getArtist().getArtistName());
        }

        return listItemView;
    }
}
