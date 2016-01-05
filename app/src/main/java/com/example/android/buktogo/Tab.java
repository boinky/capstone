package com.example.android.buktogo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.buktogo.Adapters.ViewPagerAdapter;
import com.example.android.buktogo.Tabs.Accomodation;
import com.example.android.buktogo.Tabs.Food;
import com.example.android.buktogo.Tabs.Recreational;
import com.example.android.buktogo.Tabs.About;
import com.example.android.buktogo.Tabs.Landmarks;

/**
 * Created by jan on 12/24/15.
 */
public class Tab extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public String id;
    public String getData;
    Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        data = (Data)getIntent().getExtras().getSerializable("DATA");
        Log.e("Value - ", data.getId());
        getData = data.getId();

    }

    public String getData(){
        return getData;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new About(), "About");
        adapter.addFragment(new Landmarks(), "Landmarks");
        adapter.addFragment(new Accomodation(), "Accomodation");
        adapter.addFragment(new Food(), "Food");
        adapter.addFragment(new Recreational(), "Recreational");
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
