package com.example.shiningindia.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shiningindia.Order.Cart;
import com.example.shiningindia.Order.CartActivity;
import com.example.shiningindia.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MenuAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MenuItem> menuItems;
    public static Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cart = new Cart();
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem(R.drawable.amritsai_naan,"Amritsari Naan","Two Nan with Unlimited Chole + Raita + Salad",11.95));
        menuItems.add(new MenuItem(R.drawable.chole_bhature,"Chole Bhature","Two Bhature with Unlimited Chole + SaladWhole Day Menu",11.95));
        menuItems.add(new MenuItem(R.drawable.vegeterian_thali,"Vegeterian Thali","Three vegetarian curries of chef’s special, plain naan, rice, desert, raita and salad",15.95));
        menuItems.add(new MenuItem(R.drawable.non_vegetarian_thali,"Non-Vegeterian Thali","Three non-vegetarian curries of chef’s special,plain naan, rice desert, raita and salad",17.95));

        buildRecyclerView();

    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.cartRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerAdapter = new MenuAdapter(menuItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent ItemIntent = new Intent(getApplicationContext(),ItemActivity.class);
                ItemIntent.putExtra("menuItem", menuItems.get(position));
                startActivity(ItemIntent);
            }
        });
    }
    public void goToCart(View view){
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }


}