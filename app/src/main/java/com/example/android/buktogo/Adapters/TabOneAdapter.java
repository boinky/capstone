package com.example.android.buktogo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by jan on 12/30/15.
 */
public class TabOneAdapter  extends RecyclerView.Adapter<TabOneAdapter.View_Holder> {
    List<Data> mData = Collections.emptyList();
    Context context;

    public TabOneAdapter(Context context, List<Data> list) {
        this.mData = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_two, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {
        final Data itemData = mData.get(position);
        holder.title.setText(mData.get(position).title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sample : " + itemData.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return mData.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        View view;
        TextView title;

        View_Holder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.tabOne);
            title = (TextView) itemView.findViewById(R.id.cardView_title);

        }
    }
}
