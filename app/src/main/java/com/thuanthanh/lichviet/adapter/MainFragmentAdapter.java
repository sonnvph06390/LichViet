package com.thuanthanh.lichviet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.fragment.HomeFragment;
import com.thuanthanh.lichviet.model.DanhNgon;
import com.thuanthanh.lichviet.model.Day;
import com.thuanthanh.lichviet.model.TuViBoiToan;

import java.util.ArrayList;

import static com.thuanthanh.lichviet.fragment.HomeFragment.getDanhNgonData;
import static com.thuanthanh.lichviet.fragment.HomeFragment.getDayData;
import static com.thuanthanh.lichviet.fragment.HomeFragment.getTuviboitoanData;

public class MainFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Object> items;
    private final int TUVIBOITOAN = 1;
    private final int DANHNGON = 2;
    private final int DAY = 3;



    public MainFragmentAdapter(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case TUVIBOITOAN:
                view = inflater.inflate(R.layout.rcv_tuvi_boitoan, parent, false);
                holder = new TuviViewHolder(view);
                break;
            case DANHNGON:
                view = inflater.inflate(R.layout.rvc_danhngon, parent, false);
                holder = new DanhNgonViewHolder(view);
                break;
            case DAY:
                view = inflater.inflate(R.layout.rcv_item_day, parent, false);
                holder = new DayViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.rcv_tuvi_boitoan, parent, false);
                holder = new TuviViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == TUVIBOITOAN) {
            tuviboitoanView((TuviViewHolder) holder);
        }
        if (holder.getItemViewType() == DANHNGON) {
            danhngonView((DanhNgonViewHolder) holder);
        }
        if (holder.getItemViewType() == DAY) {
            dayView((DayViewHolder) holder);
        }

    }

    private void tuviboitoanView(TuviViewHolder holder) {
        TuViBoiToanAdapter adapter = new TuViBoiToanAdapter(getTuviboitoanData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void danhngonView(DanhNgonViewHolder holder) {
        DanhNgonAdapter adapter = new DanhNgonAdapter(getDanhNgonData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);

    }
    private void dayView(DayViewHolder holder) {
        DayAdapter adapter = new DayAdapter(getDayData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof TuViBoiToan) {
            return TUVIBOITOAN;
        }
        if (items.get(position) instanceof DanhNgon) {
            return DANHNGON;
        }
        if (items.get(position) instanceof Day) {
            return DAY;
        }
        return -1;
    }

    public class TuviViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        TuviViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public class DanhNgonViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        DanhNgonViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.danhngon_recyclerView);
        }
    }
    public class DayViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        DayViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.day_recyclerView);
        }
    }
}
