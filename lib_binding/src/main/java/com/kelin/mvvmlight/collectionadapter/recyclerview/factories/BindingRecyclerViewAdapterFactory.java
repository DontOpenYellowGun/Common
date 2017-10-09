package com.kelin.mvvmlight.collectionadapter.recyclerview.factories;

import android.support.v7.widget.RecyclerView;

import com.kelin.mvvmlight.collectionadapter.ItemViewArg;
import com.kelin.mvvmlight.collectionadapter.recyclerview.BindingRecyclerViewAdapter;


public interface BindingRecyclerViewAdapterFactory {
    <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg);

    BindingRecyclerViewAdapterFactory DEFAULT = new BindingRecyclerViewAdapterFactory() {
        @Override
        public <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {

            return new BindingRecyclerViewAdapter<>(arg);
        }
    };
}
