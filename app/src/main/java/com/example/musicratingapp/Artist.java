package com.example.musicratingapp;

import java.time.LocalDateTime;
import java.util.Date;

public class Artist {
    private int id;
    private String name;
    private String imageUrl;
    private LocalDateTime dateAdded;

    public Artist(int id, String name, String imageUrl, LocalDateTime dateAdded) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
