package com.example.shiningindia.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.shiningindia.Booking.BookingActivity;
import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNav);
        onNavbarClicked();
    }
    public void onNavbarClicked(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                if (item.getItemId() == R.id.menu_item){
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                }
                else if (item.getItemId() == R.id.booking_item){
                    startActivity(new Intent(getApplicationContext(), BookingActivity.class));
                }

                return true;
            }
        });
    }
}