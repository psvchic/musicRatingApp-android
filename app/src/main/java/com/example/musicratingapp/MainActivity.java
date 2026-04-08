package com.example.musicratingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.musicratingapp.fragments.FavoritesFragment;
import com.example.musicratingapp.fragments.HomeFragment;
import com.example.musicratingapp.fragments.MyProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnHome = findViewById(R.id.homeButton);
        ImageButton btnFavourites = findViewById(R.id.favouritesButton);
        ImageButton btnMyProfile = findViewById(R.id.myProfileButton);

        btnHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // managing fragments using FragmentManager
                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, HomeFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("home")
                                .commit();
                    }
                }
        );

        btnFavourites.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, FavoritesFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("favourites")
                                .commit();
                    }
                }
        );

        btnMyProfile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, MyProfileFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("myProfile")
                                .commit();
                    }
                }
        );


    }
}