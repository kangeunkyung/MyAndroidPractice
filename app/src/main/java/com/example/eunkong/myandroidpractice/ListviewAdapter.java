package com.example.eunkong.myandroidpractice;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunkong on 2017. 10. 11..
 */

public class ListviewAdapter extends BaseAdapter {
    private final String TAG = ListviewAdapter.class.getSimpleName();

    private ArrayList<ListviewItem> mListviewItems = new ArrayList<>();
    private Context mContext;

    public ListviewAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<ListviewItem> listviewItems) {
        mListviewItems.clear();
        mListviewItems.addAll(listviewItems);
    }

    @Override
    public int getCount() {
        return mListviewItems == null ? 0 : mListviewItems.size();
    }

    @Override
    public ListviewItem getItem(int position) {
        return mListviewItems == null ? null : mListviewItems.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            viewHolder =  new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null, true);
            viewHolder.ivImage = (ImageView) view.findViewById(R.id.iv_image);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.tvDate = (TextView) view.findViewById(R.id.tv_date);
            viewHolder.tvCount = (TextView) view.findViewById(R.id.tv_talk_count);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.ivImage.setImageDrawable(mListviewItems.get(position).getImage());
        viewHolder.tvTitle.setText(mListviewItems.get(position).getTitle());
        viewHolder.tvDate.setText(mListviewItems.get(position).getDate());
        viewHolder.tvCount.setText(String.valueOf(mListviewItems.get(position).getCount())
        );

        return view;
    }

    class ViewHolder {
        public ImageView ivImage;
        public TextView tvTitle;
        public TextView tvCount;
        public TextView tvDate;
    }
}
