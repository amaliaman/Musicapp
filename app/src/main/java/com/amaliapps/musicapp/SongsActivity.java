package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        // get intent
        Intent intent = getIntent();
        ArrayList<Song> songsList = new ArrayList<>();

        Album album = intent.getParcelableExtra(MainActivity.ALBUM_EXTRA);
        ArrayList<Song> songs = intent.getParcelableArrayListExtra(MainActivity.SONGS_EXTRA);

        // check if intent has album
        if (album != null) {
            setTitle(album.getName());
            songsList = album.getSongs();
            ImageView art = findViewById(R.id.art);
            art.setImageResource(album.getAlbumArt());
            art.setVisibility(View.VISIBLE);
        }
        // check if intent has songs list
        else if (songs != null) {
            setTitle(R.string.all_songs_label);
            songsList = songs;
        }

        SongAdapter songAdapter = new SongAdapter(this, songsList);
        ListView songsListView = findViewById(R.id.items_view);
        songsListView.setAdapter(songAdapter);
    }
}