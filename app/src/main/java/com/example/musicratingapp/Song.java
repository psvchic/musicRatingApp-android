package com.example.musicratingapp;

import java.time.LocalDateTime;

public class Song {
    private int id;
    private String title;
    private Artist artist;
    private String imageUrl;
    private LocalDateTime dateAdded;

    public Song(int id, String title, Artist artist, String imageUrl, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.dateAdded = dateAdded;
    }

    public Song(int id, String title, Artist artist, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.dateAdded = dateAdded;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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
}
