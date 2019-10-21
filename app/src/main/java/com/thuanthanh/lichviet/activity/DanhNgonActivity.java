package com.thuanthanh.lichviet.activity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.TabScrollDanhNgonAdapter;
import com.thuanthanh.lichviet.fragment.DanhNgonFragment;

import java.util.ArrayList;

public class DanhNgonActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    ViewPager viewPager;
    TabScrollDanhNgonAdapter viewPagerAdapter;
    ArrayList<Fragment> fragments;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ngon);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.view_pager);
        cargarTitles();
        cargarFragment();
        ViewPagerEnTabLayout();
    }

    private void cargarFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
        fragments.add(new DanhNgonFragment());
    }

    private void cargarTitles() {
        titles = new ArrayList<>();
        titles.add("Fragment1111111111");
        titles.add("Fragment22222222222");
        titles.add("Fragment3333333333");
        titles.add("Fragment444444444");
        titles.add("Fragment5555555555");
        titles.add("Fragment666666666666");
        titles.add("Fragment666666666666");
        titles.add("Fragment666666666666");
        titles.add("Fragment666666666666");
        titles.add("Fragment666666666666");

    }

    private void ViewPagerEnTabLayout() {
        viewPagerAdapter = new TabScrollDanhNgonAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
