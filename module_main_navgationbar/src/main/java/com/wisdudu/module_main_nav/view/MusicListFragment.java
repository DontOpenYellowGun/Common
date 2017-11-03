package com.wisdudu.module_main_nav.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.ToolbarFragment;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.databinding.MainNavFragmentMusicListBinding;
import com.wisdudu.module_main_nav.viewmodel.MusicListViewModel;


/**
 * 文件描述：MusicListFragment
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class MusicListFragment extends ToolbarFragment {

    public static MusicListFragment newInstance() {
        Bundle args = new Bundle();
        MusicListFragment fragment = new MusicListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Builder configToolbar() {
        return new Builder().title("音乐").isShowLeftButton(false);
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainNavFragmentMusicListBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.main_nav_fragment_music_list, container, false);
        mBinding.setViewModel(new MusicListViewModel(this));
        return mBinding.getRoot();
    }
}
