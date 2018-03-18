package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_ITEMS = 3;
    public static final String SONGS_EXTRA = "com.amaliapps.musicapp.SONGS";
    public static final String ARTISTS_EXTRA = "com.amaliapps.musicapp.ARTISTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill the library with Songs, Artists and Albums
        initializeMusicLibrary();

        // get first 3 Songs
        ArrayList<Song> firstSongs = MusicLibrary.getAllSongs();
        Collections.sort(firstSongs);
        firstSongs = new ArrayList<>(firstSongs.subList(0, MAX_ITEMS));
        SongCubeAdapter songCubeAdapter = new SongCubeAdapter(this, firstSongs);
        GridView songsGridView = findViewById(R.id.all_songs);
        songsGridView.setAdapter(songCubeAdapter);

        // get first 3 Artists
        ArrayList<Artist> firstArtists = MusicLibrary.getAllArtists();
        Collections.sort(firstArtists);
        int max = MAX_ITEMS;
        if (firstArtists.size() < MAX_ITEMS) {
            max = firstArtists.size();
        }
        firstArtists = new ArrayList<>(firstArtists.subList(0, max));
        ArtistCubeAdapter artistCubeAdapter = new ArtistCubeAdapter(this, firstArtists);
        GridView artistsGridView = findViewById(R.id.all_artists);
        artistsGridView.setAdapter(artistCubeAdapter);

        // set listeners
        TextView allArtists = findViewById(R.id.all_artists_link);
        allArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra(ARTISTS_EXTRA, MusicLibrary.getAllArtists());
                startActivity(artistsIntent);
            }
        });

        TextView allSongs = findViewById(R.id.all_songs_link);
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putParcelableArrayListExtra(SONGS_EXTRA, MusicLibrary.getAllSongs());
                startActivity(songsIntent);
            }
        });
    }

    /**
     * fill the library with Songs, Artists and Albums
     */
    private void initializeMusicLibrary() {
        if (!MusicLibrary.isInitialized()) {
            // create Artists
            Artist bowie = new Artist(getString(R.string.bowie_name), R.drawable.bowie);
            Artist blur = new Artist(getString(R.string.blur_name), R.drawable.blur);

            // create Songs & Albums
            ArrayList<Song> lowSongs = new ArrayList<>();
            lowSongs.add(new Song(getString(R.string.low_song_1), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_2), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_3), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_4), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_5), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_6), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_7), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_8), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_9), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_10), bowie));
            lowSongs.add(new Song(getString(R.string.low_song_11), bowie));
            Album low = new Album(getString(R.string.low_name), lowSongs, R.drawable.low, bowie);
            MusicLibrary.addAlbum(low);


            ArrayList<Song> leisureSongs = new ArrayList<>();
            leisureSongs.add(new Song("sasdfsdfs", blur));
            Album leisure = new Album("Leisure", leisureSongs, R.drawable.leisure, blur);
            MusicLibrary.addAlbum(leisure);


            MusicLibrary.setIsInitialized(true);
        }
    }
}
