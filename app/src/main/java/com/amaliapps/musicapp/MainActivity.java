package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private final static int MAX_ITEMS = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill the library with Songs, Artists and Albums
        initializeMusicLibrary();

        // populate songs category
        LinearLayout songsParent = findViewById(R.id.songs_parent);
        for (int i = 0; i < MAX_ITEMS; i++) {
            TextView tv = new TextView(this);
            ArrayList<Song> firstSongs = MusicLibrary.getAllSongs();
            Collections.sort(firstSongs);
            tv.setText(firstSongs.get(i).getSongName());
            songsParent.addView(tv);
        }

//        for (Song song : MusicLibrary.getAllSongs()) {
//            TextView tv = new TextView(this);
//            tv.setText(song.getSongName());
//            songsParent.addView(tv);
//        }
//
//        // get first 3 songs
//        ArrayList<Song> firstSongs = new ArrayList<>(MusicLibrary.getAllSongs().subList(0, 3));
//        SongCubeAdapter songCubeAdapter = new SongCubeAdapter(this, firstSongs);
//        GridView songsGridView = findViewById(R.id.all_songs);
//        songsGridView.setAdapter(songCubeAdapter);
    }

    /**
     * fill the library with Songs, Artists and Albums
     */
    private void initializeMusicLibrary() {
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
        Album low = new Album(getString(R.string.low_name), lowSongs, R.drawable.bowie, bowie);
        MusicLibrary.addAlbum(low);
    }

    public void songs(View view) {
        Intent intent = new Intent(MainActivity.this, SongsActivity.class);
        startActivity(intent);

    }
}
