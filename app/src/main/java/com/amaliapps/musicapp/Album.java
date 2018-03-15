package com.amaliapps.musicapp;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Album {
    private ArrayList<Song> mSongs;
    private int mAlbumArt;
    private Artist mArtist;

    public Album(ArrayList<Song> songs, int albumArt, Artist artist) {
        this.mSongs = songs;
        this.mAlbumArt = albumArt;
        this.mArtist = artist;
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
