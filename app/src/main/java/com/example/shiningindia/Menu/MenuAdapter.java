package com.example.shiningindia.Menu;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiningindia.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private  ArrayList<MenuItem> menuItems;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){

        mOnItemClickListener = listener;
    }

    public MenuAdapter(ArrayList<MenuItem> menuItems){
    this.menuItems = menuItems;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mNameText;
        public TextView mContentText;
        public TextView mPriceText;

        public MenuViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.itemImageView);
            mNameText = itemView.findViewById(R.id.nameTextView);
            mContentText = itemView.findViewById(R.id.contentTextView);
            mPriceText = itemView.findViewById(R.id.priceTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new MenuViewHolder(view,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        MenuItem currentItem = menuItems.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mNameText.setText(currentItem.getName());
        holder.mContentText.setText(currentItem.getMenuContent());
        holder.mPriceText.setText("$" + new DecimalFormat("##.##").format(currentItem.getPrice()));
    }



    @Override
    public int getItemCount() {
        return menuItems.size();
    }


}
