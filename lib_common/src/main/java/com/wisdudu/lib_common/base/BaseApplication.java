package com.wisdudu.lib_common.base;

import android.app.Activity;
import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.NoEncryption;

import java.util.Stack;

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

    private Stack<Activity> activityStack;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initHawk();
    }

    private void initHawk() {
        Hawk.init(sInstance)
                .setEncryption(new NoEncryption())
                .build();
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }
}
