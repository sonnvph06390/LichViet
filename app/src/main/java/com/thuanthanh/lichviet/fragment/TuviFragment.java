package com.thuanthanh.lichviet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thuanthanh.lichviet.R;

public class TuviFragment extends Fragment {
    GridView gridView;
    String titile[] = {"Tử Vi \n2019", "Tử Vi \n Hằng Ngày", "Văn Khấn", "Xem Sao", "Tử Vi \n Trọn Đời", "Bói \n Tình Duyên", "Giải Mộng", "La Bàn", "Thước \n Lỗ Ban", "Nhịp \n Sinh Học", "Cung \n Hoàng Đạo", "Đổi Ngày"};
    int img[] = {R.drawable.ic_tuvi_2019, R.drawable.i_tuvihangngay, R.drawable.i_vankhan, R.drawable.i_xemsao, R.drawable.i_tuvitrondoi, R.drawable.i_boitinhduyen, R.drawable.i_giaimong, R.drawable.i_laban, R.drawable.i_thuocloban, R.drawable.i_nhipsinhhoc, R.drawable.i_cunghoangdao, R.drawable.i_doingay};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuvi, container, false);
        gridView = view.findViewById(R.id.gridview);
        CustomAdapter customAdapter =new CustomAdapter();
        gridView.setAdapter(customAdapter);
        return view;

//
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
           return img.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 =getLayoutInflater().inflate(R.layout.gridview_item,null);
            ImageView imageView = view1.findViewById(R.id.imgic);
            TextView textView =view1.findViewById(R.id.tvItem);
            imageView.setImageResource(img[i]);
            textView.setText(titile[i]);
            return view1;
        }
    }
}
