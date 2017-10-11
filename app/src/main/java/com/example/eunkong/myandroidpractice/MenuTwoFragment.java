package com.example.eunkong.myandroidpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by eunkong on 2017. 10. 11..
 */

public class MenuTwoFragment extends Fragment {
    public static MenuTwoFragment newInstance() {
        MenuTwoFragment fragment = new MenuTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_two, container, false);
    }
}
