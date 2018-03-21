package com.amaliapps.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {
    AlbumAdapter(@NonNull Activity context, @NonNull ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Album currentAlbum = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView nameTextView = listItemView.findViewById(R.id.album_name);
        if (currentAlbum != null) {
            nameTextView.setText(currentAlbum.getName());
        }
//
        Button b = listItemView.findViewById(R.id.songs);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(view.getContext(), SongsActivity.class);
                songsIntent.putExtra(MainActivity.SONGS_EXTRA, currentAlbum != null ? currentAlbum.getSongs() : null);
                view.getContext().startActivity(songsIntent);
            }
        });

        return listItemView;
    }
}
