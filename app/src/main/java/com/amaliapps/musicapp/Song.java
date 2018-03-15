package com.amaliapps.musicapp;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Song {
    private String mSongName;
    private Artist mArtist;

    public Song(String songName, Artist artist) {
        this.mSongName = songName;
        this.mArtist = artist;
    }

    public String getSongName() {
        return mSongName;
    }

    public Artist getArtist() {
        return mArtist;
    }
}
