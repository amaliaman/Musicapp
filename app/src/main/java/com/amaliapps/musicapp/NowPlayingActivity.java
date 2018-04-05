package com.amaliapps.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // get song details from intent
        Song currentSong = getIntent().getParcelableExtra(MainActivity.NOW_PLAYING_EXTRA);

        TextView songName = findViewById(R.id.song_name);
        songName.setText(currentSong.getSongName());

        TextView artist = findViewById(R.id.artist_name);
        artist.setText(currentSong.getArtist().getArtistName());


    }
}
