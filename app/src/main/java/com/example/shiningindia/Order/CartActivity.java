package com.example.shiningindia.Order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiningindia.Menu.MenuItem;
import com.example.shiningindia.R;

import java.text.DecimalFormat;

import static com.example.shiningindia.Menu.MenuActivity.cart;


public class CartActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CartAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mOrderButton;
    private TextView mTotalPriceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        buildRecyclerView();
        mOrderButton = findViewById(R.id.orderActivityButton);
        mTotalPriceView = findViewById(R.id.totalPriceView);
        mTotalPriceView.setText("Total Price = $" + new DecimalFormat("##.##").format(calculateTotalPrice()));
        mOrderButton = findViewById(R.id.orderActivityButton);

    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.cartRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerAdapter = new CartAdapter();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

    }
    public double calculateTotalPrice(){
        double totalPrice = 0;
        for (MenuItem item: cart.items) {
            totalPrice += item.getPrice()*item.getQuantity();
        }
        return totalPrice;
    }



    public void goToOrder(View view){
        Intent orderIntent = new Intent(getApplicationContext(),OrderActivity.class);
        orderIntent.putExtra("totalPrice", calculateTotalPrice());
        startActivity(orderIntent);
    }

}