package com.wisdudu.lib_common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by qyf on 2016/3/12.
 * 枚举单例改写 使用方法：ToastUtil.INSTANCE.show("显示内容")
 */
public enum ToastUtil {
    INSTANCE;
    private Toast toast;
    private Context context;

    @SuppressLint("ShowToast")
    public void init(Context context) {
        this.context = context;
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    private void show(final CharSequence content, final int duration) {
        if (content.length() != 0) {
            AndroidSchedulers.mainThread().createWorker().schedule(new Runnable() {
                @Override
                public void run() {
                    toast.setText(content);
                    toast.setDuration(duration);
                    toast.show();
                }
            });
        }
    }

    private void show(CharSequence content) {
        show(content, Toast.LENGTH_SHORT);
    }

    public void toast(String text) {
        show(text);
    }

    public void toast(int textId) {
        show(context.getString(textId));
    }

    public void toastLong(String text) {
        show(text, Toast.LENGTH_LONG);
    }

}
