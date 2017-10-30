package com.wisdudu.lib_common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisdudu.lib_common.R;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/10/22.
 */

public abstract class ToolbarFragment extends BaseFragment {

    private Toolbar mToolBar;

    private ToolbarFragment.Builder mBuilder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
    }

    protected void initToolbar() {
        mBuilder = configToolbar();
        mToolBar = mRootView.findViewById(R.id.toolbar);
        if (mToolBar != null) {
            mToolBar.setPadding(0, (int) getResources().getDimension(R.dimen.main_statusbar_view_height), 0, 0);
            TextView mTitle = mRootView.findViewById(R.id.title_textview);
            mTitle.setText(mBuilder.title == null ? "" : mBuilder.title);
            if (mBuilder.isShowLeftButton) {
                mToolBar.setNavigationIcon(mBuilder.leftButtonRes == 0 ? R.drawable.ic_arrow_back_white_24dp : mBuilder.leftButtonRes);
                mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mBuilder.leftButtonClickListener != null) {
                            mBuilder.leftButtonClickListener.onClick(view);
                        } else {
                            pop();
                        }
                    }
                });
            }
            if (mBuilder.rightMenuRes != 0) {
                mToolBar.inflateMenu(mBuilder.rightMenuRes);
                mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (mBuilder.rightMenuClickListener != null) {
                            mBuilder.rightMenuClickListener.onClick(item);
                        }
                        return false;
                    }
                });
            }
        } else {
            throw new RuntimeException("Maybe your layout not include view_toolbar");
        }
    }

    public abstract ToolbarFragment.Builder configToolbar();

    @Override
    protected abstract View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public static class Builder {

        private String title = null;
        private Boolean isShowLeftButton = true;
        private int leftButtonRes = 0;
        private int rightMenuRes = 0;
        private ToolbarActivity.Builder.LeftButtonClickListener leftButtonClickListener;
        private ToolbarActivity.Builder.RightMenuClickListener rightMenuClickListener;

        public Builder() {

        }

        public ToolbarFragment.Builder title(String var) {
            title = var;
            return this;
        }

        public ToolbarFragment.Builder isShowLeftButton(Boolean val) {
            isShowLeftButton = val;
            return this;
        }

        public ToolbarFragment.Builder leftButtonRes(int val) {
            leftButtonRes = val;
            return this;
        }

        public ToolbarFragment.Builder rightMenuRes(int val) {
            rightMenuRes = val;
            return this;
        }

        public ToolbarFragment.Builder leftButtonClickListener(ToolbarActivity.Builder.LeftButtonClickListener val) {
            leftButtonClickListener = val;
            return this;
        }

        public ToolbarFragment.Builder rightMenuClickListener(ToolbarActivity.Builder.RightMenuClickListener val) {
            rightMenuClickListener = val;
            return this;
        }

        public ToolbarFragment.Builder build() {
            return this;
        }

        interface LeftButtonClickListener {
            void onClick(View view);
        }

        interface RightMenuClickListener {
            void onClick(MenuItem item);
        }
    }
}
