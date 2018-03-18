package com.amaliapps.musicapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by amaliam on 15/03/2018.
 */

public class Artist implements Parcelable, Comparable<Artist> {
    private String mArtistName;
    private int mArtistArt;

    Artist(String artistName, int artistArt) {
        this.mArtistName = artistName;
        this.mArtistArt = artistArt;
    }

    private Artist(Parcel in) {
        mArtistName = in.readString();
        mArtistArt = in.readInt();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    String getArtistName() {
        return mArtistName;
    }

    public int getArtistArt() {
        return mArtistArt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mArtistName);
        dest.writeInt(mArtistArt);
    }

    @Override
    public int compareTo(@NonNull Artist o) {
        return this.mArtistName.compareTo(o.mArtistName);
    }
}
