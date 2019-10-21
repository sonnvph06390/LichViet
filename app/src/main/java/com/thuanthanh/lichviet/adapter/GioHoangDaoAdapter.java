package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.GioHoangDao;

import java.util.List;

public class GioHoangDaoAdapter extends RecyclerView.Adapter<HoangDaoHolder> {
    Context context;
    List<GioHoangDao> gioHoangDaos;

    public GioHoangDaoAdapter(Context context, List<GioHoangDao> gioHoangDaos) {
        this.context = context;
        this.gioHoangDaos = gioHoangDaos;
    }

    @NonNull
    @Override
    public HoangDaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gio_hoang_dao, parent, false);
        return new HoangDaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoangDaoHolder holder, int position) {
        GioHoangDao gioHoangDao = gioHoangDaos.get(position);
        holder.tvHoangDao.setText(gioHoangDao.getGioHoangDao());
        holder.tvConGiap.setText(gioHoangDao.getConGiap());
        holder.imgHoangDao.setImageResource(gioHoangDao.getImgHoangDao());
//        Glide.with(context).load(gioHoangDao.getImgHoangDao()).into(holder.imgHoangDao);
    }

    @Override
    public int getItemCount() {
        return gioHoangDaos.size();
    }
}
