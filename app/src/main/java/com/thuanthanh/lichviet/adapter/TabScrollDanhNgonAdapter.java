package com.thuanthanh.lichviet.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabScrollDanhNgonAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private ArrayList<String> arrayListTitle;


    public TabScrollDanhNgonAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> arrayListTitle) {
        super(fm);
        this.fragments = fragments;
        this.arrayListTitle = arrayListTitle;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayListTitle.get(position);

    }
}
