package com.wisdudu.module_main_nav.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.databinding.MainNavFragmentMainBinding;
import com.wisdudu.module_main_nav.view.widget.BottomBar;
import com.wisdudu.module_main_nav.view.widget.BottomBarTab;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * 文件描述：主页
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class MainFragment extends BaseFragment {

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private SupportFragment[] mFragments = new SupportFragment[3];

    private MainNavFragmentMainBinding mBinding;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_nav_fragment_main, container, false);
        mBinding.setViewModel(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBottomBar();
        loadChildFragments();
    }

    private void loadChildFragments() {
        SupportFragment firstFragment = findChildFragment(MusicListFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = MusicListFragment.newInstance();
            mFragments[SECOND] = MovieListFragment.newInstance();
            mFragments[THIRD] = BookListFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(MovieListFragment.class);
            mFragments[THIRD] = findChildFragment(BookListFragment.class);
        }
    }

    private void initBottomBar() {
        mBinding.bottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_person_white_24dp, getString(R.string.main_nav_home_page)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_person_white_24dp, getString(R.string.main_nav_more)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_person_white_24dp, getString(R.string.main_nav_more)));

        // 模拟未读消息
        mBinding.bottomBar.getItem(FIRST).setUnreadCount(9);

        mBinding.bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
                BottomBarTab tab = mBinding.bottomBar.getItem(FIRST);
                if (position == FIRST) {
                    tab.setUnreadCount(0);
                } else {
                    tab.setUnreadCount(tab.getUnreadCount() + 1);
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
