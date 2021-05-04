package com.example.shiningindia.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.R;

import java.text.DecimalFormat;

public class OrderActivity extends AppCompatActivity {

    double totalPrice;
    String totalPriceText;
    TextView mAddressTextView;
    TextView mTotalPriceTextView;
    TextView mPaymentOptionsView;
    EditText mAddressText;
    RadioGroup mPaymentOptionsGroup;
    RadioButton mCashButton, mCreditCartButton, mOnlinePaymentButton;
    Button mOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent orderIntent = getIntent();
        totalPrice =(double)  orderIntent.getSerializableExtra("totalPrice");
        mAddressText = findViewById(R.id.addressText);
        mAddressTextView = findViewById(R.id.addressTextView);
        mTotalPriceTextView = findViewById(R.id.totalPriceTextView);
        mPaymentOptionsView = findViewById(R.id.paymentOptionsView);
        mPaymentOptionsGroup = findViewById(R.id.paymentOptionsGroup);
        mCashButton = findViewById(R.id.cashButton);
        mCreditCartButton = findViewById(R.id.creditCartButton);
        mOnlinePaymentButton = findViewById(R.id.onlinePayment);
        mOrderButton = findViewById(R.id.orderButton);
        totalPriceText = "Total Price = $" + new DecimalFormat("##.##").format(totalPrice);
        mTotalPriceTextView.setText(totalPriceText);
    }

    public void order(View view){
        if (mOnlinePaymentButton.isChecked()){
            Intent orderIntent = new Intent(getApplicationContext(),OnlinePaymentActivity.class);
            orderIntent.putExtra("totalPrice", totalPriceText);
            startActivity(orderIntent);

        }
        else{
        Toast.makeText(getApplicationContext(),"We Received Your Order!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));}
    }

}