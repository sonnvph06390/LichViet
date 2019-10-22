package com.thuanthanh.lichviet.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.activity.TaoSuKienActivity;
import com.thuanthanh.lichviet.activity.VietSuKienActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SuKiennFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.su_kien_fragment, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                startActivity(new Intent(activity, TaoSuKienActivity.class));
            }
        });

        TextView textView = (TextView) view.findViewById(R.id.tvthangnam);
        SimpleDateFormat sdf = new SimpleDateFormat("MM - yyyy");
        String aaa = sdf.format(new Date());
        textView.setText("Tháng\t" + aaa);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_main);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        drawer = view.findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.icons8_menu_40);



        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        CalendarView simpleCalendarView = (CalendarView) view.findViewById(R.id.simpleCalendarView);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.

        inflater.inflate(R.menu.fragment_drawer, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        int id = menuItem.getItemId();


        switch (menuItem.getItemId()) {

            case R.id.nav_sukien:
                // Handle the camera action
                break;

            case R.id.nav_viechy:

                swapActivity();

                break;

            case R.id.nav_ngaygio:

                break;


            case R.id.nav_canhan:

                break;
            case R.id.nav_giadinh:

                break;

            case R.id.nav_congviec:

                break;

            case R.id.nav_sinhnhat:

                break;

            case R.id.nav_henho:

                break;

            case R.id.nav_kiniem:

                break;

            case R.id.nav_khac:

                break;

            case R.id.nav_ngayram:

                break;


            case R.id.nav_ngayle:

                break;


            case R.id.nav_mail:

                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void swapActivity() {

        startActivity(new Intent(getContext(), VietSuKienActivity.class));

    }


}
