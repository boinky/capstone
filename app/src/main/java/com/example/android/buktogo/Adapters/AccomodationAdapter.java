package com.example.android.buktogo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.buktogo.Data;
import com.example.android.buktogo.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by jan on 12/30/15.
 */
public class AccomodationAdapter extends RecyclerView.Adapter<AccomodationAdapter.View_Holder> {
    List<Data> mData = Collections.emptyList();
    Context context;

    public AccomodationAdapter(Context context, List<Data> list) {
        this.mData = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.accomodation, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, final int position) {
        final Data itemData = mData.get(position);
        holder.title.setText(itemData.getTitle());
        holder.address.setText(itemData.getAddress());
//        holder.contact.setText(itemData.getContact());
        holder.image.setImageResource(itemData.getImageId());

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
        TextView address;
        TextView contact;
        ImageView image;

        View_Holder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.tabOne);
            title = (TextView) itemView.findViewById(R.id.cardView_title);
            address = (TextView) itemView.findViewById(R.id.cardView_address);
//            contact = (TextView) itemView.findViewById(R.id.cardView_contact);
            image = (ImageView) itemView.findViewById(R.id.cardView_image);
        }
    }
}
