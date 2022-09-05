package com.example.sam_netflix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard_activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomnavigationView;
    Home_fragment home_fragment = new Home_fragment();
    Search_fragment search_fragment = new Search_fragment();
    Downloads_fragment downloads_fragment = new Downloads_fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomnavigationView = findViewById(R.id.bottom_view);

        bottomnavigationView.setOnItemSelectedListener(this);
        loadFragment(home_fragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                loadFragment(home_fragment);
                return true;
            case R.id.search:
                loadFragment(search_fragment);
                return true;
            case R.id.downloads:
                loadFragment(downloads_fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fn = getSupportFragmentManager().beginTransaction();
        fn.replace(R.id.fragmentContainerView, fragment, "main_fragment").commit();
    }
}