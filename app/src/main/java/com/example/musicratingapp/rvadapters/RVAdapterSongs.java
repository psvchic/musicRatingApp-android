package com.example.musicratingapp.rvadapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicratingapp.R;
import com.example.musicratingapp.Song;
import com.example.musicratingapp.fragments.SongFragment;

import java.util.ArrayList;

public class RVAdapterSongs extends RecyclerView.Adapter<RVAdapterSongs.ViewHolder> {

    ArrayList<Song> songs;

    public RVAdapterSongs(ArrayList<Song> songs){
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // set song_template to recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_template, parent, false);
        return new RVAdapterSongs.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // associate view with data

        // load image from url using Glide (https://github.com/bumptech/glide)
        ImageButton imageButtonSong = holder.imageButtonSong;
        Glide.with(holder.itemView.getContext())
                .load(songs.get(position).getImageUrl())
                .apply(new RequestOptions().override(256, 256))
                .into(imageButtonSong);
        holder.textViewSongName.setText(songs.get(position).getTitle());
        // set OnClickListener that goes to the song
        Bundle bundle = new Bundle();
        bundle.putString("title", songs.get(position).getTitle());
        bundle.putString("imageUrl", songs.get(position).getImageUrl());
        imageButtonSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentActivity)v.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, SongFragment.class, bundle)
                        .setReorderingAllowed(true)
                        .addToBackStack("song")
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // implemented ImageButton from song_template
        ImageButton imageButtonSong;
        TextView textViewSongName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonSong = itemView.findViewById(R.id.songImageTemplate);
            textViewSongName = itemView.findViewById(R.id.songTitleTemplate);
        }
    }
}
