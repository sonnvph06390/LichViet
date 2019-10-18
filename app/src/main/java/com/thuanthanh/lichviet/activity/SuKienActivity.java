package com.thuanthanh.lichviet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.thuanthanh.lichviet.R;

public class SuKienActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_su_kien);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
//        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFirstDayOfWeek(2);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_right, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
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
        int id = menuItem.getItemId();

        if (id == R.id.nav_sukien) {
            // Handle the camera action


        } else if (id == R.id.nav_viechy) {
            nextactivity();

        } else if (id == R.id.nav_ngaygio) {
            nextactivity();

        } else if (id == R.id.nav_canhan) {
            nextactivity();

        } else if (id == R.id.nav_giadinh) {
            nextactivity();

        } else if (id == R.id.nav_congviec) {
            nextactivity();

        } else if (id == R.id.nav_sinhnhat) {
            nextactivity();

        } else if (id == R.id.nav_henho) {
            nextactivity();

        } else if (id == R.id.nav_kiniem) {
            nextactivity();

        } else if (id == R.id.nav_khac) {
            nextactivity();

        } else if (id == R.id.nav_ngayram) {
            Toast.makeText(getApplicationContext(), "Tools is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_ngayle) {
            Toast.makeText(getApplicationContext(), "Tools is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_mail) {
            Toast.makeText(getApplicationContext(), "Tools is clicked", Toast.LENGTH_SHORT).show();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void nextactivity(){
        startActivity(new Intent(SuKienActivity.this, VietSuKienActivity.class));
    }

}
