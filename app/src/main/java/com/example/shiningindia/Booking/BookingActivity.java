package com.example.shiningindia.Booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.shiningindia.Home.HomeActivity;
import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.Order.OnlinePaymentActivity;
import com.example.shiningindia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class BookingActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText cardDate;
    EditText timeText;
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.booking_item);
        cardDate=  findViewById(R.id.bookingDate);
        timeText = findViewById(R.id.timeText);
        onNavbarClicked();


        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };

        cardDate.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            new DatePickerDialog(BookingActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        timeText.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(BookingActivity.this, (timePicker, selectedHour, selectedMinute) -> {
                String time = selectedHour + ":" + selectedMinute;
                timeText.setText(time);
            }, hour, minute, true);//Yes 24 hour time
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();

        });

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

    public void bookTable(View view){

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        cardDate.setText(sdf.format(myCalendar.getTime()));
    }

}