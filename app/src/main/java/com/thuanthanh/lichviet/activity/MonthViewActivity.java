package com.thuanthanh.lichviet.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.GioHoangDaoAdapter;
import com.thuanthanh.lichviet.adapter.ThoiTietAdapter;
import com.thuanthanh.lichviet.adapter.TuViAdapter;
import com.thuanthanh.lichviet.adapter.TuoiXungNgayAdapter;
import com.thuanthanh.lichviet.adapter.TuoiXungThangAdapter;
import com.thuanthanh.lichviet.adapter.XuatHanhAdapter;
import com.thuanthanh.lichviet.model.GioHoangDao;
import com.thuanthanh.lichviet.model.PerHour.PerHour;
import com.thuanthanh.lichviet.model.TuVi;
import com.thuanthanh.lichviet.model.TuViBoiToan;
import com.thuanthanh.lichviet.model.TuoiXungNgay;
import com.thuanthanh.lichviet.model.TuoiXungThang;
import com.thuanthanh.lichviet.model.XuatHanh;
import com.thuanthanh.lichviet.retrofit.Retrofit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MonthViewActivity extends MonthViewBaseActivity implements CalendarView.OnCalendarSelectListener,
        View.OnClickListener {

    private CalendarView calendarView;
    private TextView tvDuongLichTop;
    private TextView tvDuongLich;
    private TextView tvAmLich;

    //Gio hoang dao
    private RecyclerView rvHoangDao;
    private List<GioHoangDao> gioHoangDaos;
    private GridLayoutManager gridLayoutManager;
    private GioHoangDaoAdapter gioHoangDaoAdapter;

    //Tuoi xung theo ngay
    private RecyclerView rvTuoiXungNgay;
    private List<TuoiXungNgay> tuoiXungNgays;
    private TuoiXungNgayAdapter tuoiXungNgayAdapter;

    //Tuoi xung theo thang
    private RecyclerView rvTuoiXungThang;
    private List<TuoiXungThang> tuoiXungThangs;
    private TuoiXungThangAdapter tuoiXungThangAdapter;

    //Xuat hanh
    private RecyclerView rvXuatHanh;
    private List<XuatHanh> xuatHanhs;
    private XuatHanhAdapter xuatHanhAdapter;

    //Tu Vi
    private RecyclerView rvTuVi;
    private List<TuVi> tuVis;
    private TuViAdapter tuViAdapter;

    //thoi tiet
    private ImageView imgIcon;
    private TextView tvNhietDo;
    private TextView tvCloud;
    private TextView tvNgay;
    private ImageView imgNgay;
    private TextView tvDem;
    private ImageView imgDem;
    private RecyclerView rvThoiTiet;
    private List<PerHour> perHours;
    private ThoiTietAdapter thoiTietAdapter;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_month_view;
    }

    @Override
    protected void initView() {
        tvDuongLichTop = findViewById(R.id.tvDuongLichTop);
        tvDuongLich = findViewById(R.id.tvDuongLich);
        tvAmLich = findViewById(R.id.tvAmLich);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        tvDuongLichTop.setText(calendarView.getCurDay() + " tháng " + calendarView.getCurMonth());
        tvDuongLich.setText(calendarView.getCurDay() + " tháng " + calendarView.getCurMonth());
        calendarView.setOnCalendarSelectListener(this);

        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        tvNhietDo = (TextView) findViewById(R.id.tvNhietDo);
        tvCloud = (TextView) findViewById(R.id.tvCloud);
        tvNgay = (TextView) findViewById(R.id.tvNgay);
        imgNgay = (ImageView) findViewById(R.id.imgNgay);
        tvDem = (TextView) findViewById(R.id.tvDem);
        imgDem = (ImageView) findViewById(R.id.imgDem);

        //Gio hoang dao
        rvHoangDao = findViewById(R.id.rvGioHoangDao);
        gioHoangDaos = new ArrayList<>();
        gioHoangDaoAdapter = new GioHoangDaoAdapter(this, gioHoangDaos);
        rvHoangDao.setAdapter(gioHoangDaoAdapter);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rvHoangDao.setLayoutManager(gridLayoutManager);

        //Tuoi xung theo ngay
        rvTuoiXungNgay = findViewById(R.id.rvTuoiXungNgay);
        tuoiXungNgays = new ArrayList<>();
        tuoiXungNgayAdapter = new TuoiXungNgayAdapter(this, tuoiXungNgays);
        rvTuoiXungNgay.setAdapter(tuoiXungNgayAdapter);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rvTuoiXungNgay.setLayoutManager(gridLayoutManager);

        //Tuoi xung theo ngay
        rvTuoiXungThang = findViewById(R.id.rvTuoiXungthang);
        tuoiXungThangs = new ArrayList<>();
        tuoiXungThangAdapter = new TuoiXungThangAdapter(this, tuoiXungThangs);
        rvTuoiXungThang.setAdapter(tuoiXungThangAdapter);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rvTuoiXungThang.setLayoutManager(gridLayoutManager);

        //Xuat hanh
        rvXuatHanh = findViewById(R.id.rvXuatHanh);
        xuatHanhs = new ArrayList<>();
        xuatHanhAdapter = new XuatHanhAdapter(this, xuatHanhs);
        rvXuatHanh.setAdapter(xuatHanhAdapter);
        gridLayoutManager = new GridLayoutManager(this, 3);
        rvXuatHanh.setLayoutManager(gridLayoutManager);

        //Tu vi
        rvTuVi = findViewById(R.id.rvTuVi);
        tuVis = new ArrayList<>();
        tuViAdapter = new TuViAdapter(this, tuVis);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvTuVi.setLayoutManager(linearLayoutManager);
        rvTuVi.setAdapter(tuViAdapter);

        //thoi tiet
        rvThoiTiet = findViewById(R.id.rvThoiTiet);
        perHours = new ArrayList<>();
        thoiTietAdapter = new ThoiTietAdapter(this, perHours);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvThoiTiet.setHasFixedSize(true);
        rvThoiTiet.setLayoutManager(linearLayoutManager);
        rvThoiTiet.setAdapter(thoiTietAdapter);

        GetReatrofitPerHourData();

        GetCurrentData();
    }

    private void GetCurrentData() {
        RequestQueue requestQueue = Volley.newRequestQueue(MonthViewActivity.this);
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/353412?" +
                "apikey=pOSruJBxzbxVkFigGWS4JpG9ayGE3Nzp&language=vi";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArrayDailyForecasts = jsonObject.getJSONArray("DailyForecasts");
                            JSONObject jsonObjectWeather = jsonArrayDailyForecasts.getJSONObject(0);

                            String time = jsonObjectWeather.getString("EpochDate");
                            long l = Long.valueOf(time);
                            Date date = new Date(l * 1000);
                            //EEEE - yyyy-MM-dd HH-mm-ss
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                            String ngay = simpleDateFormat.format(date);
                            tvCloud.setText(ngay);

                            Date today = new Date(System.currentTimeMillis());
                            SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
                            String s = timeFormat.format(today.getTime());

                            Log.e("Time", s + "");

                            //Nhiet do
                            JSONObject jsonObjectTemperature = jsonObjectWeather.getJSONObject("Temperature");
                            JSONObject jsonObjectMin = jsonObjectTemperature.getJSONObject("Minimum");
                            int nhietDoMin = jsonObjectMin.getInt("Value");

                            JSONObject jsonObjectMax = jsonObjectTemperature.getJSONObject("Maximum");
                            int nhietDoMax = jsonObjectMax.getInt("Value");

                            int doCMin = (int) ((nhietDoMin - 32) / 1.80000);
                            int doCMax = (int) ((nhietDoMax - 32) / 1.80000);

                            tvNhietDo.setText(doCMin + "°C" + " - " + doCMax + "°C");

                            //Icon
                            JSONObject jsonObjectDay = jsonObjectWeather.getJSONObject("Day");
                            String day = jsonObjectDay.getString("IconPhrase");
                            tvNgay.setText(day);
                            String iconDay = jsonObjectDay.getString("Icon");
                            Glide.with(MonthViewActivity.this).load("https://www.accuweather.com/images/weathericons/" + iconDay + ".svg").into(imgNgay);

                            JSONObject jsonObjectNight = jsonObjectWeather.getJSONObject("Night");
                            String night = jsonObjectNight.getString("IconPhrase");
                            tvDem.setText(night);
                            String iconNight = jsonObjectNight.getString("Icon");
                            Glide.with(MonthViewActivity.this).load("https://www.accuweather.com/images/weathericons/" + iconNight + ".svg").into(imgDem);

                            java.util.Calendar openingHour = java.util.Calendar.getInstance();
                            openingHour.set(java.util.Calendar.HOUR_OF_DAY, 18);
                            openingHour.set(java.util.Calendar.MINUTE, 00);
                            openingHour.set(java.util.Calendar.SECOND, 0);
                            openingHour.set(java.util.Calendar.MILLISECOND, 0);
                            java.util.Calendar currentTime = java.util.Calendar.getInstance();
//                            int dayOfWeek = currentTime.get(java.util.Calendar.DAY_OF_WEEK);
                            if(currentTime.after(openingHour)){
                                Glide.with(MonthViewActivity.this).load("https://www.accuweather.com/images/weathericons/" + iconNight + ".svg").into(imgIcon);
                            } else {
                                Glide.with(MonthViewActivity.this).load("https://www.accuweather.com/images/weathericons/" + iconDay + ".svg").into(imgIcon);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }

    private void GetReatrofitPerHourData() {
        Retrofit.getInstance().getPerHourWeatherData().enqueue(new Callback<List<PerHour>>() {
            @Override
            public void onResponse(Call<List<PerHour>> call, retrofit2.Response<List<PerHour>> response) {
                if (response.code() == 200) {
                    perHours.addAll(response.body());
                    thoiTietAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(MonthViewActivity.this, "Lỗi mạng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PerHour>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    @Override
    protected void initData() {
        //Gio hoang dao
        GioHoangDao gioHoangDao = new GioHoangDao(R.drawable.suu, "Sửu", "1h - 3h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.ngo, "Ngọ", "11h - 13h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.tuat, "Tuất", "19h - 21h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.thin, "Thìn", "7h - 9h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.mui, "Mùi", "13h - 15h");
        gioHoangDaos.add(gioHoangDao);

        gioHoangDao = new GioHoangDao(R.drawable.hoi, "Hợi", "21h - 23h");
        gioHoangDaos.add(gioHoangDao);

        //Tuoi xung ngay
        TuoiXungNgay tuoiXungNgay = new TuoiXungNgay(R.drawable.tuat, "Nhâm Thìn", "Thổ");
        tuoiXungNgays.add(tuoiXungNgay);

        tuoiXungNgay = new TuoiXungNgay(R.drawable.tuat, "Giáp Tuất", "Hoả");
        tuoiXungNgays.add(tuoiXungNgay);

        tuoiXungNgay = new TuoiXungNgay(R.drawable.dan, "Binh Dần", "Hoả");
        tuoiXungNgays.add(tuoiXungNgay);

        //Tuoi xung thang
        TuoiXungThang tuoiXungThang = new TuoiXungThang(R.drawable.thin, "Nhâm Thìn", "Thuỷ");
        tuoiXungThangs.add(tuoiXungThang);

        tuoiXungThang = new TuoiXungThang(R.drawable.thin, "Canh Thìn", "Kim");
        tuoiXungThangs.add(tuoiXungThang);

        tuoiXungThang = new TuoiXungThang(R.drawable.tuat, "Canh Tuất", "Kim");
        tuoiXungThangs.add(tuoiXungThang);

        //Xuat hanh
        XuatHanh xuatHanh = new XuatHanh(R.drawable.i_hythan, "Hỷ thần", "Đông Nam");
        xuatHanhs.add(xuatHanh);

        xuatHanh = new XuatHanh(R.drawable.i_taithan, "Tài thần", "Tây Bắc");
        xuatHanhs.add(xuatHanh);

        xuatHanh = new XuatHanh(R.drawable.i_hacthan, "Hạc thần", "Tây Bắc");
        xuatHanhs.add(xuatHanh);

        //Tu vi
        TuVi tuVi = new TuVi(R.drawable.i_tuvihangngay, "Tử Vi Hằng Ngày");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_nhipsinhhoc, "Nhịp Sinh Học");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_vankhan, "Văn Khấn");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_guithiep, "Thiệp Chúc Mừng");
        tuVis.add(tuVi);

        tuVi =new TuVi(R.drawable.ic_tuvi_2019, "Tử Vi 2019");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_tuvitrondoi, "Tử Vi Trọn Đời");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_boitinhduyen, "Bói Tình Duyên");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_laban, "La Bàn");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_giaimong, "Giải Mộng");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_thuocloban, "Thước Lỗ Ban");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_cunghoangdao, "Cung Hoàng Đạo");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_xemsao, "Xem Sao");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_xemngaytot, "Xem Ngày Tốt");
        tuVis.add(tuVi);

        tuVi = new TuVi(R.drawable.i_doingay, "Đổi Ngày");
        tuVis.add(tuVi);

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

    public void onClickBackToMain(View view) {
        finish();
    }
}
