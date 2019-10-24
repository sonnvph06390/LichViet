package com.thuanthanh.lichviet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.TuViBoiToan;

import java.util.List;

public class TuViBoiToanAdapter extends RecyclerView.Adapter<TuViBoiToanAdapter.MyViewHolder> {
    List<TuViBoiToan> tuViBoiToanList;

    public TuViBoiToanAdapter(List<TuViBoiToan> tuViBoiToanList) {
        this.tuViBoiToanList = tuViBoiToanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tuviboitoan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgTuvi.setImageResource(tuViBoiToanList.get(position).getImgTuvi());
        holder.tvTitleTuvi.setText(tuViBoiToanList.get(position).getTvTitleTuvi());
    }

    @Override
    public int getItemCount() {
        return tuViBoiToanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTuvi;
        TextView tvTitleTuvi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTuvi = itemView.findViewById(R.id.img_item_tuviboitoan);
            tvTitleTuvi = itemView.findViewById(R.id.tvTitleItemTuvi);
        }
    }
}
