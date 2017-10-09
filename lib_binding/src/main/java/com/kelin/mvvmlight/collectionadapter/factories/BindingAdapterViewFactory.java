package com.kelin.mvvmlight.collectionadapter.factories;

import android.widget.AdapterView;

import com.kelin.mvvmlight.collectionadapter.BindingListViewAdapter;
import com.kelin.mvvmlight.collectionadapter.ItemViewArg;


public interface BindingAdapterViewFactory {
    <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg);

   BindingAdapterViewFactory DEFAULT = new BindingAdapterViewFactory() {
        @Override
        public <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg) {
            return new BindingListViewAdapter<>(arg);
        }
    };
}
