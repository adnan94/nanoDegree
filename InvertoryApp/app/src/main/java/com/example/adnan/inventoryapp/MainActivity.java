package com.example.adnan.inventoryapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout Tablayout = (TabLayout) findViewById(R.id.tab_layout);
        pager = (ViewPager) findViewById(R.id.view_pager);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        String[] titles = {"Products","Sales Details"};

        pager.setAdapter(new pagerAdapter(manager, titles));
        Tablayout.setupWithViewPager(pager);


    }
}
