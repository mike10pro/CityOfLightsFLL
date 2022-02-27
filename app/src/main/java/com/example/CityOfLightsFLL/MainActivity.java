package com.example.CityOfLightsFLL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.list, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
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
                    FragmentManager fm = getFragmentManager();
                    Fragment f1 = new TestFragment();
                    Fragment f2 = new BookFragment();

                    if (savedInstanceState == null) {
                        FragmentTransaction fragmentTransaction = fm
                                .beginTransaction();
                        final String TAG_1 = "FRAGMENT_1";
                        fragmentTransaction.add(R.id.fragment, f2, TAG_1);
                        fragmentTransaction.commit();
                    }
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}