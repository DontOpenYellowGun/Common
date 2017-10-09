package com.kelin.mvvmlight.collectionadapter.factories;

import android.support.v4.view.ViewPager;

import com.kelin.mvvmlight.collectionadapter.BindingViewPagerAdapter;
import com.kelin.mvvmlight.collectionadapter.ItemViewArg;

public interface BindingViewPagerAdapterFactory {
    <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg);

  BindingViewPagerAdapterFactory DEFAULT = new BindingViewPagerAdapterFactory() {
        @Override
        public <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg) {
            return new BindingViewPagerAdapter<>(arg);
        }
    };
}
