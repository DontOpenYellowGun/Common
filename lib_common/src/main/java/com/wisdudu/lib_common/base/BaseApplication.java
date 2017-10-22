package com.wisdudu.lib_common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.NoEncryption;
import com.wisdudu.lib_common.BuildConfig;

/**
 * 文件描述：
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication，
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class BaseApplication extends Application {

    private static BaseApplication sInstance;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initRouter();
        initHawk();
    }

    private void initHawk() {
        Hawk.init(sInstance)
                .setEncryption(new NoEncryption())
                .build();
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
