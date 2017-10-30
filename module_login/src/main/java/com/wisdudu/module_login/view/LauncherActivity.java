package com.wisdudu.module_login.view;

import com.wisdudu.lib_common.base.FragmentActivity;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 文件描述：启动Activity
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class LauncherActivity extends FragmentActivity {

    @Override
    protected SupportFragment loadFragment() {
        return SplashFragment.newInstance();
    }
}
