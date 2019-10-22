package com.thuanthanh.lichviet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.adapter.DanhNgonFragmentAdapter;
import com.thuanthanh.lichviet.model.DanhNgon;
import com.thuanthanh.lichviet.model.DanhNgonAuth;

import java.util.ArrayList;
import java.util.List;

public class DanhNgonFragment extends Fragment {
    RecyclerView recyclerView;
    List<DanhNgonAuth>danhNgons;
    DanhNgonFragmentAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = view.findViewById(R.id.rcv_fragment_danhngon);
        danhNgons = new ArrayList<DanhNgonAuth>();
        for (int i=0; i<50; i++){
            danhNgons.add(new DanhNgonAuth("Dù ai đi ngược về xuôi nhớ ngày giỗ tổ mùng 10 tháng 3", "Khuyết danh "+i));
        }
        adapter = new DanhNgonFragmentAdapter(getContext(),danhNgons );
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

}
