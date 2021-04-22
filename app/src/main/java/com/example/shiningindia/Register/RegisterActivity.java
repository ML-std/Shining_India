package com.example.shiningindia.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shiningindia.MainActivity;
import com.example.shiningindia.R;

public class RegisterActivity extends AppCompatActivity {
    EditText phoneNumberText, passwordText, passwordText2;
    CheckBox showPassBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phoneNumberText = findViewById(R.id.phoneNumberText);
        passwordText = findViewById(R.id.createPasswordText);
        passwordText2 = findViewById(R.id.createPasswordText2);
        showPassBox = findViewById(R.id.showPassBox);
        showPassword();
    }
    public void register(View view){
        if (passwordText.getText().equals(passwordText2.getText())){
            Toast.makeText(getApplicationContext(),"You have been registered!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else {
            Toast.makeText(getApplicationContext(),"The Passwords do not match",Toast.LENGTH_LONG).show();
        }
    }
    public void showPassword(){
        showPassBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    passwordText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        if (showPassBox.isSelected()){

        }
        else {

        }
    }
}