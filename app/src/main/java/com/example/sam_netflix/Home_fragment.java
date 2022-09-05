package com.example.sam_netflix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class Home_fragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout ;
    NavigationView navigationView ;
    ActionBarDrawerToggle drawerToggle;
    ImageView menu;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment, container, false);

        menu = view.findViewById(R.id.menu);
        drawerLayout = view.findViewById(R.id.drawer_layout);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

      //  getContext().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setCheckedItem(R.id.home);

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else{
//            super.onBackPressed();
//        }
//
//    }
}