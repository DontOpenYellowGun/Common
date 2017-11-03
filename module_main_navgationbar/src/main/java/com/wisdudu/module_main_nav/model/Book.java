package com.wisdudu.module_main_nav.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wisdudu.module_main_nav.BR;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/11/1.
 */

public class Book extends BaseObservable {

    @Bindable
    private String name;
    @Bindable
    private String prices;
    @Bindable
    private String cover;

    public Book() {
    }

    public Book(String name, String prices, String cover) {
        this.name = name;
        this.prices = prices;
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
        notifyPropertyChanged(BR.cover);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
        notifyPropertyChanged(BR.prices);
    }

}
