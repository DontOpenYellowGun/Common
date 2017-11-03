package com.wisdudu.lib_common.http.client;


import android.support.annotation.NonNull;

import com.wisdudu.lib_common.BuildConfig;
import com.wisdudu.lib_common.util.NetUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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

        short HTTP_CONNECT_TIMEOUT = 10;
        short HTTP_READ_TIMEOUT = 30;
        short HTTP_WRITE_TIMEOUT = 10;

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
                .addNetworkInterceptor(getNetWorkInterceptor())
                .addInterceptor(getCacheIntercept())
                .retryOnConnectionFailure(true)
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @NonNull
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }

    /**
     * 设置返回数据的  Interceptor  判断网络   没网读取缓存
     */
    public Interceptor getCacheIntercept() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetUtil.INSTANCE.isConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                return chain.proceed(request);
            }
        };
    }

    /**
     * 设置连接器  设置缓存
     */
    public Interceptor getNetWorkInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (NetUtil.INSTANCE.isConnected()) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为1周
                    int maxStale = 60 * 60 * 24 * 7;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
    }
}
