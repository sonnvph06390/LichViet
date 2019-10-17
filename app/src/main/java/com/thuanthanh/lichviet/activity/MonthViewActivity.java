package com.thuanthanh.lichviet.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.GioHoangDaoAdapter;
import com.thuanthanh.lichviet.model.GioHoangDao;

import java.util.ArrayList;
import java.util.List;

public class MonthViewActivity extends MonthViewBaseActivity implements CalendarView.OnCalendarSelectListener,
        View.OnClickListener {

    private CalendarView calendarView;
    private TextView tvDuongLichTop;
    private TextView tvDuongLich;
    private TextView tvAmLich;
    private RecyclerView rvHoangDao;
    private List<GioHoangDao> gioHoangDaos;
    private GridLayoutManager gridLayoutManager;
    private GioHoangDaoAdapter gioHoangDaoAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_month_view;
    }

    @Override
    protected void initView() {
        rvHoangDao = findViewById(R.id.rvGioHoangDao);
        gioHoangDaos = new ArrayList<>();
        gioHoangDaoAdapter = new GioHoangDaoAdapter(this, gioHoangDaos);
        rvHoangDao.setAdapter(gioHoangDaoAdapter);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rvHoangDao.setLayoutManager(gridLayoutManager);
        tvDuongLichTop = findViewById(R.id.tvDuongLichTop);
        tvDuongLich = findViewById(R.id.tvDuongLich);
        tvAmLich = findViewById(R.id.tvAmLich);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        tvDuongLichTop.setText(calendarView.getCurDay() + " tháng " + calendarView.getCurMonth());
        tvDuongLich.setText(calendarView.getCurDay() + " tháng " + calendarView.getCurMonth());
        calendarView.setOnCalendarSelectListener(this);
    }

    @Override
    protected void initData() {
        GioHoangDao gioHoangDao = new GioHoangDao(R.drawable.suu,"Sửu", "1h - 3h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.ngo,"Ngọ", "11h - 13h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.tuat,"Tuất", "19h - 21h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.thin,"Thìn", "7h - 9h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.mui,"Mùi", "13h - 15h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.hoi,"Hợi", "21h - 23h");
        gioHoangDaos.add(gioHoangDao);


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        tvDuongLichTop.setText(calendar.getDay() + " tháng " + calendar.getMonth());
        tvDuongLich.setText(calendar.getDay() + " tháng " + calendar.getMonth());
        tvAmLich.setText(calendar.getLunarCalendar().getDay() + " tháng " + calendar.getLunarCalendar().getMonth());
        if (isClick) {
            Toast.makeText(this, getCalendarText(calendar), Toast.LENGTH_SHORT).show();
        }
    }

    private static String getCalendarText(Calendar calendar) {
        return String.format("Lịch:%s \n Âm lịch %s \n Dương lịch：%s \n Tết âm lịch：%s \n Tiết khí：%s \n Có phải tháng nhuận không：%s",
                calendar.getMonth() + "tháng " + calendar.getDay() + " ngày",
                "ngày " + calendar.getLunarCalendar().getDay() + " tháng " + calendar.getLunarCalendar().getMonth(),
                TextUtils.isEmpty(calendar.getGregorianFestival()) ? "Không" : calendar.getGregorianFestival(),
                TextUtils.isEmpty(calendar.getTraditionFestival()) ? "Không" : calendar.getTraditionFestival(),
                TextUtils.isEmpty(calendar.getSolarTerm()) ? "Không" : calendar.getSolarTerm(),
                calendar.getLeapMonth() == 0 ? "Không" : String.format("Nhuận %s tháng", calendar.getLeapMonth()));
    }
}
