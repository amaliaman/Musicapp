package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    public static final String NOW_PLAYING_EXTRA = "com.amaliapps.musicapp.NOW_PLAYING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // get Songs list from intent
        Intent songsIntent = getIntent();
        final ArrayList<Song> songs = songsIntent.getParcelableArrayListExtra(MainActivity.SONGS_EXTRA);

        SongAdapter songAdapter = new SongAdapter(this, songs);
        ListView songsListView = findViewById(R.id.songs_view);
        songsListView.setAdapter(songAdapter);
    }
}
