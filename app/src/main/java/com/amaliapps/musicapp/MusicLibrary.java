package com.amaliapps.musicapp;

import java.util.ArrayList;

/**
 * Created by amaliam on 15/03/2018.
 */

public class MusicLibrary {
    private static ArrayList<Album> mAlbums = new ArrayList<>();

    public static ArrayList<Album> getAllAlbums() {
        return mAlbums;
    }

    static ArrayList<Song> getAllSongs() { // todo: remove duplicates
        ArrayList<Song> songs = new ArrayList<>();

        for (Album album : mAlbums) {
            songs.addAll(album.getSongs());
        }

        return songs;
    }

    static ArrayList<Artist> getAllArtists() { // todo: remove duplicates
        ArrayList<Artist> artists = new ArrayList<>();

        for (Album album : mAlbums) {
            artists.add(album.getArtist());
        }

        return artists;
    }

    static void addAlbum(Album album) {
        mAlbums.add(album);
    }

}
