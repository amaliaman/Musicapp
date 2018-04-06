package com.amaliapps.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    boolean isPlaying;

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

        final ImageView controlButton = findViewById(R.id.play_pause);
        controlButton.setImageResource(R.drawable.ic_pause);
        isPlaying = false;

        // show play or pause button
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    controlButton.setImageResource(R.drawable.ic_pause);
                    isPlaying = false;
                } else {
                    controlButton.setImageResource(R.drawable.ic_play);
                    isPlaying = true;
                }
            }
        });
    }
}
