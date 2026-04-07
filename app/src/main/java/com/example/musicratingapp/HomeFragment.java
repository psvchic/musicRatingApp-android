package com.example.musicratingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    RecyclerView recyclerViewArtists;
    RecyclerView recyclerViewAlbums;
    RecyclerView recyclerViewSongs;
    ArrayList<Artist> artists;
    ArrayList<Album> albums;
    ArrayList<Song> songs;
    RVAdapterArtists rvAdapterArtists;
    RVAdapterAlbums rvAdapterAlbums;
    RVAdapterSongs rvAdapterSongs;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // make recyclerView work for artists
        recyclerViewArtists = view.findViewById(R.id.recyclerViewArtists);
        artists = new ArrayList<>();
        rvAdapterArtists = new RVAdapterArtists(artists);

        LinearLayoutManager linearLayoutManagerForArtists = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewArtists.setLayoutManager(linearLayoutManagerForArtists);
        recyclerViewArtists.setAdapter(rvAdapterArtists);

        artists.add(new Artist(1,"Melanie Martinez", "", "https://image-cdn-ak.spotifycdn.com/image/ab67616100005174049b4a6c038ea063a413c5df", LocalDateTime.now()));
        artists.add(new Artist(2,"Melanie Martinez", "", "https://image-cdn-ak.spotifycdn.com/image/ab67616100005174049b4a6c038ea063a413c5df", LocalDateTime.now()));
        artists.add(new Artist(3,"Melanie Martinez", "", "https://image-cdn-ak.spotifycdn.com/image/ab67616100005174049b4a6c038ea063a413c5df", LocalDateTime.now()));
        artists.add(new Artist(4,"Mazzy Star", "", "https://image-cdn-fa.spotifycdn.com/image/ab67726900008f7493b4c6192035c98af64d4da3", LocalDateTime.now()));
        rvAdapterArtists.notifyDataSetChanged();

        // make recyclerView work for albums
        recyclerViewAlbums = view.findViewById(R.id.recyclerViewAlbums);
        albums = new ArrayList<>();
        rvAdapterAlbums = new RVAdapterAlbums(albums);

        LinearLayoutManager linearLayoutManagerForAlbums = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewAlbums.setLayoutManager(linearLayoutManagerForAlbums);
        recyclerViewAlbums.setAdapter(rvAdapterAlbums);

        ArrayList<Song> songsTest = new ArrayList<>();
        songsTest.add(new Song(1, "something", artists.get(1), LocalDateTime.now()));

        albums.add(new Album(1, "Heaven or Las Vegas", "https://image-cdn-fa.spotifycdn.com/image/ab67616d00001e02fe6211303e796f3d5b7a0e02", LocalDateTime.now(), songsTest));
        albums.add(new Album(2, "Heaven or Las Vegas", "https://image-cdn-fa.spotifycdn.com/image/ab67616d00001e02fe6211303e796f3d5b7a0e02", LocalDateTime.now(), songsTest));
        albums.add(new Album(3, "Heaven or Las Vegas", "https://image-cdn-fa.spotifycdn.com/image/ab67616d00001e02fe6211303e796f3d5b7a0e02", LocalDateTime.now(), songsTest));
        rvAdapterAlbums.notifyDataSetChanged();

        // make recyclerView work for songs
        recyclerViewSongs = view.findViewById(R.id.recyclerViewSongs);
        songs = new ArrayList<>();
        rvAdapterSongs = new RVAdapterSongs(songs);

        LinearLayoutManager linearLayoutManagerForSongs = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSongs.setLayoutManager(linearLayoutManagerForSongs);
        recyclerViewSongs.setAdapter(rvAdapterSongs);

        songs.add(new Song(1, "Fade Into You", artists.get(3), "https://image-cdn-ak.spotifycdn.com/image/ab67616d00001e0289a392107ebd79818022b3ea", LocalDateTime.now()));
        songs.add(new Song(2, "Fade Into You", artists.get(3), "https://image-cdn-ak.spotifycdn.com/image/ab67616d00001e0289a392107ebd79818022b3ea", LocalDateTime.now()));
        songs.add(new Song(3, "Fade Into You", artists.get(3), "https://image-cdn-ak.spotifycdn.com/image/ab67616d00001e0289a392107ebd79818022b3ea", LocalDateTime.now()));
        rvAdapterSongs.notifyDataSetChanged();

    }
}