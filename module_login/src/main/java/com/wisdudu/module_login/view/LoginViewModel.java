package com.wisdudu.module_login.view;

import android.databinding.ObservableField;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.wisdudu.lib_common.base.BaseActivity;
import com.wisdudu.lib_common.http.UserRemoteDataSource;
import com.wisdudu.lib_common.http.client.subscribers.Abs;
import com.wisdudu.lib_common.http.subscriber.HttpSubscriber;
import com.wisdudu.module_login.databinding.LoginActivityLoginBinding;


import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by Sven on 2017/8/18.
 */

public class LoginViewModel {

    //<editor-fold desc="日志标记    Tag">
    private static final String TAG = "LoginViewModel";
    //</editor-fold>

    //<editor-fold desc="基类对象    BaseActivity">
    private BaseActivity mActivity;
    //</editor-fold>

    //<editor-fold desc="数据模型    Items">
    public ObservableField<String> phone = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    //</editor-fold>

    //<editor-fold desc="控件命令    Command">
    //<editor-fold desc="登录">
    public final ReplyCommand loginCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            login();
        }
    });
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="视图风格    ViewStyle">
    private LoginActivityLoginBinding mBinding;

    public final ViewStyle viewStyle = new ViewStyle();

    public class ViewStyle {
        public final ObservableField<Boolean> isShowProgress = new ObservableField<>(false);
    }
    //</editor-fold>

    //<editor-fold desc="构造方法    Construction">
    public LoginViewModel(BaseActivity activity, LoginActivityLoginBinding mBinding) {
        this.mActivity = activity;
        this.mBinding = mBinding;
    }
    //</editor-fold>

    //<editor-fold desc="接口请求    Api">
    private void login() {
        viewStyle.isShowProgress.set(true);
        UserRemoteDataSource.INSTANCE
                .login(phone.get(), password.get())
                .subscribe(new HttpSubscriber<Abs>() {
                    @Override
                    protected void onSuccess(@NonNull Abs abs) {
                        viewStyle.isShowProgress.set(false);
                        ARouter.getInstance().build("/main/MainActivity").navigation();
                    }
                });
    }
    //</editor-fold>
}

