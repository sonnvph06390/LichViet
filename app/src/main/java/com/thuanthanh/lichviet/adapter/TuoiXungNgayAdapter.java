package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.GioHoangDao;
import com.thuanthanh.lichviet.model.TuoiXungNgay;

import java.util.List;

public class TuoiXungNgayAdapter extends RecyclerView.Adapter<TuoiXungNgayHolder> {
    Context context;
    List<TuoiXungNgay> tuoiXungNgays;

    public TuoiXungNgayAdapter(Context context, List<TuoiXungNgay> tuoiXungNgays) {
        this.context = context;
        this.tuoiXungNgays = tuoiXungNgays;
    }

    @NonNull
    @Override
    public TuoiXungNgayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gio_hoang_dao, parent, false);
        return new TuoiXungNgayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TuoiXungNgayHolder holder, int position) {
        TuoiXungNgay tuoiXungNgay = tuoiXungNgays.get(position);
        holder.tvHoangDao.setText(tuoiXungNgay.getNguHanh());
        holder.tvConGiap.setText(tuoiXungNgay.getConGiap());
        holder.imgHoangDao.setImageResource(tuoiXungNgay.getImgTuoiXungNgay());
    }

    @Override
    public int getItemCount() {
        return tuoiXungNgays.size();
    }
}
