package com.example.android.buktogo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;
import com.example.android.buktogo.Tab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jan on 12/30/15.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<Recycler_View_Adapter.View_Holder> {

    List<Data> mData = Collections.emptyList();
    //    List<Data> mData;
    Context context;
    String key;


    public Recycler_View_Adapter(Context context, List<Data> list) {
        this.mData = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        final Data itemData = mData.get(position);
        holder.title.setText(mData.get(position).title);
        holder.description.setText(mData.get(position).description);
        holder.imageView.setImageResource(mData.get(position).imageId);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Tab.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("DATA", mData.get(position));
                intent.putExtras(bundle);

                context.startActivity(intent);

                Toast.makeText(context, "id - " + itemData.getId() + ", Name - " + itemData.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getData() {
        return key;
    }


    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return mData.size();
    }

    public void setFilter(List<Data> data) {
        mData = new ArrayList<>();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        View view;
        TextView title;
        TextView description;
        ImageView imageView;

        View_Holder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.rowLayout);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.icon);

        }
    }
}