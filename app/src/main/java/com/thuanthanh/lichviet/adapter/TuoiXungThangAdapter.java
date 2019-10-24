package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.TuoiXungNgay;
import com.thuanthanh.lichviet.model.TuoiXungThang;

import java.util.List;

public class TuoiXungThangAdapter extends RecyclerView.Adapter<TuoiXungThangHolder> {
    Context context;
    List<TuoiXungThang> tuoiXungThangs;

    public TuoiXungThangAdapter(Context context, List<TuoiXungThang> tuoiXungThangs) {
        this.context = context;
        this.tuoiXungThangs = tuoiXungThangs;
    }

    @NonNull
    @Override
    public TuoiXungThangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gio_hoang_dao, parent, false);
        return new TuoiXungThangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TuoiXungThangHolder holder, int position) {
        TuoiXungThang tuoiXungThang = tuoiXungThangs.get(position);
        holder.tvHoangDao.setText(tuoiXungThang.getNguHanh());
        holder.tvConGiap.setText(tuoiXungThang.getConGiap());
        holder.imgHoangDao.setImageResource(tuoiXungThang.getImgTuoiXungThang());
    }

    @Override
    public int getItemCount() {
        return tuoiXungThangs.size();
    }
}
