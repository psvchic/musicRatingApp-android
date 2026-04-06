package com.example.musicratingapp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Album {
    private int id;
    private String title;
    private String imageUrl;
    private LocalDateTime dateAdded;
    private ArrayList<Song> songs;
}
