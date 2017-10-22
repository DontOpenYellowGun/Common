package com.wisdudu.lib_common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.wisdudu.lib_common.R;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/10/21.
 */

public abstract class ToolbarActivity extends BaseActivity {

    private Toolbar mToolBar;

    private Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
    }

    protected void initToolbar() {
        mBuilder = configToolbar();
        mToolBar = mRootView.findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        if (mToolBar != null) {
            TextView mTitle = mRootView.findViewById(R.id.title_textview);
            mTitle.setText(mBuilder.title == null ? "" : mBuilder.title);
            if (mBuilder.isShowLeftButton) {
                mToolBar.setNavigationIcon(mBuilder.leftButtonRes == 0 ? R.drawable.ic_keyboard_arrow_left_white_24dp : mBuilder.leftButtonRes);
                mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mBuilder.leftButtonClickListener != null) {
                            mBuilder.leftButtonClickListener.onClick(view);
                        } else {
                            finish();
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

    public abstract Builder configToolbar();

    public static class Builder {

        private String title = null;
        private Boolean isShowLeftButton = true;
        private int leftButtonRes = 0;
        private int rightMenuRes = 0;
        private LeftButtonClickListener leftButtonClickListener;
        private RightMenuClickListener rightMenuClickListener;

        public Builder() {

        }

        public Builder title(String var) {
            title = var;
            return this;
        }

        public Builder isShowLeftButton(Boolean val) {
            isShowLeftButton = val;
            return this;
        }

        public Builder leftButtonRes(int val) {
            leftButtonRes = val;
            return this;
        }

        public Builder rightMenuRes(int val) {
            rightMenuRes = val;
            return this;
        }

        public Builder leftButtonClickListener(LeftButtonClickListener val) {
            leftButtonClickListener = val;
            return this;
        }

        public Builder rightMenuClickListener(RightMenuClickListener val) {
            rightMenuClickListener = val;
            return this;
        }

        public Builder build() {
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
