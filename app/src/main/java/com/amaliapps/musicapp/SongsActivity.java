package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        final Album album = intent.getParcelableExtra(Extras.ALBUM_EXTRA);
        ArrayList<Song> songs = intent.getParcelableArrayListExtra(Extras.SONGS_EXTRA);
        Artist artist = intent.getParcelableExtra(Extras.ARTISTS_EXTRA);

        ImageView artImageView = findViewById(R.id.art);
        // check if intent has album
        if (album != null) {
            setTitle(album.getName());
            songsList = album.getSongs();
            artImageView.setImageResource(album.getAlbumArt());
            artImageView.setVisibility(View.VISIBLE);
            LinearLayout header = findViewById(R.id.header);
            header.setBackgroundColor(getResources().getColor(R.color.albums));
        }
        // check if intent has songs list
        else if (songs != null) {
            setTitle(R.string.all_songs_label);
            songsList = songs;
        }
        // check if intent has artist
        else if (artist != null) {
            setTitle(String.format(getString(R.string.songs_by), artist.getArtistName()));
            songsList = MusicLibrary.getSongsByArtist(artist);
            artImageView.setImageResource(artist.getArtistArt());
            artImageView.setVisibility(View.VISIBLE);
            LinearLayout header = findViewById(R.id.header);
            header.setBackgroundColor(getResources().getColor(R.color.artists));
        }

        SongAdapter songAdapter = new SongAdapter(this, songsList);
        final ListView songsListView = findViewById(R.id.items_view);
        songsListView.setAdapter(songAdapter);

        // set listener on song item in list
        songsListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) songsListView.getItemAtPosition(position);
                Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                nowPlayingIntent.putExtra(Extras.NOW_PLAYING_EXTRA, song);
                startActivity(nowPlayingIntent);
            }
        });
    }
}