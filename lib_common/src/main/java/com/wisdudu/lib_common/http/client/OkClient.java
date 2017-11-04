package com.wisdudu.lib_common.http.client;


import android.support.annotation.NonNull;

import com.wisdudu.lib_common.BuildConfig;
import com.wisdudu.lib_common.base.BaseApplication;
import com.wisdudu.lib_common.util.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
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
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(getHttpLoggingInterceptor())
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(configCache())
                .build();
    }

    /**
     * Method:      configCache <br>
     * Description: 配置缓存 <br>
     * Creator:     sven <br>
     * Date:        2017/11/4 下午12:39
     */
    @NonNull
    private Cache configCache() {
        File httpCacheDirectory = new File(BaseApplication.getInstance().getCacheDir(), "HttpCache");
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(httpCacheDirectory, cacheSize);
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

    //缓存拦截器，不同接口不同缓存
//     Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            Request request = chain.request();
//            Response response = chain.proceed(request);
//
//            if (NetworkUtil.getInstance().isConnected()) {
//                String cacheControl =request.cacheControl().toString();
//                return response.newBuilder()
//                        .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                        .header("Cache-Control", cacheControl)
//                        .build();
//            }
//            return response;
//        }
//    };

    //缓存拦截器，统一缓存60s
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(request);

            if (NetUtil.INSTANCE.isConnected()) {
                int maxAge = 60 * 60 * 24 * 2;//缓存失效时间，单位为秒
                return response.newBuilder()
                        .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            }
            return response;
        }
    };
}
