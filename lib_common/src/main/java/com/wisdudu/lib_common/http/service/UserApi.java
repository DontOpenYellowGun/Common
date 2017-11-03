package com.wisdudu.lib_common.http.service;

import com.wisdudu.lib_common.http.client.subscribers.func.Abs;
import com.wisdudu.lib_common.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 文件描述：用户相关接口
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public interface UserApi {

    @FormUrlEncoded
    @POST("center/Login.html")
    Observable<Abs<User>> login(@Field("json") String md5MapResult);
}

