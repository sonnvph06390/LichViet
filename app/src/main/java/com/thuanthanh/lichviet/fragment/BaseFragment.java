package com.thuanthanh.lichviet.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public BaseFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
