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

import java.text.DecimalFormat;

import static com.example.shiningindia.Menu.MenuActivity.cart;

public class ItemActivity extends AppCompatActivity {
        ImageView mItemImage;
        TextView mItemName;
        TextView mItemContent;
        TextView mItemPrice;
        TextView mItemQuantity;
        MenuItem menuItem;
        String quantity;
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
        quantity = "" + menuItem.getQuantity();
        String price = "$" + new DecimalFormat("##.##").format(menuItem.getPrice());
        mItemPrice.setText(price);
        mItemQuantity.setText( quantity);
    }
    public void increaseQuantity(View view){
        menuItem.setQuantity(menuItem.getQuantity() + 1);
        quantity = ""+menuItem.getQuantity();
        mItemQuantity.setText(quantity);


    }
    public void decreaseQuantity(View view){
        if(menuItem.getQuantity() != 1){
            menuItem.setQuantity(menuItem.getQuantity() - 1);
            quantity = ""+menuItem.getQuantity();
            mItemQuantity.setText(quantity);
        }
    }
    public void addToCart(View view){
        boolean itemExists = isItemExists();
        if (!itemExists){
        cart.addToCart(menuItem);
        }
        Toast.makeText(getApplicationContext(),"Item is added to the cart",Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(),MenuActivity.class));

    }
    public void goToCart(View view){
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        intent.putExtra("Cart",cart);
        startActivity(intent);
    }
    private boolean isItemExists(){
        for (MenuItem item: cart.items) {
            if(item.getName().equals(menuItem.getName())){
                item.setQuantity(item.getQuantity() + menuItem.getQuantity());
                return true;

            }
        }
        return false;
    }


}