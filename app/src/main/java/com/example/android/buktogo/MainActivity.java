package com.example.android.buktogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.buktogo.AppIntro.IntroApp;
import com.example.android.buktogo.Fragments.HomeFragment;
import com.example.android.buktogo.Fragments.MunicipalityFragment;
import com.mapswithme.maps.api.MWMPoint;
import com.mapswithme.maps.api.MapsWithMeApi;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, IntroApp.class);
                    startActivity(i);

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FT.replace(R.id.frame_layout, new HomeFragment());
        FT.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(GravityCompat.START);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
//        Fragment newFragment = null;

        if (id == R.id.home) {
           // for home fragment
            FT.replace(R.id.frame_layout, new HomeFragment());
            FT.commit();
        } else if (id == R.id.municipality) {
            FT.replace(R.id.frame_layout, new MunicipalityFragment());
            FT.commit();
        } else if (id == R.id.mapswithme) {
            showCityOnMWMMap(MwmDataItem.ITEMS);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showCityOnMWMMap(MwmDataItem... cities) {
        MWMPoint[] points = new MWMPoint[cities.length];
        for (int i = 0; i < cities.length; i++)
            points[i] = cities[i].toMWMPoint();

        final String title = cities.length == 1 ? cities[0].getName() : "Points in Bukidnon";
        MapsWithMeApi.showPointsOnMap(this, title, points);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
