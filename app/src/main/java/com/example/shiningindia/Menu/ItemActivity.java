package com.example.shiningindia.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiningindia.Order.CartActivity;
import com.example.shiningindia.R;

import static com.example.shiningindia.Menu.MenuActivity.cart;

public class ItemActivity extends AppCompatActivity {
        ImageView mItemImage;
        TextView mItemName;
        TextView mItemContent;
        TextView mItemPrice;
        TextView mItemQuantity;
        MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        createItem();
    }
    private void createItem(){
        Intent initialIntent = getIntent();
         menuItem = (MenuItem)initialIntent.getSerializableExtra("menuItem");
        mItemImage = findViewById(R.id.imageView);
        mItemName = findViewById(R.id.nameView);
        mItemContent = findViewById(R.id.contentView);
        mItemPrice = findViewById(R.id.priceView);
        mItemQuantity = findViewById(R.id.QuantityText);
        mItemImage.setImageResource(menuItem.getImageResource());
        mItemName.setText(menuItem.getName());
        mItemContent.setText(menuItem.getMenuContent());
        mItemPrice.setText("$" + menuItem.getPrice());
        mItemQuantity.setText(""+menuItem.getQuantity());
    }
    public void increaseQuantity(View view){
        menuItem.setQuantity(menuItem.getQuantity() + 1);
        Toast.makeText(getApplicationContext(), "Increased", Toast.LENGTH_SHORT).show();
    }
    public void decreaseQuantity(View view){
        if(menuItem.getQuantity() != 0){
        menuItem.setQuantity(menuItem.getQuantity() - 1);
        }
    }
    public void addToCart(View view){
        cart.addToCart(menuItem);
        Toast.makeText(getApplicationContext(),"Item is added to the cart",Toast.LENGTH_LONG).show();

    }
    public void goToCart(View view){
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }

}