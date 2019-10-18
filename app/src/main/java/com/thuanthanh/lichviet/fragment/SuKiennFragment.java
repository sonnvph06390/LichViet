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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.activity.VietSuKienActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuKiennFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.su_kien_fragment, container, false);


        TextView textView = (TextView) view.findViewById(R.id.tvthangnam);
        SimpleDateFormat sdf = new SimpleDateFormat("MM - yyyy");
        String aaa = sdf.format(new Date());
        textView.setText("Thang\t"+aaa);



        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_main);


        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = view.findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CalendarView simpleCalendarView = (CalendarView) view.findViewById(R.id.simpleCalendarView);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Lịch cá nhân");
    }

//    @Override
//    public void onBackPressed() {
//
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBac();
//        }
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.

        inflater.inflate(R.menu.menu_right, menu);
        inflater.inflate(R.menu.activity_main_drawer, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

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

                swapFragment();

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

    private void swapFragment() {

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        startActivity(new Intent(activity, VietSuKienActivity.class));

    }
}
