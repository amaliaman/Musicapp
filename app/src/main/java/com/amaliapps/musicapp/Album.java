package com.amaliapps.musicapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Album implements Parcelable, Comparable<Album> {
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

    Album(Parcel in) {
        mName = in.readString();
        mSongs = in.createTypedArrayList(Song.CREATOR);
        mAlbumArt = in.readInt();
        mArtist = in.readParcelable(Artist.class.getClassLoader());
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String getName() {
        return mName;
    }

    ArrayList<Song> getSongs() {
        return mSongs;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }

    Artist getArtist() {
        return mArtist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeTypedList(mSongs);
        dest.writeInt(mAlbumArt);
        dest.writeParcelable(mArtist, flags);
    }

    @Override
    public int compareTo(@NonNull Album o) {
        return this.mName.compareTo(o.mName);
    }
}
