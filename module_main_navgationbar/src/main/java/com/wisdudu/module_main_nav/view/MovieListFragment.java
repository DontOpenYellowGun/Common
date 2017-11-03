package com.wisdudu.module_main_nav.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.ToolbarFragment;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.databinding.MainNavFragmentMovieListBinding;
import com.wisdudu.module_main_nav.viewmodel.MovieListViewModel;


/**
 * 文件描述：电影列表页
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class MovieListFragment extends ToolbarFragment {

    private static final String TAG = "MovieListFragment";

    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Builder configToolbar() {
        return new Builder().title("电影").isShowLeftButton(false);
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainNavFragmentMovieListBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.main_nav_fragment_movie_list, container, false);
        mBinding.setViewModel(new MovieListViewModel(this));
        return mBinding.getRoot();
    }
}
