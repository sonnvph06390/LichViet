package com.thuanthanh.lichviet.activity;


import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thuanthanh.lichviet.R;

import com.thuanthanh.lichviet.fragment.HomeFragment;
import com.thuanthanh.lichviet.fragment.LichVN_Fragment;

import com.thuanthanh.lichviet.fragment.TuviFragment;


import com.thuanthanh.lichviet.fragment.SuKiennFragment;


public class MainActivity extends BaseActivity {
    private BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnavigation = findViewById(R.id.bottom_navigation);
        bottomnavigation.setOnNavigationItemSelectedListener(navListener);
        loadFragment(new HomeFragment());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
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
                    fragment = new SuKiennFragment();
                    loadFragment( fragment);
                    return  true;

                case R.id.nav_tuvi:
                    fragment=new TuviFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();

    }


}
