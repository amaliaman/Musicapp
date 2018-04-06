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

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        // get Albums list from intent
        Intent intent = getIntent();

        ArrayList<Album> albums;
        Artist artist = intent.getParcelableExtra(MainActivity.ARTISTS_EXTRA);

        ImageView artImageView = findViewById(R.id.art);
        // check if intent has artist
        if (artist != null) {
            setTitle(String.format(getString(R.string.albums_by), artist.getArtistName()));
            albums = MusicLibrary.getAlbumsByArtist(artist);
            artImageView.setImageResource(artist.getArtistArt());
            artImageView.setVisibility(View.VISIBLE);
            LinearLayout header = findViewById(R.id.header);
            header.setBackgroundColor(getResources().getColor(R.color.artists));
        } else {
            setTitle(R.string.all_albums_label);
            albums = intent.getParcelableArrayListExtra(MainActivity.ALBUMS_EXTRA);
        }

        // attach adapter to ListView
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        final ListView albumsListView = findViewById(R.id.items_view);
        albumsListView.setAdapter(albumAdapter);

        // set listener on album item in list
        albumsListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Album album = (Album) albumsListView.getItemAtPosition(position);
                Intent albumsIntent = new Intent(view.getContext(), SongsActivity.class);
                albumsIntent.putExtra(MainActivity.ALBUM_EXTRA, album);
                startActivity(albumsIntent);
            }
        });
    }
}
