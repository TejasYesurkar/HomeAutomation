package com.sibi.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recycleviewAdapter extends RecyclerView.Adapter<recycleviewAdapter.ViewHolder> {

    private List<ItemData> mContacts;
    private Context mContext;

    public recycleviewAdapter(List<ItemData> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
    }

    public recycleviewAdapter(List<ItemData> mContacts) {
        this.mContacts = mContacts;
    }


    @NonNull
    @Override
    public recycleviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.row_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull recycleviewAdapter.ViewHolder holder, final int position) {
        final ItemData item = mContacts.get(position);

        holder.name.setText(item.getName() );
        holder.description.setText(item.getDescription() );
        if(item.isStatus() == false)
        {
            holder.itemCard.setCardBackgroundColor(R.color.material_on_primary_emphasis_high_type);
        }



    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // public TextView OrderId;
        public TextView name;
        public TextView description;
        private ToggleButton status;

        private CardView itemCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           itemCard = (CardView) itemView.findViewById(R.id.card);

            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            status = (ToggleButton) itemView.findViewById(R.id.status);
        }

    }
}
