package com.example.android.buktogo.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.buktogo.Adapters.AccomodationAdapter;
import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;
import com.example.android.buktogo.Tab;

import java.util.List;

/**
 * Created by jan on 12/23/15.
 */
public class Food extends Fragment {

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
        View view = inflater.inflate(R.layout.food, container, false);
        TextView label = (TextView) view.findViewById(R.id.textViewOne);

        Tab mainTab = (Tab) getActivity();
//        label.setText(mainTab.getData());

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}