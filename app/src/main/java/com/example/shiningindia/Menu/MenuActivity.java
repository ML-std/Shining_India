package com.example.shiningindia.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.example.shiningindia.Booking.BookingActivity;
import com.example.shiningindia.Home.HomeActivity;
import com.example.shiningindia.Order.Cart;
import com.example.shiningindia.Order.CartActivity;
import com.example.shiningindia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MenuAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MenuItem> menuItems;
    BottomNavigationView bottomNavigationView;
    public static Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.menu_item);
        cart = new Cart();
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.drawable.amritsai_naan,"Amritsari Naan","Two Nan with Unlimited Chole + Raita + Salad",11.95));
        menuItems.add(new MenuItem(R.drawable.chole_bhature,"Chole Bhature","Two Bhature with Unlimited Chole + SaladWhole Day Menu",11.95));
        menuItems.add(new MenuItem(R.drawable.vegeterian_thali,"Vegeterian Thali","Three vegetarian curries of chef’s special, plain naan, rice, desert, raita and salad",15.95));
        menuItems.add(new MenuItem(R.drawable.non_vegetarian_thali,"Non-Vegeterian Thali","Three non-vegetarian curries of chef’s special,plain naan, rice desert, raita and salad",17.95));
        onNavbarClicked();
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
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_item:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                return true;

            case R.id.menu_item:
                //startActivity(new Intent(getApplicationContext(), MenuActivity.class));

                return true;

            case R.id.booking_item:
                startActivity(new Intent(getApplicationContext(), BookingActivity.class));
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
        public void onNavbarClicked(){
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                    if (item.getItemId() == R.id.home_item){
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }
                    else if (item.getItemId() == R.id.booking_item){
                        startActivity(new Intent(getApplicationContext(), BookingActivity.class));
                    }
                    return true;
                }
            });
}
}