package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.model.Congiap;

import java.util.ArrayList;

public class CongiapAdapter extends RecyclerView.Adapter<CongiapAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Congiap> congiaps;

    public CongiapAdapter(Context context, ArrayList<Congiap> congiaps) {

        this.context = context;
        this.congiaps = congiaps;
    }


    @NonNull
    @Override
    public CongiapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_congiap, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CongiapAdapter.ViewHolder holder, int position) {
        holder.ImgMovie.setImageResource(congiaps.get(position).getImage_drawable());
        holder.TvTitle.setText(congiaps.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return congiaps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TvTitle;
        private ImageView ImgMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvTitle = itemView.findViewById(R.id.tv);
            ImgMovie = itemView.findViewById(R.id.iv);


        }
    }
}
