package com.amaliapps.musicapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by amaliam on 15/03/2018.
 */

class MusicLibrary {
    private static ArrayList<Album> mAlbums = new ArrayList<>();
    private static boolean mIsInitialized = false;

    static ArrayList<Album> getAllAlbums() {
        ArrayList<Album> albums = mAlbums;
        Collections.sort(albums);
        return albums;
    }

    static ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for (Album album : mAlbums) {
            songs.addAll(album.getSongs());
        }
        Collections.sort(songs);
        return songs;
    }

    static ArrayList<Artist> getAllArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        for (Album album : mAlbums) {
            if (!artists.contains(album.getArtist())) {
                artists.add(album.getArtist());
            }
        }
        Collections.sort(artists);
        return artists;
    }

    static ArrayList<Album> getAlbumsByArtist(Artist artist) {
        ArrayList<Album> albums = new ArrayList<>();
        for (Album album : getAllAlbums()) {
            if (album.getArtist().equals(artist)) {
                albums.add(album);
            }
        }
        Collections.sort(albums);
        return albums;
    }

    static ArrayList<Song> getSongsByArtist(Artist artist) {
        ArrayList<Song> songs = new ArrayList<>();
        for (Album album : mAlbums) {
            if (album.getArtist().getArtistName().equals(artist.getArtistName())) {
                songs.addAll(album.getSongs());
            }
        }
        Collections.sort(songs);
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
