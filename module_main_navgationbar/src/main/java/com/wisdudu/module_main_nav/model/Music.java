package com.wisdudu.module_main_nav.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/11/2.
 */

public class Music extends BaseObservable {

    @Bindable
    private String name;
    @Bindable
    private String singer;

    public Music(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return singer;
    }

    public void setTime(String time) {
        this.singer = time;
    }
}
