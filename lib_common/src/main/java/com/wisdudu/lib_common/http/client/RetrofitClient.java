package com.wisdudu.lib_common.http.client;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdudu.lib_common.http.service.UserApi;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 文件描述：RetrofitClient
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public enum RetrofitClient {

    INSTANCE;

    private final Retrofit.Builder retrofitBuilder;

    RetrofitClient() {

        Gson gson = new GsonBuilder().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.STATIC, Modifier.PUBLIC)
                .create();

        retrofitBuilder = new Retrofit.Builder()
                .client(OkClient.INSTANCE.getOkHttpClient())
                .baseUrl(UserApi.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    public Retrofit.Builder getRetrofitBuilder() {
        return retrofitBuilder;
    }
}
