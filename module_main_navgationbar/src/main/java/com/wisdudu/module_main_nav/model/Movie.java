package com.wisdudu.module_main_nav.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wisdudu.module_main_nav.BR;


/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/11/2.
 */

public class Movie extends BaseObservable {

    private String name;
    private String time;

    public Movie(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
