package com.amaliapps.musicapp;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class MusicLibrary {
    private static ArrayList<Album> mAlbums = new ArrayList<>();
    private static boolean mIsInitialized = false;

    public static ArrayList<Album> getAllAlbums() {
        return mAlbums;
    }

    static ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for (Album album : mAlbums) {
            songs.addAll(album.getSongs());
        }
        return songs;
    }

    static ArrayList<Artist> getAllArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        for (Album album : mAlbums) {
            if (!artists.contains(album.getArtist())) {
                artists.add(album.getArtist());
            }
        }
        return artists;
    }

    static ArrayList<Song> getSongsByArtist(Artist artist) {
        ArrayList<Song> songs = new ArrayList<>();
        for (Album album : mAlbums) {
            if (album.getArtist().getArtistName().equals(artist.getArtistName())) {
                songs.addAll(album.getSongs());
            }
        }
        return songs;
    }

    static boolean isInitialized() {
        return mIsInitialized;
    }

    static void setIsInitialized(boolean isInitialized) {
        MusicLibrary.mIsInitialized = isInitialized;
    }

    static void addAlbum(Album album) {
        mAlbums.add(album);
    }

}
