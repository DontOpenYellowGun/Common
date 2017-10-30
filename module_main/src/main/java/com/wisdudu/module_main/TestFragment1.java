package com.wisdudu.module_main;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.ToolbarFragment;
import com.wisdudu.module_main.databinding.MainFragmentTest1Binding;


/**
 * 文件描述：TestFragment1
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class TestFragment1 extends ToolbarFragment {

    public static TestFragment1 newInstance() {
        Bundle args = new Bundle();
        TestFragment1 fragment = new TestFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Builder configToolbar() {
        return new Builder().title("测试Fragment1").isShowLeftButton(false);
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainFragmentTest1Binding mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment_test1, container, false);
        mBinding.setViewModel(this);
        return mBinding.getRoot();
    }
}
