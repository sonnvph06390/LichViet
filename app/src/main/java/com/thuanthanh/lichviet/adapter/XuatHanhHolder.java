package com.thuanthanh.lichviet.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;

public class XuatHanhHolder extends RecyclerView.ViewHolder {
    public ImageView imgXuatHanh;
    public TextView tvThan;
    public TextView tvHuong;

    public XuatHanhHolder(@NonNull View itemView) {
        super(itemView);
        imgXuatHanh = (ImageView) itemView.findViewById(R.id.imgXuatHanh);
        tvThan = (TextView) itemView.findViewById(R.id.tvThan);
        tvHuong = (TextView) itemView.findViewById(R.id.tvHuong);
    }
}
