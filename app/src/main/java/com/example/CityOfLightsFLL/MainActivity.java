package com.example.CityOfLightsFLL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button about_us = findViewById(R.id.about_us_main);
        about_us.setBackgroundResource(R.drawable.button_shape);
    }
}