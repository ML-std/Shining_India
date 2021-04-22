package com.example.shiningindia.Order;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiningindia.Menu.MenuItem;
import com.example.shiningindia.Menu.OnItemClickListener;
import com.example.shiningindia.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.shiningindia.Menu.MenuActivity.cart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){

        mOnItemClickListener = listener;
    }



    public static class CartViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mNameText;
        public TextView mQuantity;
        public TextView mPriceText;

        public CartViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.itemImageView);
            mNameText = itemView.findViewById(R.id.nameTextView);
            mQuantity = itemView.findViewById(R.id.quantityTextView);
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
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new CartAdapter.CartViewHolder(view,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {

        MenuItem currentItem = cart.items.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mNameText.setText(currentItem.getName());
        holder.mQuantity.setText("" + currentItem.getQuantity());
        holder.mPriceText.setText("$" + new DecimalFormat("##.##").format(currentItem.getPrice()*currentItem.getQuantity()));
    }



    @Override
    public int getItemCount() {
        return cart.items.size();
    }

}
