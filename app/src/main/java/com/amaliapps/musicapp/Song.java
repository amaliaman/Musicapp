package com.amaliapps.musicapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by amaliam on 15/03/2018.
 * A song.
 */

public class Song implements Comparable<Song>, Parcelable {
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

    // implementation of Parcelable interface
    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    private Song(Parcel in) {
        mSongName = in.readString();
        mArtist = in.readParcelable(Artist.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeParcelable(mArtist, flags);
    }

    // implementation of Comparable interface
    @Override
    public int compareTo(@NonNull Song o) {
        return this.mSongName.compareTo(o.mSongName);
    }
}
