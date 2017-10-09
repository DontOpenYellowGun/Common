package com.wisdudu.lib_common.http.service;

import com.sven.lib_common.http.client.RetrofitClient;

/**
 * 未登录之前调用接口地址
 * Created by ypp on 2017/4/25.
 */

public enum UserService {

    INSTANCE;

    private UserApi mApi;

    UserService() {
        mApi = RetrofitClient.INSTANCE
                .getRetrofitBuilder()
                .baseUrl(UserApi.BASE_URL).build()
                .create(UserApi.class);
    }

    public UserApi getApi() {
        return mApi;
    }


}
