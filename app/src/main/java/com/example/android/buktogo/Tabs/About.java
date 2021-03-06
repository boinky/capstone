package com.example.android.buktogo.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.buktogo.R;
import com.example.android.buktogo.Tab;

/**
 * Created by jan on 12/23/15.
 */


/**
 * About Tab
 */


public class About extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_one, container, false);
        TextView label = (TextView) view.findViewById(R.id.textViewOne);

        Tab mainTab = (Tab) getActivity();
        label.setText(mainTab.getData());

        return view;
    }
}
