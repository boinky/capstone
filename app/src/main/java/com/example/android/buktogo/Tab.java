package com.example.android.buktogo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.buktogo.Adapters.ViewPagerAdapter;
import com.example.android.buktogo.Tabs.TabFive;
import com.example.android.buktogo.Tabs.TabFour;
import com.example.android.buktogo.Tabs.TabOne;
import com.example.android.buktogo.Tabs.TabThree;
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
//        Bundle bundle = new Bundle();
//        bundle.putString("key", data.getTitle());
//        TabOne tabOne = new TabOne();
//        tabOne.setArguments(bundle);
        Log.e("Value - ", data.getTitle());
        getData = data.getTitle();

    }

    public String getData(){
        return getData;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabOne(), "About");
        adapter.addFragment(new Landmarks(), "Landmarks");
        adapter.addFragment(new TabThree(), "Accomodation");
        adapter.addFragment(new TabFour(), "Food");
        adapter.addFragment(new TabFive(), "Recreational");
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
