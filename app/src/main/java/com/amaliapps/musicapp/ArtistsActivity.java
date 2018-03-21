package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // get Artists list from intent
        Intent intent = getIntent();
        final ArrayList<Artist> artists = intent.getParcelableArrayListExtra(MainActivity.ARTISTS_EXTRA);

        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);
        ListView artistsListView = findViewById(R.id.artists_view);
        artistsListView.setAdapter(artistAdapter);

//        artistsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent songsIntent = new Intent(ArtistsActivity.this, SongsActivity.class);
//                songsIntent.putExtra(MainActivity.SONGS_EXTRA, MusicLibrary.getSongsByArtist(artists.get(position)));
//                startActivity(songsIntent);
//            }
//        });
    }
}
