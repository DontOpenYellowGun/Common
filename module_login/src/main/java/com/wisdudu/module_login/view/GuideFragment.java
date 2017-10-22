package com.wisdudu.module_login.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelin.mvvmlight.command.ReplyCommand;
import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.module_login.BR;
import com.wisdudu.module_login.R;

import io.reactivex.functions.Action;

/**
 * 文件描述：引导页
 * <p>
 * 作者：   Created by sven on 2017/10/22.
 */

public class GuideFragment extends BaseFragment {

    private ViewDataBinding mBinding;

    public ReplyCommand confirmCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            startWithPop(LoginFragment.newInstance());
        }
    });

    public static GuideFragment newInstance() {
        Bundle args = new Bundle();
        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment_guide, container, false);
        mBinding.setVariable(BR.viewModel, this);
        return mBinding.getRoot();
    }
}
