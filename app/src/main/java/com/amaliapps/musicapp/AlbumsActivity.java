package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        // get Albums list from intent
        Intent intent = getIntent();

        ArrayList<Album> albums = new ArrayList<>();
        Artist artist = intent.getParcelableExtra(MainActivity.ARTISTS_EXTRA);

        ImageView artImageView = findViewById(R.id.art);
        // check if intent has artist
        if (artist != null) {
            setTitle("Albums by " + artist.getArtistName());
            albums = MusicLibrary.getAlbumsByArtist(artist);
            artImageView.setImageResource(artist.getArtistArt());
            artImageView.setVisibility(View.VISIBLE);
        } else {
            setTitle(R.string.all_albums_label);
            albums = intent.getParcelableArrayListExtra(MainActivity.ALBUMS_EXTRA);
        }

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        ListView albumsListView = findViewById(R.id.items_view);
        albumsListView.setAdapter(albumAdapter);

    }
}
