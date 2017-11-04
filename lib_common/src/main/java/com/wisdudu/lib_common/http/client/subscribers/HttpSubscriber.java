package com.wisdudu.lib_common.http.client.subscribers;

import com.orhanobut.logger.Logger;
import com.wisdudu.lib_common.http.client.subscribers.exception.ApiException;
import com.wisdudu.lib_common.http.client.subscribers.exception.ExceptionHandle;
import com.wisdudu.lib_common.http.client.subscribers.exception.NetException;
import com.wisdudu.lib_common.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/9/26.
 */

public abstract class HttpSubscriber<T> implements Observer<T> {

    private static final String TAG = "HttpSubscriber";

    private Disposable disposable;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        if (!NetUtil.INSTANCE.isConnected()) {
            if (!disposable.isDisposed()) {
                onError(ExceptionHandle.handleException(new NetException("网络未连接")));
            }
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (e instanceof Exception) {
            //访问获得对应的Exception
            onError(ExceptionHandle.handleException(e));
            Logger.d(ExceptionHandle.handleException(e));
        } else {
            //将Throwable 和 未知错误的status code返回
            onError(new ExceptionHandle.ResponseThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
            Logger.d(new ExceptionHandle.ResponseThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }
        disposable.dispose();
    }

    @Override
    public void onComplete() {
        Logger.d("HttpSubscriber:onComplete");
    }

    protected abstract void onSuccess(@NonNull T t);

    protected abstract void onError(ExceptionHandle.ResponseThrowable responseThrowable);

}
