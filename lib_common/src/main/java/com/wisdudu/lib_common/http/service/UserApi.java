package com.wisdudu.lib_common.http.service;

import com.wisdudu.lib_common.http.client.subscribers.Abs;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * 文件描述：用户相关接口
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public interface UserApi {

    String BASE_URL = "http://sz.wisdudu.com/api/";

    @FormUrlEncoded
    @POST("center/Login.html")
    Observable<Abs> login(@Field("json") String md5MapResult);

}

