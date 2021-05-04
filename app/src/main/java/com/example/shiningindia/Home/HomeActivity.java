package com.example.shiningindia.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.shiningindia.Booking.BookingActivity;
import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    VideoView videoView;
    TextView contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNav);
        onNavbarClicked();
        videoView = (VideoView) findViewById(R.id.videoView);  //casting to VideoView is not Strictly required above API level 26
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.about_us); //set the path of the video that we need to use in our VideoView
        videoView.start();  //start() method of the VideoView class will start the video to play
        contentView = findViewById(R.id.aboutContentText);
        String contentText = "In case you’re searching for conventional Indian food in the city, think about Shining India. We present to you the equivalent magnificent experiences and tastes we grew up eating in India. From our remarkable support of the legitimate smells of our tasty Indian food and our delightful, natively constructed plans, Shining India is certain to turn into your new most loved eatery in city.\n" +
                "Do you need a suggestion for supper this evening? To begin, you can look over an incredible assortment of veggie lover and non-vegan tidbits, for example, the Paneer Pakora made in a the restaurant,";
        contentView.setText(contentText);
    }
    public void onNavbarClicked(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item){
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
            else if (item.getItemId() == R.id.booking_item){
                startActivity(new Intent(getApplicationContext(), BookingActivity.class));
            }

            return true;
        });
    }
}