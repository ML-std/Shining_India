package com.example.shiningindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.shiningindia.Menu.MenuActivity;
import com.example.shiningindia.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity {

     EditText phoneText, passwordText;
     Button mLoginButton;
     ImageView showPassBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginButton = findViewById(R.id.registerButton);
        phoneText = findViewById(R.id.phoneText);
        passwordText = findViewById(R.id.passwordText);
        showPassBox = findViewById(R.id.showPassBox);
    }

    public void startRegister(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }
    public void login(View view){
        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }
    public void showHidePass(View view){
        if(view.getId()==R.id.showPassBox){

            if(passwordText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                showPassBox.setImageResource(R.drawable.hide_password);

                //Show Password
                passwordText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                showPassBox.setImageResource(R.drawable.show_password);

                //Hide Password
                passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
    }
}