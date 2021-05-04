package com.example.shiningindia.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OnlinePaymentActivity extends AppCompatActivity {
        String totalPrice;
        TextView mTotalPrice;
        EditText cardDate;
        final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_payment);
        Intent orderIntent = getIntent();
        totalPrice =(String) orderIntent.getSerializableExtra("totalPrice");

        mTotalPrice = findViewById(R.id.totalOnlineCostText);
        mTotalPrice.setText(totalPrice);

        cardDate=  findViewById(R.id.cardDate);
        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };

        cardDate.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            new DatePickerDialog(OnlinePaymentActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

    }
    public void payAndOrder(View view){
        Toast.makeText(getApplicationContext(),"We Received Your payment and order!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }
    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        cardDate.setText(sdf.format(myCalendar.getTime()));
    }
}