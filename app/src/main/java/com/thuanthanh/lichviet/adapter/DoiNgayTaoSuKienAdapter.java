package com.thuanthanh.lichviet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.DoiNgayTaoSukien;

import java.util.ArrayList;

public class DoiNgayTaoSuKienAdapter extends RecyclerView.Adapter<DoiNgayTaoSuKienAdapter.MyViewHolder> {
    private ArrayList<DoiNgayTaoSukien> doiNgayTaoSukiens = new ArrayList<>();

    public DoiNgayTaoSuKienAdapter(ArrayList<DoiNgayTaoSukien> doiNgayTaoSukiens) {
        this.doiNgayTaoSukiens = doiNgayTaoSukiens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doingay_taosukien, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.btnDoingay.setText(doiNgayTaoSukiens.get(position).getDoiNgay());
        holder.btnTaosukien.setText(doiNgayTaoSukiens.get(position).getTaoSuKien());
        holder.btnXemngaytot.setText(doiNgayTaoSukiens.get(position).getXemNgayTot());
    }

    @Override
    public int getItemCount() {
        return doiNgayTaoSukiens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Button btnDoingay;
        private Button btnTaosukien;
        private Button btnXemngaytot;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDoingay = (Button) itemView.findViewById(R.id.btn_doingay);
            btnTaosukien = (Button) itemView.findViewById(R.id.btn_taosukien);
            btnXemngaytot = (Button) itemView.findViewById(R.id.btn_xemngaytot);
        }
    }
}
