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
        objects.add(getTuviboitoanData().get(0));
        objects.add(getDanhNgonData().get(0));
        return objects;
    }

    public static ArrayList<TuViBoiToan> getTuviboitoanData() {
        ArrayList<TuViBoiToan> tuViBoiToans = new ArrayList<>();
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));
        tuViBoiToans.add(new TuViBoiToan(R.drawable.i_tuvi3x, "Tu vi hang ngay"));

        return tuViBoiToans;

    }
    public static ArrayList<DanhNgon> getDanhNgonData() {
        ArrayList<DanhNgon> danhNgons = new ArrayList<>();
        danhNgons.add(new DanhNgon(R.drawable.btn_chiase_white, "Khong co gi quy hon doc lap tu do","J.J.R"));
        return danhNgons;

    }

}
