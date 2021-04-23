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

import static com.example.shiningindia.Menu.MenuActivity.cart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private OnDeleteClickListener mOnItemClickListener;

    public void setOnDeleteClickListener(OnDeleteClickListener listener){

        mOnItemClickListener = listener;
    }



    public static class CartViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mNameText;
        public TextView mQuantity;
        public TextView mPriceText;

        public CartViewHolder(@NonNull View itemView, OnDeleteClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.itemImageView);
            mNameText = itemView.findViewById(R.id.nameTextView);
            mQuantity = itemView.findViewById(R.id.quantityTextView);
            mPriceText = itemView.findViewById(R.id.priceTextView);
            itemView.setOnClickListener(v -> {
                if (listener != null){
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        listener.onDeleteClick(position);
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
        String quantity = "" + currentItem.getQuantity();
        String price = "$" + new DecimalFormat("##.##").format(currentItem.getPrice()*currentItem.getQuantity());
        holder.mQuantity.setText(quantity);
        holder.mPriceText.setText(price);
    }



    @Override
    public int getItemCount() {
        return cart.items.size();
    }

}
