package com.wisdudu.module_main;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.module_main.databinding.MainFragmentMainBinding;

/**
 * 文件描述：首页
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
@Route(path = "/main/MainFragment")
public class MainFragment extends BaseFragment {

    private MainFragmentMainBinding mBinding;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment_main, container, false);
        mBinding.setViewModel(this);
        return mBinding.getRoot();
    }

}
