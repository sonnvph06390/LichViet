package com.thuanthanh.lichviet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.thuanthanh.lichviet.R;

public class VankhanActivity extends AppCompatActivity {

    private ImageView imageView, ic_next,imgToolbar;
    private GridView gridView;
    private TextView textView;
    String titile[] = {"Văn khấn Tết Nguyên Đán", "Văn khấn lễ tiết trong năm", "Văn khấn ở tang lễ,giỗ chạp", "Văn khấn tại Đình,Đền,Miếu,Phủ", "Văn khấn tại nhà ở,công ty,cửa hàng", "Văn khấn dâng sao giải hạn", "Văn khấn mùng Một và ngày Rằm", "Ngi lễ khác"};
    int img[] = {R.drawable.i_vk_category_1, R.drawable.i_vk_category_2, R.drawable.i_vk_category_3, R.drawable.i_vk_category_4, R.drawable.i_vk_category_5, R.drawable.i_vk_category_6, R.drawable.i_vk_category_7, R.drawable.i_vk_category_8};
    int icon = (R.drawable.icon_vhv_next);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vankhan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgToolbar=findViewById(R.id.imgtoolbar);
        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        gridView = findViewById(R.id.gridview1);
        VankhanAdapter vankhanAdapter = new VankhanAdapter();
        gridView.setAdapter(vankhanAdapter);

    }

    private class VankhanAdapter extends BaseAdapter {

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
            View view1 = getLayoutInflater().inflate(R.layout.gridview_item_vankhan, null);
            imageView = view1.findViewById(R.id.img_vankhan);
            textView = view1.findViewById(R.id.tv_vankhan);
            ic_next = view1.findViewById(R.id.i_next_vk);
            imageView.setImageResource(img[i]);
            textView.setText(titile[i]);
            ic_next.setImageResource(icon);
            return view1;
        }
    }
}
