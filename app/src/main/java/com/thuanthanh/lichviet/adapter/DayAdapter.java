package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.ItemClickListener;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.activity.MonthViewActivity;
import com.thuanthanh.lichviet.model.Day;

import java.util.ArrayList;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder> {
    private ArrayList<Day> days = new ArrayList<>();
    Context context;

    public DayAdapter(ArrayList<Day> days, Context context) {
        this.days = days;
        this.context = context;
    }

//    public DayAdapter(ArrayList<Day> days) {
//        this.days = days;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.btnSoSukien.setText(days.get(position).getSoSuKien());
        holder.tvDayOfWeek.setText(days.get(position).getDayOfWeek());
        holder.tvLichDuong.setText(days.get(position).getNgayThangDuong());
        holder.tvLichAm.setText(days.get(position).getNgayThangAm());
        holder.tvGioAm.setText(days.get(position).getGioAm());
        holder.tvTuoiXung.setText(days.get(position).getTuoiXung());
        holder.tvGioHoangDao.setText(days.get(position).getGioHoangDao());
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick) {
//                if (isLongClick) {
//                    Toast.makeText(view.getContext(), "Long Click: " + days.get(position), Toast.LENGTH_SHORT).show();
//                } else
//                    Toast.makeText(view.getContext(), " " + days.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
        holder.btnSoSukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MonthViewActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private Button btnSoSukien;
        private TextView tvDayOfWeek;
        private TextView tvLichDuong;
        private TextView tvLichAm;
        private TextView tvGioAm;
        private TextView tvTuoiXung;
        private TextView tvGioHoangDao;

        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            btnSoSukien = (Button) itemView.findViewById(R.id.btn_SoSukien);
            tvDayOfWeek = (TextView) itemView.findViewById(R.id.tvDayOfWeek);
            tvLichDuong = (TextView) itemView.findViewById(R.id.tvLichDuong);
            tvLichAm = (TextView) itemView.findViewById(R.id.tvLichAm);
            tvGioAm = (TextView) itemView.findViewById(R.id.tvGioAm);
            tvTuoiXung = (TextView) itemView.findViewById(R.id.tvTuoiXung);
            tvGioHoangDao = (TextView) itemView.findViewById(R.id.tvGioHoangDao);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }


        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
