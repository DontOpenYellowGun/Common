package com.wisdudu.module_main_nav.api;


import com.wisdudu.lib_common.constants.Domain;
import com.wisdudu.lib_common.http.client.RetrofitClient;

/**
 * 未登录之前调用接口地址
 * Created by ypp on 2017/4/25.
 */

public enum TestService {

    INSTANCE;

    private TestApi mApi;

    TestService() {
        mApi = RetrofitClient.INSTANCE
                .getRetrofitBuilder()
                .baseUrl(Domain.BASE_URL).build()
                .create(TestApi.class);
    }

    public TestApi getApi() {
        return mApi;
    }


}
