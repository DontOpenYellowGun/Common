package com.wisdudu.module_main_nav.api;

import com.wisdudu.lib_common.http.client.subscribers.func.AbsFunc;
import com.wisdudu.lib_common.http.client.subscribers.func.ListPoint;
import com.wisdudu.lib_common.http.service.UserService;
import com.wisdudu.lib_common.model.User;
import com.wisdudu.lib_common.util.MD5Util;
import com.wisdudu.lib_common.util.MapSort;
import com.wisdudu.module_main_nav.model.Brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/9/26.
 */

public enum TestRemoteDataSource {

    INSTANCE;

    public Observable<List<Brand>> getBrandList(int intypeId) {
        Map<String, Object> map = new HashMap<>();
        map.put("intypeid", intypeId);
        return TestService.INSTANCE.getApi()
                .getBrandList(MapSort.getLoginMD5PostMap(map))
                .map(new AbsFunc<ListPoint<List<Brand>>>())
                .map(new Function<ListPoint<List<Brand>>, List<Brand>>() {
                    @Override
                    public List<Brand> apply(ListPoint<List<Brand>> listListPoint) throws Exception {
                        return listListPoint.getList();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
}
