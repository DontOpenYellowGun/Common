package com.wisdudu.module_main_nav.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.ToolbarFragment;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.databinding.MainNavFragmentTest2Binding;


/**
 * 文件描述：TestFragment1
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class TestFragment2 extends ToolbarFragment {

    public static TestFragment2 newInstance() {
        Bundle args = new Bundle();
        TestFragment2 fragment = new TestFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Builder configToolbar() {
        return new Builder().title("测试Fragment2").isShowLeftButton(false);
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainNavFragmentTest2Binding mBinding = DataBindingUtil.inflate(inflater, R.layout.main_nav_fragment_test2, container, false);
        mBinding.setViewModel(this);
        return mBinding.getRoot();
    }
}
