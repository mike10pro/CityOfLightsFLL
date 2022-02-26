package com.example.CityOfLightsFLL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static String data;
    String var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button about_us = findViewById(R.id.about_us_main);
        about_us.setBackgroundResource(R.drawable.button_shape);
        Spinner sp = findViewById(R.id.spinner);
        final int[] v = new int[1];
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.list);
                v[0] = selectedItemPosition;
                var = choose[v[0]];
                if (var.equals("тест")) {
                    ServerUse.GetTest();
                    System.out.println(data);
                } else if (var.equals("журнал")) {
                    ServerUse.GetProblems();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}