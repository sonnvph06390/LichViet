package com.thuanthanh.lichviet.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;

public class TuoiXungThangHolder extends RecyclerView.ViewHolder {
    public ImageView imgHoangDao;
    public TextView tvConGiap;
    public TextView tvHoangDao;

    public TuoiXungThangHolder(@NonNull View itemView) {
        super(itemView);
        imgHoangDao = (ImageView) itemView.findViewById(R.id.imgHoangDao);
        tvConGiap = (TextView) itemView.findViewById(R.id.tvConGiap);
        tvHoangDao = (TextView) itemView.findViewById(R.id.tvHoangDao);
    }
}
