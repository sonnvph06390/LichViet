package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.TuoiXungNgay;
import com.thuanthanh.lichviet.model.XuatHanh;

import java.util.List;

public class XuatHanhAdapter extends RecyclerView.Adapter<XuatHanhHolder> {
    Context context;
    List<XuatHanh> xuatHanhs;

    public XuatHanhAdapter(Context context, List<XuatHanh> xuatHanhs) {
        this.context = context;
        this.xuatHanhs = xuatHanhs;
    }

    @NonNull
    @Override
    public XuatHanhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xuat_hanh, parent, false);
        return new XuatHanhHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull XuatHanhHolder holder, int position) {
        XuatHanh xuatHanh = xuatHanhs.get(position);
        holder.tvHuong.setText(xuatHanh.getHuong());
        holder.tvThan.setText(xuatHanh.getThan());
        holder.imgXuatHanh.setImageResource(xuatHanh.getImgXuatHanh());
    }

    @Override
    public int getItemCount() {
        return xuatHanhs.size();
    }
}
