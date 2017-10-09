package com.wisdudu.lib_common.http.client;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 文件描述：OkHttpClient
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public enum OkClient {

    INSTANCE;

    private final OkHttpClient okHttpClient;

    OkClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        short HTTP_CONNECT_TIMEOUT = 10;
        short HTTP_READ_TIMEOUT = 30;
        short HTTP_WRITE_TIMEOUT = 10;
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .build()
        ;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
