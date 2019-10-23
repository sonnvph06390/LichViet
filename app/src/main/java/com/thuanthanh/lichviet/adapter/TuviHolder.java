package com.thuanthanh.lichviet.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;

public class TuviHolder extends RecyclerView.ViewHolder {
    public ImageView imgTuVi;
    public TextView tvTuVi;

    public TuviHolder(@NonNull View itemView) {
        super(itemView);
        imgTuVi = (ImageView) itemView.findViewById(R.id.imgTuVi);
        tvTuVi = (TextView) itemView.findViewById(R.id.tvTuVi);

    }
}
