package com.wisdudu.module_main_nav.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.ToolbarFragment;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.databinding.MainNavFragmentBookListBinding;
import com.wisdudu.module_main_nav.viewmodel.BookListViewModel;


/**
 * 文件描述：书籍Fragment
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class BookListFragment extends ToolbarFragment {

    private MainNavFragmentBookListBinding mBinding;

    private BookListViewModel mViewModel;

    public static BookListFragment newInstance() {
        Bundle args = new Bundle();
        BookListFragment fragment = new BookListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Builder configToolbar() {
        return new Builder().title("书籍").isShowLeftButton(false);
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_nav_fragment_book_list, container, false);
        mViewModel = new BookListViewModel(this);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }
}
