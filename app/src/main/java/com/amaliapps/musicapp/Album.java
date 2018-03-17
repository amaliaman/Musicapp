package com.amaliapps.musicapp;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Album {
    private String mName;
    private ArrayList<Song> mSongs;
    private int mAlbumArt;
    private Artist mArtist;

    Album(String name, ArrayList<Song> songs, int albumArt, Artist artist) {
        this.mName = name;
        this.mSongs = songs;
        this.mAlbumArt = albumArt;
        this.mArtist = artist;
    }

    public String getName() {
        return mName;
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    public Artist getArtist() {
        return mArtist;
    }
}
