package com.example.CityOfLightsFLL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button btn = findViewById(R.id.start_use);
        btn.setBackgroundResource(R.drawable.button_shape);
        btn.setOnClickListener(View -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}