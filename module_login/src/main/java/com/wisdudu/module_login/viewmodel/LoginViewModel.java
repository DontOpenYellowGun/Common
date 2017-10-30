package com.wisdudu.module_login.viewmodel;

import android.databinding.ObservableField;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kelin.mvvmlight.command.ReplyCommand;

import com.wisdudu.lib_common.base.BaseActivity;
import com.wisdudu.lib_common.base.BaseFragment;

import com.wisdudu.module_login.databinding.LoginFragmentLoginBinding;

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
    private BaseFragment mBaseFragment;
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
    private LoginFragmentLoginBinding mBinding;

    public final ViewStyle viewStyle = new ViewStyle();

    public class ViewStyle {
        public final ObservableField<Boolean> isShowProgress = new ObservableField<>(false);
    }
    //</editor-fold>

    //<editor-fold desc="构造方法    Construction">
    public LoginViewModel(BaseFragment baseFragment, LoginFragmentLoginBinding mBinding) {
        this.mBaseFragment = baseFragment;
        this.mBinding = mBinding;
    }
    //</editor-fold>

    //<editor-fold desc="接口请求    Api">
    private void login() {
//        viewStyle.isShowProgress.set(true);
//        UserRemoteDataSource.INSTANCE
//                .login(phone.get(), password.get())
//                .subscribe(new HttpSubscriber<Abs>() {
//                    @Override
//                    protected void onSuccess(@NonNull Abs abs) {
//                        viewStyle.isShowProgress.set(false);
//                        Hawk.put(LoginState.IS_LOGIN, true);
//                        mBaseFragment.startWithPop("/main/MainFragment");
//                    }
//                });
        ARouter.getInstance().build("/main/MainActivity").navigation();
        mBaseFragment.getActivity().finish();
    }
    //</editor-fold>
}

