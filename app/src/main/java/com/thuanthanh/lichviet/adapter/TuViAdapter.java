package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.TuVi;

import java.util.List;

public class TuViAdapter extends RecyclerView.Adapter<TuviHolder> {
    Context context;
    List<TuVi> tuVis;

    public TuViAdapter(Context context, List<TuVi> tuVis) {
        this.context = context;
        this.tuVis = tuVis;
    }

    @NonNull
    @Override
    public TuviHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tu_vi, parent, false);
        return new TuviHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TuviHolder holder, int position) {
        TuVi tuVi = tuVis.get(position);
        holder.imgTuVi.setImageResource(tuVi.getImgTuVi());
        holder.tvTuVi.setText(tuVi.getTvTuVi());
    }

    @Override
    public int getItemCount() {
        return tuVis.size();
    }
}
