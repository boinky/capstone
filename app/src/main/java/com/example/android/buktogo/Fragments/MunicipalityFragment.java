package com.example.android.buktogo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.buktogo.Adapters.Recycler_View_Adapter;
import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jan on 12/23/15.
 */
public class MunicipalityFragment extends Fragment implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    Recycler_View_Adapter adapter;
    private List<Data> mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        List<Data> data = placeData();
        mData = new ArrayList<>();
        mData = data;

        adapter = new Recycler_View_Adapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        adapter.setFilter(mData);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Data> filteredModelList = filter(mData, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<Data> filter(List<Data> models, String query) {
        query = query.toLowerCase();

        final List<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String text = model.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    public List<Data> placeData() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("2116650", "Baungon", "Municipality of Baungon", R.drawable.hall));
        data.add(new Data("2116651", "Cabanglasan", "Municipality of Cabanglasan", R.drawable.hall));
        data.add(new Data("2116652", "Damulog", "Municipality of Damulog", R.drawable.hall));
        data.add(new Data("2116653", "Dangcagan", "Municipality of Dangcagan", R.drawable.hall));
        data.add(new Data("2116654", "Don Carlos", "Municipality of Don Carlos", R.drawable.hall));
        data.add(new Data("2116655", "Impasug-ong", "Municipality of Impasug-ong", R.drawable.hall));
        data.add(new Data("2116656", "Kadingilan", "Municipality of Kadingilan", R.drawable.hall));
        data.add(new Data("2116657", "Kalilangan", "Municipality of Kalilangan", R.drawable.hall));
        data.add(new Data("2116658", "Kibawe", "Municipality of Kibawe", R.drawable.hall));
        data.add(new Data("2116659", "Lantapan", "Municipality of Lantapan", R.drawable.hall));
        data.add(new Data("2116660", "Libona", "Municipality of Libona", R.drawable.hall));
        data.add(new Data("2116661", "Malaybalay", "City of Malaybalay", R.drawable.hall));
        data.add(new Data("2116662", "Maramag", "Municipality of Maramag", R.drawable.hall));
        data.add(new Data("2116663", "Malitbog", "Municipality of Malitbog", R.drawable.hall));
        data.add(new Data("2116664", "Manolo Fortich", "Municipality of Manolo Fortich", R.drawable.hall));
        data.add(new Data("2116665", "Pangantucan", "Municipality of Pangantucan", R.drawable.hall));
        data.add(new Data("2116666", "Quezon", "Municipality of Quezon", R.drawable.hall));
        data.add(new Data("2116667", "San Fernando", "Municipality of San Fernando", R.drawable.hall));
        data.add(new Data("2116668", "Sumilao", "Municipality of Sumilao", R.drawable.hall));
        data.add(new Data("2116669", "Talakag", "Municipality of Talakag", R.drawable.hall));
        data.add(new Data("2116670", "Valencia", "City of Valencia", R.drawable.hall));

        return data;
    }
}
