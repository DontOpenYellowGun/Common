package com.kelin.mvvmlight.bindingadapter.smartrefresh;

import android.databinding.BindingAdapter;

import com.kelin.mvvmlight.command.ReplyCommand;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

/**
 * 刷新控件的BindingAdapter
 * Created by Sven on 2017/7/25.
 */
public class ViewBindingAdapter {

    @BindingAdapter({"onRefresh"})
    public static void onRefreshCommand(SmartRefreshLayout refreshLayout, final ReplyCommand onRefreshCommand) {
        refreshLayout.setOnRefreshListener((RefreshLayout refreshlayout) -> {
            if (onRefreshCommand != null) {
                onRefreshCommand.execute();
            }
        });
    }

    @BindingAdapter({"onLoadMore"})
    public static void onLoadMoreCommand(SmartRefreshLayout refreshLayout, final ReplyCommand onLoadMoreCommand) {
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (onLoadMoreCommand != null) {
                    onLoadMoreCommand.execute();
                }
            }
        });
    }

    @BindingAdapter({"refreshing"})
    public static void setRefresh(SmartRefreshLayout refreshLayout, final boolean isRefreshing) {
        if (isRefreshing) {
            refreshLayout.autoRefresh();
        } else {
            refreshLayout.finishRefresh();
        }
    }

    @BindingAdapter({"loadingMore"})
    public static void setLoadMore(SmartRefreshLayout refreshLayout, final boolean isLoadingmore) {
        if (isLoadingmore) {
            refreshLayout.autoLoadmore();
        } else {
            refreshLayout.finishLoadmore();
        }
    }
}
