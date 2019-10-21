package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.thuanthanh.lichviet.R;

public class TaoSuKienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_su_kien);
        Toolbar toolbar = findViewById(R.id.tbtaosukien);
        setSupportActionBar(toolbar);
    }




}
