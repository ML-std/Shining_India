package com.example.shiningindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity {
     Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginButton = (Button) findViewById(R.id.registerButton);
    }

    public void startRegister(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }
    public void Login(View view){
        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }


}