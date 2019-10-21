package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.activity.DanhNgonActivity;
import com.thuanthanh.lichviet.model.DanhNgon;

import java.util.ArrayList;

public class DanhNgonAdapter extends RecyclerView.Adapter<DanhNgonAdapter.MyViewHolder> {
    private ArrayList<DanhNgon> danhNgons = new ArrayList<>();
    private Context context;
    public DanhNgonAdapter(ArrayList<DanhNgon> danhNgons,Context context) {
        this.danhNgons = danhNgons;
        this.context=context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cadao_danhngon, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgDanhNgonShare.setImageResource(R.drawable.btn_chiase_white);
        holder.tvDanhNgon.setText(danhNgons.get(position).getDanhngon());
        holder.tvTacGia.setText(danhNgons.get(position).getTacgia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DanhNgonActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return danhNgons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDanhNgonShare;
        TextView tvDanhNgon;
        TextView tvTacGia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDanhNgonShare = itemView.findViewById(R.id.img_share_danhngon);
            tvDanhNgon = itemView.findViewById(R.id.tv_danhngon);
            tvTacGia = itemView.findViewById(R.id.tvTacGia);

        }
    }
}
