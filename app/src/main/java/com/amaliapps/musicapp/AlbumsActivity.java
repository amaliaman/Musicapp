package com.amaliapps.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // get Albums list from intent
        Intent intent = getIntent();
        final ArrayList<Album> albums = intent.getParcelableArrayListExtra(MainActivity.ALBUMS_EXTRA);

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        ListView albumsListView = findViewById(R.id.albums_view);
        albumsListView.setAdapter(albumAdapter);

    }
}
