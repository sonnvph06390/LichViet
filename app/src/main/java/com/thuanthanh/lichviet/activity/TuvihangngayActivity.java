package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.CongiapAdapter;
import com.thuanthanh.lichviet.model.Congiap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TuvihangngayActivity extends AppCompatActivity {
    private ImageView imageViewToolbar;
    private RecyclerView recyclerView;
    private ArrayList<Congiap> congiaps;
    private TextView textView;
    CongiapAdapter congiapAdapter;
    private int[] myImageList = new int[]{R.drawable.i_ty_tvhn, R.drawable.i_suu_tvhn, R.drawable.i_dan_tvhn, R.drawable.i_mao_tvhn, R.drawable.i_thin_tvhn, R.drawable.i_ty_tvhn, R.drawable.i_ngo_tvhn, R.drawable.i_mui_tvhn, R.drawable.i_than_tvhn, R.drawable.i_dau_tvhn, R.drawable.i_tuat_tvhn, R.drawable.i_hoi_tvhn};
    private String[] myImageNameList = new String[]{"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuvihangngay);
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String timeStamp = new SimpleDateFormat("EEEE-dd/MM/yyyy").format(Calendar.getInstance().getTime());
        textView = findViewById(R.id.tvtuvi);
        textView.setText(timeStamp);

        recyclerView = findViewById(R.id.recycler);

        congiaps = new ArrayList<>();
        for (int i = 0; i < myImageList.length; i++) {
            Congiap congiap = new Congiap(myImageNameList[i], myImageList[i]);
            congiaps.add(congiap);

        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TuvihangngayActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        congiapAdapter = new CongiapAdapter(TuvihangngayActivity.this, congiaps);
        recyclerView.setAdapter(congiapAdapter);
    }
}

