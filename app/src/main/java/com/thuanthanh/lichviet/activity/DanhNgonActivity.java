package com.thuanthanh.lichviet.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

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
    private TabLayout tabLayout2;
    ViewPager viewPager;
    TabScrollDanhNgonAdapter viewPagerAdapter;
    ArrayList<Fragment> fragments;
    ArrayList<String> titles = new ArrayList<>();
    String[] listitle = new String[]{"Yêu thích","Ca dao - tục ngữ","Phật giáo",
            "Tình yêu","Hôn nhân","Gia đình","Tình  bạn","Động lực","Thành công","Công việc"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ngon);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout2 = findViewById(R.id.tabLayout2);
        viewPager = findViewById(R.id.view_pager);
//        titles = new ArrayList<>();
        cargarTitles();
        cargarFragment();
        ViewPagerEnTabLayout();
        setupTabIcons();




    }

    private void setupTabIcons() {
        for (int i = 0; i < 10; i++) {
            TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tablayout, null);
            tab.setText(listitle[i]);
            tab.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.i_1nam, 0, 0);
            tabLayout.getTabAt(i).setCustomView(tab);
        }
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

        titles.add("Yêu thích");
        titles.add("Ca dao - tục ngữ");
        titles.add("Phật giáo");
        titles.add("Tình yêu");
        titles.add("Hôn nhân");
        titles.add("Gia đình");
        titles.add("Tình  bạn");
        titles.add("Động lực");
        titles.add("Thành công");
        titles.add("Công việc");

    }

    private void ViewPagerEnTabLayout() {
        viewPagerAdapter = new TabScrollDanhNgonAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout2.setupWithViewPager(viewPager);
    }
}
