package com.example.eunkong.myandroidpractice;

import android.graphics.drawable.Drawable;

/**
 * Created by eunkong on 2017. 10. 11..
 */

public class ListviewItem {
    private Drawable image;
    private String title;
    private String date;
    private int count;

    public ListviewItem(Drawable image, String title, String date, int count) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.count = count;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
