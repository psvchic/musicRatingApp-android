package com.example.musicratingapp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    ArrayList<Artist> artists;

    public RVAdapter(ArrayList<Artist> artists){
        this.artists = artists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // set artist_template to recycle view

        View artist = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_template, parent, false);
        return new ViewHolder(artist);
    }

    Handler handler;

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // associate view with data

        // load image from url using Glide (https://github.com/bumptech/glide)
        Glide.with(holder.itemView.getContext()).load(artists.get(position).getImageUrl()).apply(new RequestOptions().override(256, 256)).into(holder.imageButtonArtist);

    }

    @Override
    public int getItemCount() {
        // return 0; - if there's a 0, there will be 0 elements in RecyclerView
        return artists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // implemented ImageButton from artist_template
        ImageButton imageButtonArtist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonArtist = itemView.findViewById(R.id.ArtistPfp);
        }
    }
}
