package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.DanhNgonAuth;

import java.util.List;

public class DanhNgonFragmentAdapter extends RecyclerView.Adapter<DanhNgonFragmentAdapter.MyViewHolder> {
    Context context;
    List<DanhNgonAuth>listModel;

    public DanhNgonFragmentAdapter(Context context, List<DanhNgonAuth> listModel) {
        this.context = context;
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_danhngon_tab,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.danhngon.setText(listModel.get(position).getDanhngon());
            holder.tacgia.setText(listModel.get(position).getTacgia());

    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView danhngon;
        TextView tacgia;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            danhngon=itemView.findViewById(R.id.tv_item_danhngon);
            tacgia=itemView.findViewById(R.id.tv_item_tacgia);
        }
    }
}
