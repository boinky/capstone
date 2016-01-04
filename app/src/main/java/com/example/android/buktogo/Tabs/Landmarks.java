package com.example.android.buktogo.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.buktogo.Adapters.LandmarksAdapter;
import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 12/23/15.
 */
public class Landmarks extends Fragment {
    RecyclerView recyclerView;
    LandmarksAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        adapter = new LandmarksAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
    }

    public List<Data> placeData() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("2116650", "Baungon"));
        data.add(new Data("2116651", "Cabanglasan"));
        data.add(new Data("2116652", "Damulog"));
        data.add(new Data("2116653", "Dangcagan"));
        data.add(new Data("2116654", "Don Carlos"));
        data.add(new Data("2116655", "Impasug-ong"));
        data.add(new Data("2116656", "Kadingilan"));
        data.add(new Data("2116657", "Kalilangan"));
        data.add(new Data("2116658", "Kibawe"));
        data.add(new Data("2116659", "Lantapan"));
        data.add(new Data("2116660", "Libona"));
        data.add(new Data("2116661", "Malaybalay"));
        data.add(new Data("2116662", "Maramag"));
        data.add(new Data("2116663", "Malitbog"));
        data.add(new Data("2116664", "Manolo Fortich"));
        data.add(new Data("2116665", "Pangantucan"));
        data.add(new Data("2116666", "Quezon"));
        data.add(new Data("2116667", "San Fernando"));
        data.add(new Data("2116668", "Sumilao"));
        data.add(new Data("2116669", "Talakag"));
        data.add(new Data("2116670", "Valencia"));

        return data;
    }
}