package com.example.eunkong.myandroidpractice;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eunkong on 2017. 10. 11..
 */

public class MenuOneFragment extends Fragment {
    final static String TAG = MenuOneFragment.class.getSimpleName();

    private View mView;
    private ListView listView;
    private ListviewAdapter listviewAdapter;


    public static MenuOneFragment newInstance() {
        Log.d(TAG, "newInstance()");
        MenuOneFragment fragment = new MenuOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        mView = inflater.inflate(R.layout.fragment_menu_one, container, false);

        initView();

        return mView;
    }

    public void initView() {
        listviewAdapter = new ListviewAdapter(getContext());

        listView = (ListView) mView.findViewById(R.id.listview_image);

        listView.setAdapter(listviewAdapter);

        addAllItem();

    }

    public void addAllItem() {

        ArrayList<ListviewItem> arrayListView = new ArrayList<>();

        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image01), "There is a picture", "", 23));
        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image02),"Relayout", "", 1223));
        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image03),"myandroidpractice", "", 532));
        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image04),"surfaceGenerationChanged", "", 60));
        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image05),"ViewPostImeInputStage", "", 55));
        arrayListView.add(new ListviewItem(getResources().getDrawable(R.drawable.image06),"ViewPostImeInputStage", "", 255));

        listviewAdapter.setData(arrayListView);
    }
}
