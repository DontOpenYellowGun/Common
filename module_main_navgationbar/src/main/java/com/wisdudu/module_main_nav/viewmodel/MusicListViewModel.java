package com.wisdudu.module_main_nav.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.view.View;

import com.kelin.mvvmlight.collectionadapter.ItemView;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.kelin.mvvmlight.command.ReplyItemCommand;
import com.weavey.loading.lib.LoadingLayout;
import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.lib_common.base.BaseListViewModel;
import com.wisdudu.lib_common.http.UserRemoteDataSource;
import com.wisdudu.lib_common.http.client.subscribers.HttpSubscriber;
import com.wisdudu.lib_common.http.client.subscribers.exception.ExceptionHandle;
import com.wisdudu.lib_common.http.client.subscribers.func.Abs;
import com.wisdudu.lib_common.util.ToastUtil;
import com.wisdudu.module_main_nav.BR;
import com.wisdudu.module_main_nav.R;
import com.wisdudu.module_main_nav.api.TestRemoteDataSource;
import com.wisdudu.module_main_nav.api.TestService;
import com.wisdudu.module_main_nav.model.Brand;
import com.wisdudu.module_main_nav.model.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件描述：电影列表ViewModel
 * <p>
 * 作者：   Created by Sven on 2017/8/18.
 */

public class MusicListViewModel implements BaseListViewModel {

    //<editor-fold desc="日志标记    Tag">
    private static final String TAG = "MovieListViewModel";
    //</editor-fold>

    //<editor-fold desc="基类对象    BaseFragment">
    private BaseFragment mFragment;
    //</editor-fold>

    //<editor-fold desc="数据模型    Items">
    public final ObservableList<Brand> items = new ObservableArrayList<>();
    //</editor-fold>

    //<editor-fold desc="子视图层    ItemView">
    public final ItemView itemView = ItemView.of(BR.model, R.layout.main_nav_item_music);
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
    //<editor-fold desc="重新加载">
    public final ReplyCommand reloadCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            viewStyle.pageState.set(LoadingLayout.Loading);
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

    //<editor-fold desc="视图驱动    ViewStyle">
    public final ViewStyle viewStyle = new ViewStyle();

    public class ViewStyle {
        public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);
        public final ObservableField<Boolean> isLoadingMore = new ObservableField<>(false);
        public final ObservableField<Integer> pageState = new ObservableField<>(LoadingLayout.Loading);
        public final ObservableField<String> errorMsg = new ObservableField<>();
    }
    //</editor-fold>

    //<editor-fold desc="构造方法    Construction">
    public MusicListViewModel(BaseFragment fragment) {
        this.mFragment = fragment;
        getData();
    }
    //</editor-fold>

    //<editor-fold desc="接口请求    Api">
    private void getData() {
        TestRemoteDataSource.INSTANCE
                .getBrandList(14)
                .compose(mFragment.<List<Brand>>bindToLifecycle())
                .subscribe(new HttpSubscriber<List<Brand>>() {
                    @Override
                    protected void onSuccess(List<Brand> models) {
                        if (viewStyle.isRefreshing.get()) {
                            viewStyle.isRefreshing.set(false);
                            items.clear();
                        } else {
                            viewStyle.isLoadingMore.set(false);
                        }
                        items.addAll(models);
                        viewStyle.pageState.set(items.size() > 0 ? LoadingLayout.Success : LoadingLayout.Empty);
                    }

                    @Override
                    protected void onError(ExceptionHandle.ResponseThrowable responseThrowable) {
                        viewStyle.isRefreshing.set(false);
                        viewStyle.isLoadingMore.set(false);
                        viewStyle.errorMsg.set(responseThrowable.message);
                        viewStyle.pageState.set(LoadingLayout.Error);
                    }
                });
    }
    //</editor-fold>
}

