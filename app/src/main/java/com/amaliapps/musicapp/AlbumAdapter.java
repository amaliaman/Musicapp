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

        // Get the {@link Album} object located at this position in the list
        final Album currentAlbum = getItem(position);

        // set album name in layout
        TextView nameTextView = listItemView.findViewById(R.id.album_name);
        if (currentAlbum != null) {
            nameTextView.setText(currentAlbum.getName());
        }

        // set album image in layout
        ImageView art = listItemView.findViewById(R.id.art);
        if (currentAlbum != null) {
            art.setImageResource(currentAlbum.getAlbumArt());
        }

        return listItemView;
    }
}