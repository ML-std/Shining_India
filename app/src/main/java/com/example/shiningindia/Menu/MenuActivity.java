package com.example.shiningindia.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shiningindia.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MenuAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MenuItem> menuItems;//Fill it, it is currently empty


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem(R.drawable.amritsai_naan,"Amritsari Naan","Two Nan with Unlimited Chole + Raita + Salad","$11.95"));
        menuItems.add(new MenuItem(R.drawable.chole_bhature,"Chole Bhature","Two Bhature with Unlimited Chole + SaladWhole Day Menu","$11.95"));
        menuItems.add(new MenuItem(R.drawable.vegeterian_thali,"Vegeterian Thali","Three vegetarian curries of chef’s special, plain naan, rice, desert, raita and salad","$15.95"));
        menuItems.add(new MenuItem(R.drawable.non_vegetarian_thali,"Non-Vegeterian Thali","Three non-vegetarian curries of chef’s special,plain naan, rice desert, raita and salad","$17.95"));

        setContentView(R.layout.activity_menu);
        mRecyclerView = findViewById(R.id.menuRecyclerView);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerAdapter = new MenuAdapter(menuItems);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mRecyclerAdapter);
    }
}