package com.example.musicratingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RVAdapterAlbums extends RecyclerView.Adapter<RVAdapterAlbums.ViewHolder>{

    ArrayList<Album> albums;

    public RVAdapterAlbums(ArrayList<Album> albums){
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // set album_template to recycle view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // associate view with data

        // load image from url using Glide (https://github.com/bumptech/glide)
        ImageButton imageButtonAlbum = holder.imageButtonAlbum;
        if (holder.imageButtonAlbum != null && albums.get(position).getImageUrl() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(albums.get(position).getImageUrl())
                    .into(holder.imageButtonAlbum);
        }

        // set OnClickListener that goes to the artist profile
        Bundle bundle = new Bundle();
        bundle.putString("title", albums.get(position).getTitle());
        bundle.putString("imageUrl", albums.get(position).getImageUrl());
        //bundle.putString("description", albums.get(position).getSongs());
        imageButtonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentActivity)v.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, AlbumFragment.class, bundle)
                        .setReorderingAllowed(true)
                        .addToBackStack("album")
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // implemented ImageButton from album_template
        ImageButton imageButtonAlbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonAlbum = itemView.findViewById(R.id.albumImage);
        }

    }
}
