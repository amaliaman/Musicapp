package com.amaliapps.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Artist> allArtists;
    private ArrayList<Song> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allArtists = initializeArtists();
        allSongs = initializeSongs();

        ArrayAdapter<Song> ad = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, allSongs);
        GridView gv = findViewById(R.id.all_songs);
    }

    /**
     * @return list of Artists to use in the app
     */
    private ArrayList<Artist> initializeArtists() {
        // create artists
        Artist bowie = new Artist("David Bowie", R.drawable.bowie);
        Artist blur = new Artist("Blur", 4);

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(bowie);
        artists.add(blur);

        return artists;
    }

    /**
     * @return list of Songs to use in the app
     */
    private ArrayList<Song> initializeSongs() {
        Song a = new Song("aaa", allArtists.get(0));

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(a);

        return songs;
    }
}
