package com.amaliapps.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        SongAdapter songAdapter = new SongAdapter(this, MusicLibrary.getAllSongs());
        ListView songsListView = findViewById(R.id.songs_view);
        songsListView.setAdapter(songAdapter);
    }
}
