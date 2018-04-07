package com.amaliapps.musicapp;

import android.app.Activity;
import android.content.Intent;
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

public class ArtistAdapter extends ArrayAdapter<Artist> {
    ArtistAdapter(@NonNull Activity context, @NonNull ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_item, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        final Artist currentArtist = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.artist_name);
        if (currentArtist != null) {
            nameTextView.setText(currentArtist.getArtistName());
        }

        // set artist image in layout
        ImageView art = listItemView.findViewById(R.id.art);
        if (currentArtist != null) {
            art.setImageResource(currentArtist.getArtistArt());
        }

        // set listener on songs button
        ImageView songsButton = listItemView.findViewById(R.id.songs);
        songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(view.getContext(), SongsActivity.class);
                songsIntent.putExtra(Extras.ARTISTS_EXTRA, currentArtist);
                view.getContext().startActivity(songsIntent);
            }
        });

        // set listener on albums button
        ImageView albumsButton = listItemView.findViewById(R.id.albums);
        albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(view.getContext(), AlbumsActivity.class);
                albumsIntent.putExtra(Extras.ARTISTS_EXTRA, currentArtist);
                view.getContext().startActivity(albumsIntent);
            }
        });

        return listItemView;
    }
}
