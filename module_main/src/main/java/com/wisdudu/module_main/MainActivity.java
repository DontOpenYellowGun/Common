package com.wisdudu.module_main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wisdudu.lib_common.base.BaseActivity;
import com.wisdudu.lib_common.util.ToastUtil;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * 文件描述：主页Activity
 * <p>
 * 作者：   Created by sven on 2017/10/30.
 */

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;

    private long TOUCH_TIME = 0;

    private DrawerLayout mDrawer;

    private NavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        initView();
    }

    private void initView() {

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.nav_home);

        MainFragment fragment = findFragment(MainFragment.class);
        if (fragment == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }

    }

    @Override
    protected View initBinding() {
        return null;
    }

    @Override
    public void onBackPressedSupport() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            SupportFragment topFragment = getTopFragment();

            if (topFragment instanceof MainFragment) {
                mNavigationView.setCheckedItem(R.id.nav_home);
            }

            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                pop();
            } else {
                if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                    finish();
                } else {
                    TOUCH_TIME = System.currentTimeMillis();
                    ToastUtil.INSTANCE.toast(R.string.main_press_again_exit);
                }
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {

        mDrawer.closeDrawer(GravityCompat.START);

        mDrawer.postDelayed(new Runnable() {
            @Override
            public void run() {

                int id = item.getItemId();

                final SupportFragment topFragment = getTopFragment();

                if (id == R.id.nav_home) {

                    MainFragment fragment = findFragment(MainFragment.class);
                    start(fragment, SupportFragment.SINGLETASK);

                } else if (id == R.id.nav_gallery) {

                    TestFragment1 fragment = findFragment(TestFragment1.class);
                    if (fragment == null) {
                        popTo(MainFragment.class, false, new Runnable() {
                            @Override
                            public void run() {
                                start(TestFragment1.newInstance());
                            }
                        });
                    } else {
                        start(fragment, SupportFragment.SINGLETASK);
                    }

                } else if (id == R.id.nav_slideshow) {

                    TestFragment2 fragment = findFragment(TestFragment2.class);
                    if (fragment == null) {
                        popTo(MainFragment.class, false, new Runnable() {
                            @Override
                            public void run() {
                                start(TestFragment2.newInstance());
                            }
                        });
                    } else {
                        popTo(TestFragment2.class, false);
                    }

                }
            }
        }, 300);
        return true;
    }
}
