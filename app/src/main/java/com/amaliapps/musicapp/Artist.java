package com.amaliapps.musicapp;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Artist {
    private String mArtistName;
    private int mArtistArt;

    public Artist(String artistName, int artistArt) {
        this.mArtistName = artistName;
        this.mArtistArt = artistArt;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getArtistArt() {
        return mArtistArt;
    }
}
