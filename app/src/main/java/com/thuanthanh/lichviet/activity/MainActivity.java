package com.thuanthanh.lichviet.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.fragment.HomeFragment;
import com.thuanthanh.lichviet.fragment.LichVN_Fragment;
import com.thuanthanh.lichviet.fragment.SuKienFragment;

public class MainActivity extends BaseActivity {
    private BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomnavigation = findViewById(R.id.bottom_navigation);
        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int mScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(view, new ViewGroup.LayoutParams(mScreenWidth, mScreenHeight));
        bottomnavigation.setOnNavigationItemSelectedListener(navListener);
        loadFragment(new HomeFragment());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_vn_calendar:
                    fragment = new LichVN_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_event:
                case R.id.nav_tuvi:

            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        //   transaction.addToBackStack(null);
        transaction.commit();

    }
}
