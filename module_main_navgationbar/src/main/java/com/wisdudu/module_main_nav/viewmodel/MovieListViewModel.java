package com.wisdudu.module_main_nav.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.view.View;

import com.kelin.mvvmlight.collectionadapter.ItemView;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.kelin.mvvmlight.command.ReplyItemCommand;
import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.lib_common.base.BaseListViewModel;
import com.wisdudu.lib_common.util.ToastUtil;
import com.wisdudu.module_main_nav.BR;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件描述：电影列表ViewModel
 * <p>
 * 作者：   Created by Sven on 2017/8/18.
 */

public class MovieListViewModel implements BaseListViewModel {

    //<editor-fold desc="日志标记    Tag">
    private static final String TAG = "MovieListViewModel";
    //</editor-fold>

    //<editor-fold desc="基类对象    BaseFragment">
    private BaseFragment mFragment;
    //</editor-fold>

    //<editor-fold desc="数据模型    Items">
    public final ObservableList<Movie> items = new ObservableArrayList<>();
    //</editor-fold>

    //<editor-fold desc="子视图层    ItemView">
    public final ItemView itemView = ItemView.of(BR.model, R.layout.main_nav_item_movie);
    //</editor-fold>

    //<editor-fold desc="控件命令    Command">
    //<editor-fold desc="下拉刷新">
    public final ReplyCommand onRefreshCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            viewStyle.isRefreshing.set(true);
            getData();
        }
    });
    //</editor-fold>
    //<editor-fold desc="加载更多">
    public final ReplyCommand onLoadMoreCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            viewStyle.isLoadingMore.set(true);
            getData();
        }
    });
    //</editor-fold>
    //<editor-fold desc="子项点击">
    public final ReplyItemCommand<Integer, View> itemClickCommand = new ReplyItemCommand<>(new BiConsumer<Integer, View>() {
        @Override
        public void accept(final Integer integer, View view) throws Exception {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.INSTANCE.toast(String.valueOf(integer));
                }
            });
        }
    });
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="视图风格    ViewStyle">
    public final ViewStyle viewStyle = new ViewStyle();

    public class ViewStyle {
        public final ObservableField<Boolean> isRefreshing = new ObservableField<>(true);
        public final ObservableField<Boolean> isLoadingMore = new ObservableField<>(false);
    }
    //</editor-fold>

    //<editor-fold desc="构造方法    Construction">
    public MovieListViewModel(BaseFragment fragment) {
        this.mFragment = fragment;
    }
    //</editor-fold>

    //<editor-fold desc="接口请求    Api">
    private void getData() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            movies.add(new Movie("name" + i, "time" + i));
        }

        Observable.just(movies)
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mFragment.<List<Movie>>bindToLifecycle())
                .subscribe(new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> s) throws Exception {
                        if (viewStyle.isRefreshing.get()) {
                            items.clear();
                            viewStyle.isRefreshing.set(false);
                        } else {
                            viewStyle.isLoadingMore.set(false);
                        }
                        items.addAll(s);
                    }
                });
    }
    //</editor-fold>
}

