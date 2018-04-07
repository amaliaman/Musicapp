package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GridView.OnItemClickListener {

    private static final int MAX_ITEMS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill the library with Songs, Artists and Albums
        initializeMusicLibrary();

        int max;

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
        GridView artistsGridView = findViewById(R.id.all_artists);
        artistsGridView.setAdapter(artistCubeAdapter);

        // set listener on artists grid item
        artistsGridView.setOnItemClickListener(this);

        // set listener on all artists link
        ImageView allArtists = findViewById(R.id.all_artists_link);
        allArtists.setOnClickListener(this);

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
        albumsGridView.setOnItemClickListener(this);

        // set listener on all albums links
        ImageView allAlbums = findViewById(R.id.all_albums_link);
        allAlbums.setOnClickListener(this);

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
        songsGridView.setOnItemClickListener(this);

        // set listener on all songs link
        ImageView allSongs = findViewById(R.id.all_songs_link);
        allSongs.setOnClickListener(this);
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
            Artist bauhaus = new Artist(getString(R.string.bauhaus_name), R.drawable.bauhaus);

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

            ArrayList<Song> diamondDogsSongs = new ArrayList<>();
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_1), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_2), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_3), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_4), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_5), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_6), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_7), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_8), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_9), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_10), bowie));
            diamondDogsSongs.add(new Song(getString(R.string.diamond_dogs_song_11), bowie));
            Album diamondDogs = new Album(getString(R.string.diamond_dogs_name), diamondDogsSongs, R.drawable.diamond_dogs, bowie);
            MusicLibrary.addAlbum(diamondDogs);

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

            ArrayList<Song> maskSongs = new ArrayList<>();
            maskSongs.add(new Song(getString(R.string.mask_song_1), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_2), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_3), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_4), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_5), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_6), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_7), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_8), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_9), bauhaus));
            maskSongs.add(new Song(getString(R.string.mask_song_10), bauhaus));
            Album mask = new Album(getString(R.string.mask_name), maskSongs, R.drawable.mask, bauhaus);
            MusicLibrary.addAlbum(mask);

            MusicLibrary.setIsInitialized(true);
        }
    }

    /**
     * @param menu options menu
     * @return true
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    /**
     * Handle menu options
     *
     * @param item menu item
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.photo_credit_option:
                Toast.makeText(this, R.string.photo_credit_body, Toast.LENGTH_LONG).show();
                return true;
            case R.id.icons_credit_option:
                Toast.makeText(this, R.string.icons_credit_body, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        // Perform action on click
        switch (view.getId()) {
            case R.id.all_artists_link:
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra(Extras.ARTISTS_EXTRA, MusicLibrary.getAllArtists());
                startActivity(artistsIntent);
                break;
            case R.id.all_albums_link:
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putParcelableArrayListExtra(Extras.ALBUMS_EXTRA, MusicLibrary.getAllAlbums());
                startActivity(albumsIntent);
                break;
            case R.id.all_songs_link:
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putParcelableArrayListExtra(Extras.SONGS_EXTRA, MusicLibrary.getAllSongs());
                startActivity(songsIntent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.all_artists:
                Artist artist = (Artist) parent.getItemAtPosition(position);
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putExtra(Extras.ARTISTS_EXTRA, artist);
                startActivity(albumsIntent);
                break;
            case R.id.all_albums:
                Album album = (Album) parent.getItemAtPosition(position);
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putExtra(Extras.ALBUM_EXTRA, album);
                startActivity(songsIntent);
                break;
            case R.id.all_songs:
                Song song = (Song) parent.getItemAtPosition(position);
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(Extras.NOW_PLAYING_EXTRA, song);
                startActivity(nowPlayingIntent);
                break;
        }
    }
}
