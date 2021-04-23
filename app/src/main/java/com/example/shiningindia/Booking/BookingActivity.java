package com.example.shiningindia.Booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.shiningindia.Home.HomeActivity;
import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookingActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.booking_item);
        onNavbarClicked();
    }
    public void onNavbarClicked(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item){
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
            else if (item.getItemId() == R.id.home_item){
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
            return true;
        });
    }
}