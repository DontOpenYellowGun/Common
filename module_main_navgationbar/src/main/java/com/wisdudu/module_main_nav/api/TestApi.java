package com.wisdudu.module_main_nav.api;

import com.wisdudu.lib_common.http.client.subscribers.func.Abs;
import com.wisdudu.lib_common.http.client.subscribers.func.ListPoint;
import com.wisdudu.lib_common.model.User;
import com.wisdudu.module_main_nav.model.Brand;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 文件描述：测试相关接口
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public interface TestApi {

    @Headers("Cache-Control: public, max-age=3600")
    @GET("center/infrared/band.html")
    Observable<Abs<ListPoint<List<Brand>>>> getBrandList(@Query("json") String md5GetResult);

}

