package com.thuanthanh.lichviet.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thuanthanh.lichviet.R;
import com.thuanthanh.lichviet.swipetouch.OnSwipeTouchListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class LichVN_Fragment extends BaseFragment {

    private ConstraintLayout constraintLayout;
    private Guideline guideline;
    private LinearLayout layoutBottom;
    private LinearLayout layoutWeather;
    private ImageView imgWeather;
    private TextView tvNhietdo;
    private TextView tvDubao;
    private TextView tvThanhpho;
    private TextView tvGio;
    private TextView tvThongtingio;
    private TextView tvNgayAm;
    private TextView tvThongtinngay;
    private TextView tvThangAm;
    private TextView tvThongtinthang;
    private TextView tvThongtinnam;
    private Guideline guideline2;
    private LinearLayout layout_chonngay;
    private TextView tvThangnam;
    private ImageButton btn_image;
    private TextView tvNgayhomnay;
    private Guideline guideline3;
    private TextView tvThu;
    private LinearLayout linearLayout2;
    private TextView tvCadao;
    private TextView tvNguon;
    private LinearLayout taosukien;
    private LinearLayout chiase;
    private LinearLayout chitietngay;
    private LinearLayout chonngaytot;
    private LinearLayout doingay;
    private LinearLayout nnnx;
    String dateformat = "dd";
    String dateMonth = "MM - yyy";
    String dayofweek = "EEEE";


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.lichvn_fragment, container, false);
        initView(view);
        randomImage();
        getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateMonth);
        final SimpleDateFormat day = new SimpleDateFormat(dateformat);
        SimpleDateFormat week = new SimpleDateFormat(dayofweek);
        String format = simpleDateFormat.format(new Date());
        final String dayformat = day.format(new Date());
        String a = week.format(new Date());
        tvThangnam.setText(format);
        tvNgayhomnay.setText(dayformat);
        tvThu.setText(a);

        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                randomImage();
                getTime();
            }

            public void onSwipeRight() {
                randomImage();
                getTime();
            }

            public void onSwipeLeft() {
                randomImage();
                getTime();
            }

            public void onSwipeBottom() {
                randomImage();
                getTime();
            }
        });

        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(getContext());
                dialog.setContentView(R.layout.bottom_sheet_dialog);
                dialog.show();
                initDialog(dialog);
                onclickDialog();
            }
        });

        layout_chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(getContext());
                dialog.setContentView(R.layout.chonngay);
                dialog.show();
            }
        });
        return view;
    }

    private void initView(View view) {
        guideline = view.findViewById(R.id.guideline);
        layoutBottom = view.findViewById(R.id.layout_bottom);
        layoutWeather = view.findViewById(R.id.layout_weather);
        imgWeather = view.findViewById(R.id.img_weather);
        tvNhietdo = view.findViewById(R.id.tv_nhietdo);
        tvDubao = view.findViewById(R.id.tv_dubao);
        tvThanhpho = view.findViewById(R.id.tv_thanhpho);
        tvGio = view.findViewById(R.id.tv_gio);
        tvThongtingio = view.findViewById(R.id.tv_thongtingio);
        tvNgayAm = view.findViewById(R.id.tv_ngayam);
        tvThongtinngay = view.findViewById(R.id.tv_thongtinngay);
        tvThangAm = view.findViewById(R.id.tv_thangam);
        tvThongtinthang = view.findViewById(R.id.tv_thongtinthang);
        tvThongtinnam = view.findViewById(R.id.tv_thongtinnam);
        guideline2 = view.findViewById(R.id.guideline2);
        layout_chonngay = view.findViewById(R.id.layout_chonngay);
        tvThangnam = view.findViewById(R.id.tv_thangnam);
        btn_image = view.findViewById(R.id.imgbutton);
        tvNgayhomnay = view.findViewById(R.id.tv_ngayhomnay);
        guideline3 = view.findViewById(R.id.guideline3);
        tvThu = view.findViewById(R.id.tv_thu);
        linearLayout2 = view.findViewById(R.id.linearLayout2);
        tvCadao = view.findViewById(R.id.tv_cadao);
        tvNguon = view.findViewById(R.id.tv_nguon);
        constraintLayout = view.findViewById(R.id.const_layout);
    }

    private void initDialog(BottomSheetDialog dialog) {
        taosukien = dialog.findViewById(R.id.layout_taosukien);
        chiase = dialog.findViewById(R.id.layout_chiase);
        chitietngay = dialog.findViewById(R.id.layout_chitietngay);
        chonngaytot = dialog.findViewById(R.id.layout_chonngaytot);
        doingay = dialog.findViewById(R.id.layout_doingay);
        nnnx = dialog.findViewById(R.id.layout_nnnx);
    }

    private void randomImage() {
        Animation fadeOut = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
        constraintLayout.startAnimation(fadeOut);

        Glide.with(getContext())
                .load(getImage())
                .into(new CustomTarget<Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        constraintLayout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    private void getTime() {
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        tvGio.setText(currentTime);
    }

    private int getImage() {
        int[] images = {R.drawable.sl1, R.drawable.sl2, R.drawable.sl3, R.drawable.sl4, R.drawable.sl8, R.drawable.lichngay_default_background};
        Random rand = new Random();
        return images[rand.nextInt(images.length)];
    }

    private void onclickDialog(){
        taosukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Tạo sự kiện", Toast.LENGTH_SHORT).show();
            }
        });

        chiase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Chia sẻ", Toast.LENGTH_SHORT).show();
            }
        });

        chitietngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Chi tiết ngày", Toast.LENGTH_SHORT).show();
            }
        });

        chonngaytot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Chọn ngày tốt", Toast.LENGTH_SHORT).show();
            }
        });

        doingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Đổi ngày", Toast.LENGTH_SHORT).show();
            }
        });

        nnnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ngày này năm xưa", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
