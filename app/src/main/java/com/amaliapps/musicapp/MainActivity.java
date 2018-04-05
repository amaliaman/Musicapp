package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_ITEMS = 3;

    public static final String SONGS_EXTRA = "com.amaliapps.musicapp.SONGS";
    public static final String ARTISTS_EXTRA = "com.amaliapps.musicapp.ARTISTS";
    public static final String ALBUMS_EXTRA = "com.amaliapps.musicapp.ALBUMS";
    public static final String ALBUM_EXTRA = "com.amaliapps.musicapp.ALBUM";
    public static final String NOW_PLAYING_EXTRA = "com.amaliapps.musicapp.NOW_PLAYING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill the library with Songs, Artists and Albums
        initializeMusicLibrary();

        int max = 0;

        /*
            artists section
         */
        // display first 3 Artists
        ArrayList<Artist> firstArtists = MusicLibrary.getAllArtists();
        Collections.sort(firstArtists);
        max = MAX_ITEMS;
        if (firstArtists.size() < MAX_ITEMS) {
            max = firstArtists.size();
        }
        firstArtists = new ArrayList<>(firstArtists.subList(0, max));
        ArtistCubeAdapter artistCubeAdapter = new ArtistCubeAdapter(this, firstArtists);
        final GridView artistsGridView = findViewById(R.id.all_artists);
        artistsGridView.setAdapter(artistCubeAdapter);

        // set listener on artists grid item
        artistsGridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist artist = (Artist) artistsGridView.getItemAtPosition(position);
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putExtra(ARTISTS_EXTRA, artist);
                startActivity(albumsIntent);
            }
        });

        // set listener on all artists link
        ImageView allArtists = findViewById(R.id.all_artists_link);
        allArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra(ARTISTS_EXTRA, MusicLibrary.getAllArtists());
                startActivity(artistsIntent);
            }
        });

        /*
            albums section
         */
        // display first 3 Albums
        ArrayList<Album> firstAlbums = MusicLibrary.getAllAlbums();
        Collections.sort(firstAlbums);
        max = MAX_ITEMS;
        if (firstAlbums.size() < MAX_ITEMS) {
            max = firstAlbums.size();
        }
        firstAlbums = new ArrayList<>(firstAlbums.subList(0, max));
        AlbumCubeAdapter albumCubeAdapter = new AlbumCubeAdapter(this, firstAlbums);
        final GridView albumsGridView = findViewById(R.id.all_albums);
        albumsGridView.setAdapter(albumCubeAdapter);

        // set listener on albums grid item
        albumsGridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Album album = (Album) albumsGridView.getItemAtPosition(position);
                Intent albumsIntent = new Intent(MainActivity.this, SongsActivity.class);
                albumsIntent.putExtra(ALBUM_EXTRA, album);
                startActivity(albumsIntent);
            }
        });

        // set listener on all albums links
        ImageView allAlbums = findViewById(R.id.all_albums_link);
        allAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putParcelableArrayListExtra(ALBUMS_EXTRA, MusicLibrary.getAllAlbums());
                startActivity(albumsIntent);
            }
        });

        /*
            songs section
         */
        // display first 3 Songs
        ArrayList<Song> firstSongs = MusicLibrary.getAllSongs();
        Collections.sort(firstSongs);
        max = MAX_ITEMS;
        if (firstSongs.size() < MAX_ITEMS) {
            max = firstSongs.size();
        }
        firstSongs = new ArrayList<>(firstSongs.subList(0, max));
        SongCubeAdapter songCubeAdapter = new SongCubeAdapter(this, firstSongs);
        final GridView songsGridView = findViewById(R.id.all_songs);
        songsGridView.setAdapter(songCubeAdapter);

        // set listener on songs grid item
        songsGridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) songsGridView.getItemAtPosition(position);
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(NOW_PLAYING_EXTRA, song);
                startActivity(nowPlayingIntent);
            }
        });

        // set listener on all songs link
        ImageView allSongs = findViewById(R.id.all_songs_link);
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
     * to mimic real media on device
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
            leisureSongs.add(new Song(getString(R.string.leisure_song_1), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_2), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_3), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_4), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_5), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_6), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_7), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_8), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_9), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_10), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_11), blur));
            leisureSongs.add(new Song(getString(R.string.leisure_song_12), blur));
            Album leisure = new Album(getString(R.string.leisure_name), leisureSongs, R.drawable.leisure, blur);
            MusicLibrary.addAlbum(leisure);

            MusicLibrary.setIsInitialized(true);
        }
    }
}
