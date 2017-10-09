package com.kelin.mvvmlight.bindingadapter.view;

import android.databinding.BindingAdapter;
import android.view.View;

import com.kelin.mvvmlight.command.ReplyCommand;

/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {

    public static int MIN_CLICK_DELAY_TIME = 600;//多久之内不能重复点击
    public static long lastClickTime = 0;

    @BindingAdapter({"clickCommand"})
    public static void clickCommand(View view, final ReplyCommand clickCommand) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                    lastClickTime = currentTime;
                    if (clickCommand != null) {
                        clickCommand.execute();
                    }
                }
            }
        });
    }

    @BindingAdapter({"clickCommand", "idName"})
    public static void clickCommand(View view, final ReplyCommand clickCommand, final String idName) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                    lastClickTime = currentTime;
                    if (clickCommand != null) {
                        clickCommand.execute(idName);
                    }
                }
            }
        });
    }

    @BindingAdapter({"clickCommand", "data"})
    public static void clickCommand(View view, final ReplyCommand clickCommand, final Object data) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                    lastClickTime = currentTime;
                    if (clickCommand != null) {
                        clickCommand.execute(data);
                    }
                }
            }
        });
    }

    @BindingAdapter("longClickCommand")
    public static void onLongClick(View view, final ReplyCommand clickCommand) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clickCommand != null) {
                    clickCommand.execute();
                }
                return true;
            }

        });
    }

    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final ReplyCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (onFocusChangeCommand != null) {
                    onFocusChangeCommand.execute(hasFocus);
                }
            }
        });
    }
}

