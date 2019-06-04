package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailSctivity extends AppCompatActivity {
Toolbar toolbar;
ViewPager viewPager;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sctivity);
    toolbar = findViewById(R.id.toolbary);
    setSupportActionBar(toolbar);

    viewPager  = findViewById(R.id.viewpager);
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new itemcommfragment(),"COMMENT");
        adapter.addFragment(new itemupdatefragment(),"UPDATE");
        adapter.addFragment(new itempurcfragment(),"PURCHASE");
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabviewlay);
        tabLayout.setupWithViewPager(viewPager);



    }
}
