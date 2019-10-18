package com.thuanthanh.lichviet.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.thuanthanh.lichviet.fragment.SuKienFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 1)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 2)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 3)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 4)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 5)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 6)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 7)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 8)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 9)
        {
            fragment = new SuKienFragment();
        }
        else if (position == 10)
        {
            fragment = new SuKienFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "RẰM, MÙNG 1";
        }
        else if (position == 1)
        {
            title = "NGÀY LỄ";
        }
        else if (position == 2)
        {
            title = "VIỆC HỶ";
        }
        else if (position == 3)
        {
            title = "NGÀY GIỖ";
        }
        else if (position == 4)
        {
            title = "CÁ NHÂN";
        }
        else if (position == 5)
        {
            title = "GIA ĐÌNH";
        }
        else if (position == 6)
        {
            title = "CÔNG VIỆC";
        }
        else if (position == 7)
        {
            title = "SINH NHẬT";
        }
        else if (position == 8)
        {
            title = "HẸN HÒ";
        }
        else if (position == 9)
        {
            title = "KỈ NIỆM";
        }
        else if (position == 10)
        {
            title = "KHÁC";
        }
        return title;
    }
}
