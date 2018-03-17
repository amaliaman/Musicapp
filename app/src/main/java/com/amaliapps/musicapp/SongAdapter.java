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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView nameTextView = listItemView.findViewById(R.id.song_name);
        if (currentSong != null) {
            nameTextView.setText(currentSong.getSongName());
        }

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView numberTextView = listItemView.findViewById(R.id.artist_name);
        if (currentSong != null) {
            numberTextView.setText(currentSong.getArtist().getArtistName());
        }

        return listItemView;
    }
}
