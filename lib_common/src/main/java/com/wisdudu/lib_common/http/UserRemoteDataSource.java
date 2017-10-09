package com.wisdudu.lib_common.http;

import com.wisdudu.lib_common.http.client.subscribers.Abs;
import com.wisdudu.lib_common.http.client.subscribers.MapSort;
import com.wisdudu.lib_common.http.service.UserService;
import com.wisdudu.lib_common.util.MD5Util;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/9/26.
 */

public enum UserRemoteDataSource {

    INSTANCE;

    public Observable<Abs> login(String phone, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwds", MD5Util.getMD5Login(password));
        map.put("role", 0);
        return UserService.INSTANCE.getApi()
                .login(MapSort.getLoginMD5PostMap(map))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
