package com.amaliapps.musicapp;

import android.support.annotation.NonNull;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Song implements Comparable<Song> {
    private String mSongName;
    private Artist mArtist;

    Song(String songName, Artist artist) {
        this.mSongName = songName;
        this.mArtist = artist;
    }

    String getSongName() {
        return mSongName;
    }

    Artist getArtist() {
        return mArtist;
    }

    @Override
    public int compareTo(@NonNull Song o) {
        return this.mSongName.compareTo(o.mSongName);
    }
}
