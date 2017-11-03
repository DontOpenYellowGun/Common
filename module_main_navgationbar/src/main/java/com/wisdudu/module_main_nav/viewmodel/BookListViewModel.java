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
import com.wisdudu.module_main_nav.model.Book;

import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;

/**
 * 文件描述：书籍列表ViewModel
 * <p>
 * 作者：   Created by sven on 2017/11/1.
 */

public class BookListViewModel implements BaseListViewModel {

    //<editor-fold desc="日志标记    Tag">
    private static final String TAG = "BookListViewModel";
    //</editor-fold>

    //<editor-fold desc="基类对象    BaseFragment">
    private BaseFragment mFragment;
    //</editor-fold>

    //<editor-fold desc="数据模型    Items">
    public ObservableList<Book> items = new ObservableArrayList<>();
    //</editor-fold>

    //<editor-fold desc="子视图层    ItemView">
    public ItemView itemView = ItemView.of(BR.model, R.layout.main_nav_item_book);
    //</editor-fold>

    //<editor-fold desc="控件命令    Command">
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
    //<editor-fold desc="其他">
    public final ReplyCommand otherCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {

        }
    });
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="视图风格    ViewStyle">
    public final ViewStyle viewStyle = new ViewStyle();

    public class ViewStyle {
        public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);
    }
    //</editor-fold>

    //<editor-fold desc="构造方法    Construction">
    public BookListViewModel(BaseFragment fragment) {
        this.mFragment = fragment;
        for (int i = 0; i < 100; i++) {
            items.add(new Book("name" + i, i + "$","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509598637868&di=ddbba4988b884ac7e93dc914f605d731&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Df3a9870fc9fc1e17fdea84357fa0da35%2F94cad1c8a786c917cf3e6220cf3d70cf3bc757ed.jpg"));
        }
    }
    //</editor-fold>
}
