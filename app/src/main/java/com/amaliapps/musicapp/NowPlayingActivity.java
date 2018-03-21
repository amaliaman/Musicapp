package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // get song details from intent
        Intent intent = getIntent();
        Song currentSong = getIntent().getParcelableExtra(SongsActivity.NOW_PLAYING_EXTRA);
        TextView songName = findViewById(R.id.song_name);
        songName.setText(currentSong.getSongName());
    }
}
