package com.thuanthanh.lichviet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.Day;

import java.util.ArrayList;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder> {
    private ArrayList<Day> days = new ArrayList<>();

    public DayAdapter(ArrayList<Day> days) {
        this.days = days;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.btnSoSukien.setText(days.get(position).getSoSuKien());
        holder.tvDayOfWeek.setText(days.get(position).getDayOfWeek());
        holder.tvLichDuong.setText(days.get(position).getNgayThangDuong());
        holder.tvLichAm.setText(days.get(position).getNgayThangAm());
        holder.tvGioAm.setText(days.get(position).getGioAm());
        holder.tvTuoiXung.setText(days.get(position).getTuoiXung());
        holder.tvGioHoangDao.setText(days.get(position).getGioHoangDao());
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private Button btnSoSukien;
        private TextView tvDayOfWeek;
        private TextView tvLichDuong;
        private TextView tvLichAm;
        private TextView tvGioAm;
        private TextView tvTuoiXung;
        private TextView tvGioHoangDao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSoSukien = (Button) itemView.findViewById(R.id.btn_SoSukien);
            tvDayOfWeek = (TextView) itemView.findViewById(R.id.tvDayOfWeek);
            tvLichDuong = (TextView) itemView.findViewById(R.id.tvLichDuong);
            tvLichAm = (TextView) itemView.findViewById(R.id.tvLichAm);
            tvGioAm = (TextView) itemView.findViewById(R.id.tvGioAm);
            tvTuoiXung = (TextView) itemView.findViewById(R.id.tvTuoiXung);
            tvGioHoangDao = (TextView) itemView.findViewById(R.id.tvGioHoangDao);


        }
    }
}
