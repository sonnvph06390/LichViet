package com.thuanthanh.lichviet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.SuKienQuanTrong;

import java.util.ArrayList;

public class SuKienQuanTrongAdapter extends RecyclerView.Adapter<SuKienQuanTrongAdapter.MyViewHolder> {
    private ArrayList<SuKienQuanTrong> suKienQuanTrongs = new ArrayList<>();

    public SuKienQuanTrongAdapter(ArrayList<SuKienQuanTrong> suKienQuanTrongs) {
        this.suKienQuanTrongs = suKienQuanTrongs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sukienquantrong, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.icSukien1.setImageResource(suKienQuanTrongs.get(position).getIc_sukien1());
        holder.tvDateSukien1.setText(suKienQuanTrongs.get(position).getDateSuKien1());
        holder.tvTitleSukien1.setText(suKienQuanTrongs.get(position).getTitleSuKien1());
        holder.tvTimeSukien1.setText(suKienQuanTrongs.get(position).getTimeSuKien1());

        holder.icSukien2.setImageResource(suKienQuanTrongs.get(position).getIc_sukien2());
        holder.tvDateSukien2.setText(suKienQuanTrongs.get(position).getDateSuKien2());
        holder.tvTitleSukien2.setText(suKienQuanTrongs.get(position).getTitleSuKien2());
        holder.tvTimeSukien2.setText(suKienQuanTrongs.get(position).getTimeSuKien2());

        holder.icSukien3.setImageResource(suKienQuanTrongs.get(position).getIc_sukien3());
        holder.tvDateSukien3.setText(suKienQuanTrongs.get(position).getDateSuKien3());
        holder.tvTitleSukien3.setText(suKienQuanTrongs.get(position).getTitleSuKien3());
        holder.tvTimeSukien3.setText(suKienQuanTrongs.get(position).getTimeSuKien3());


    }

    @Override
    public int getItemCount() {
        return suKienQuanTrongs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView icSukien1;
        private TextView tvDateSukien1;
        private TextView tvTitleSukien1;
        private TextView tvTimeSukien1;
        private ImageView icSukien2;
        private TextView tvDateSukien2;
        private TextView tvTitleSukien2;
        private TextView tvTimeSukien2;
        private ImageView icSukien3;
        private TextView tvDateSukien3;
        private TextView tvTitleSukien3;
        private TextView tvTimeSukien3;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            icSukien1 = (ImageView) itemView.findViewById(R.id.ic_sukien1);
            tvDateSukien1 = (TextView) itemView.findViewById(R.id.tvDate_Sukien1);
            tvTitleSukien1 = (TextView) itemView.findViewById(R.id.tvTitle_Sukien1);
            tvTimeSukien1 = (TextView) itemView.findViewById(R.id.tvTime_Sukien1);
            icSukien2 = (ImageView) itemView.findViewById(R.id.ic_sukien2);
            tvDateSukien2 = (TextView) itemView.findViewById(R.id.tvDate_Sukien2);
            tvTitleSukien2 = (TextView) itemView.findViewById(R.id.tvTitle_Sukien2);
            tvTimeSukien2 = (TextView) itemView.findViewById(R.id.tvTime_Sukien2);
            icSukien3 = (ImageView) itemView.findViewById(R.id.ic_sukien3);
            tvDateSukien3 = (TextView) itemView.findViewById(R.id.tvDate_Sukien3);
            tvTitleSukien3 = (TextView) itemView.findViewById(R.id.tvTitle_Sukien3);
            tvTimeSukien3 = (TextView) itemView.findViewById(R.id.tvTime_Sukien3);
        }
    }
}
