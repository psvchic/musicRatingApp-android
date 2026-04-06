package com.example.musicratingapp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Album {
    private int id;
    private String title;
    private String imageUrl;
    private LocalDateTime dateAdded;
    private ArrayList<Song> songs;

    public Album(int id, String title, String imageUrl, LocalDateTime dateAdded, ArrayList<Song> songs) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.dateAdded = dateAdded;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

}
