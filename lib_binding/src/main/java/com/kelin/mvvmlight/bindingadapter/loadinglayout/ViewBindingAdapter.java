package com.kelin.mvvmlight.bindingadapter.loadinglayout;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.kelin.mvvmlight.command.ReplyCommand;
import com.weavey.loading.lib.LoadingLayout;

/**
 * Created by kelin on 16-6-1.
 */
public class ViewBindingAdapter {
    @BindingAdapter(value = {"pageState", "reloadCommand"}, requireAll = false)
    public static void setPageState(final LoadingLayout layout, int pageState, ReplyCommand command) {
        if (layout != null) {
            layout.setStatus(pageState);
        }
        if (layout != null && command != null) {
            layout.setOnReloadListener(v -> command.execute());
        }
    }

    @BindingAdapter(value = {"errorStr"})
    public static void setErrorText(final LoadingLayout layout, String errorText) {
        if (layout != null) {
            layout.setErrorText(errorText);
        }
    }
}
