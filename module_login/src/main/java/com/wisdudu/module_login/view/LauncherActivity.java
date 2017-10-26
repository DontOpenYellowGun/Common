package com.wisdudu.module_login.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jaeger.library.StatusBarUtil;
import com.orhanobut.hawk.Hawk;
import com.wisdudu.lib_common.base.BaseActivity;
import com.wisdudu.module_login.BR;
import com.wisdudu.module_login.R;
import com.wisdudu.module_login.constants.LoginState;

/**
 * 文件描述：启动Activity
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class LauncherActivity extends BaseActivity {

    @Override
    protected View initBinding() {
        ViewDataBinding mBinding = DataBindingUtil.setContentView(this, R.layout.login_activity_login);
        mBinding.setVariable(BR.viewModel, this);
        return mBinding.getRoot();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRootFragment(R.id.fragment_container, SplashFragment.newInstance());
    }
}
