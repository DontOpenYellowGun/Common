package com.kelin.mvvmlight.collectionadapter.recyclerview;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kelin.mvvmlight.collectionadapter.ItemViewArg;
import com.kelin.mvvmlight.collectionadapter.Utils;
import com.kelin.mvvmlight.collectionadapter.recyclerview.factories.BindingRecyclerViewAdapterFactory;
import com.kelin.mvvmlight.command.ReplyItemCommand;

import java.util.List;


/**
 * @see {@link BindingRecyclerViewAdapters}
 */
public class BindingRecyclerViewAdapters {
    // RecyclerView
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"itemView", "items", "adapter", "itemIds", "viewHolder", "rec_ItemClickCommand","rec_ItemChildClickCommand"}, requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView, ItemViewArg<T> arg, List<T> items, BindingRecyclerViewAdapterFactory factory, BindingRecyclerViewAdapter.ItemIds<T> itemIds, BindingRecyclerViewAdapter.ViewHolderFactory viewHolderFactory, final ReplyItemCommand<Integer, View> onItemClickCommand, final ReplyItemCommand<Integer, View> onItemChildClickCommand) {
        if (arg == null) {
            throw new IllegalArgumentException("itemView must not be null");
        }
        if (factory == null) {
            factory = BindingRecyclerViewAdapterFactory.DEFAULT;
        }
        if (arg.getItemView() != null) {//解决include出现的问题
            BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
            if (adapter == null) {
                adapter = factory.create(recyclerView, arg);
                adapter.setItems(items);
                adapter.setItemIds(itemIds);
                adapter.setViewHolderFactory(viewHolderFactory);
                if (adapter.getOnItemChildClickListener()==null) {
                    adapter.setOnItemClickListener(new BindingRecyclerViewAdapter.onItemClickListener() {
                        @Override
                        public void onItemClick(int position, View itemView) {
                            if (onItemClickCommand != null) {
                                onItemClickCommand.execute(position, itemView);
                            }
                        }
                    });
                    adapter.setOnItemChildClickListener(new BindingRecyclerViewAdapter.onItemChildClickListener() {
                        @Override
                        public void convert(int position, View itemView) {
                            if (onItemChildClickCommand != null) {
                                onItemChildClickCommand.execute(position, itemView);
                            }
                        }
                    });
                }
                recyclerView.setAdapter(adapter);
            } else {
                adapter.setItems(items);
                if (adapter.getOnItemChildClickListener()==null) {
                    adapter.setOnItemClickListener(new BindingRecyclerViewAdapter.onItemClickListener() {
                        @Override
                        public void onItemClick(int position, View itemView) {
                            if (onItemClickCommand != null) {
                                onItemClickCommand.execute(position, itemView);
                            }
                        }
                    });
                    adapter.setOnItemChildClickListener(new BindingRecyclerViewAdapter.onItemChildClickListener() {
                        @Override
                        public void convert(int position, View itemView) {
                            if (onItemChildClickCommand != null) {
                                onItemChildClickCommand.execute(position, itemView);
                            }
                        }
                    });
                }
            }
        }
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingConversion
    public static BindingRecyclerViewAdapterFactory toRecyclerViewAdapterFactory(final String className) {
        return new BindingRecyclerViewAdapterFactory() {
            @Override
            public <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {
                return Utils.createClass(className, arg);
            }
        };
    }
}
