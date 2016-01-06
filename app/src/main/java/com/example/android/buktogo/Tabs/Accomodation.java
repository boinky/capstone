package com.example.android.buktogo.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.buktogo.Adapters.AccomodationAdapter;
import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;
import com.example.android.buktogo.Tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 12/23/15.
 */
public class Accomodation extends Fragment {
    RecyclerView recyclerView;
    AccomodationAdapter adapter;
    List<Data> data;
    String result;

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
        Tab mainTab = (Tab) getActivity();

        result = mainTab.getData();

        switch (result) {
            case "2116661":
                data = malaybalayData();
                break;
            default:
                break;
        }

        adapter = new AccomodationAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
    }

    public List<Data> malaybalayData() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("2116661acc", "Pine Hills Hotel", "Fortich Street, Malaybalay City", "(088) 221-3212/813-2055", R.drawable.pine_hills, 8.159801, 125.123242));
        data.add(new Data("2116661acc", "House Malibu", "Bonifacio Drive, City of Malaybalay", "(088) 221-2714/221-3318/221-2601", R.drawable.house_malibu, 8.158713, 125.127437));
        data.add(new Data("2116661acc", "First Avenue Apartel", "Propia Street, Malaybalay City", "(088) 221-3224 or 0926-432-5382 or 0917-722-9850", R.drawable.temp));
        data.add(new Data("2116661acc", "Green Ridge Apartelle", "Carbajal St.,Capitol Side, Malaybalay City", "0912-949-2800 and 0910-796-4549", R.drawable.green_ridge_apartelle, 8.154502, 125.13174));
        data.add(new Data("2116661acc", "Villa Alemania Inn", "Fortich cor. Moreno Street, Malaybalay City", "(088) 813-2301 / 0915-415-3801", R.drawable.villa_alemania_inn, 8.155471, 125.127577));
        data.add(new Data("2116661acc", "Small World Traveller's Inn", "Rizal corner G. Tabios St., Malaybalay City", "813-1206/07", R.drawable.temp));
        data.add(new Data("2116661acc", "Plaza View Tourist Inn", "Saver's Plaza Building, City of Malaybalay", "(088) 221-2503", R.drawable.temp));
        data.add(new Data("2116661acc", "Maiple Pension House", "Cudal St. Malaybalay City", "813-3106/ 09262897891", R.drawable.temp));
        data.add(new Data("2116661acc", "Versatille Lodging House", "Brgy. Casisang, Malaybalay City", "to be contact.", R.drawable.temp));
        data.add(new Data("2116661acc", "Sunflower Lodging House", "Cudal St. Malaybalay City", "221-2560", R.drawable.temp));
        data.add(new Data("2116661acc", "D'Stable Eco Resort", "Sta. Cruz St., Malaybalay City (near Shepherds Meadow)", "(088) 221-3338", R.drawable.temp, 8.166194, 125.124001));
        data.add(new Data("2116661acc", "Loiza's Dormitory and Guest House", "Propia Street, Malaybalay City", "(088) 221-3224 or 0926-432-5382", R.drawable.temp, 8.131511, 125.132405));
        data.add(new Data("2116661acc", "Bukidnon Institute of Catechetics Dormitory", "Malaybalay City", "221-2119", R.drawable.temp));
        data.add(new Data("2116661acc", "Pitcher Plant Farm", "Kalasungay, Malaybalay City", "0912-949-2800 and 0910-796-4549", R.drawable.temp));

        return data;
    }
}