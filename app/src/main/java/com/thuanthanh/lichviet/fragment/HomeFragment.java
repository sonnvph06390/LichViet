package com.thuanthanh.lichviet.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.MainFragmentAdapter;
import com.thuanthanh.lichviet.model.DanhNgon;
import com.thuanthanh.lichviet.model.Day;
import com.thuanthanh.lichviet.model.TuViBoiToan;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    private RelativeLayout toobarFragmentHome;
    private RecyclerView rcvFragmentHome;
    private ArrayList<Object> objects = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toobarFragmentHome = (RelativeLayout) view.findViewById(R.id.toobarFragmentHome);
        rcvFragmentHome = (RecyclerView) view.findViewById(R.id.rcv_fragment_home);
        MainFragmentAdapter adapter = new MainFragmentAdapter(getContext(), getObject());
        rcvFragmentHome.setAdapter(adapter);
        rcvFragmentHome.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private ArrayList<Object> getObject() {
        objects.add(getDayData().get(0));
        objects.add(getTuviboitoanData().get(0));
        objects.add(getDanhNgonData().get(0));
        return objects;
    }

    public static ArrayList<TuViBoiToan> getTuviboitoanData() {
        ArrayList<TuViBoiToan> tuViBoiToans = new ArrayList<>();
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvihangngay, "Tử Vi Hằng Ngày"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_nhipsinhhoc, "Nhịp Sinh Học"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_vankhan, "Văn Khấn"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_guithiep, "Thiệp Chúc Mừng"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.ic_tuvi_2019, "Tử Vi 2019"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvitrondoi, "Tử Vi Trọn Đời"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_boitinhduyen, "Bói Tình Duyên"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_laban, "La Bàn"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_giaimong, "Giải Mộng"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_thuocloban, "Thước Lỗ Ban"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_cunghoangdao, "Cung Hoàng Đạo"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_xemsao, "Xem Sao"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_xemngaytot, "Xem Ngày Tốt"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_doingay, "Đổi Ngày"));

        return tuViBoiToans;

    }

    public static ArrayList<Day> getDayData() {
        ArrayList<Day> days = new ArrayList<>();
        days.add(new Day("Thu nam", "17 thang 10", "19 thang 9, Ky Hoi",
                "Gio dinh mui", "Tuoi xung: ky ty", "Gio hoang dao", "3 su kien"));
        return days;
    }

    public static ArrayList<DanhNgon> getDanhNgonData() {
        ArrayList<DanhNgon> danhNgons = new ArrayList<>();
        danhNgons.add(new DanhNgon(R.drawable.btn_chiase_white, "Khong co gi quy hon doc lap tu do", "J.J.R"));
        return danhNgons;

    }

}
