package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {


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

        if (songsIntent.getStringExtra(MainActivity.FILTER_TYPE_EXTRA) != null) {
            String filter = songsIntent.getStringExtra(MainActivity.FILTER_TYPE_EXTRA);
            String filterName = songsIntent.getStringExtra(MainActivity.FILTER_NAME_EXTRA);
            setActivityTitle(filter, filterName);
        } else {
            setTitle("All");
        }
    }

    private void setActivityTitle(String filter, String filterName) {
        String title = "";
        switch (filter) {
            case MainActivity.FILTER_ALBUM:
                title = "Songs in album " + filterName;
                break;
            case MainActivity.FILTER_ARTIST:
                title = "Songs by " + filterName;
                break;
            default:
                title = "All Songs";
        }
        setTitle(title);
    }
}