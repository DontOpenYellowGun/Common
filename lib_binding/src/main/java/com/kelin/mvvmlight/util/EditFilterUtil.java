package com.kelin.mvvmlight.util;

import android.content.Context;
import android.text.InputFilter;
import android.widget.EditText;

/**
 * edittext不能输入表情公共设置类
 *
 * Created by ypp on 2016/8/9.
 */
public class EditFilterUtil {
    private static final String TAG = "EditFilterUtil";

    public static void setFilter(Context context, EditText editText) {
        editText.setFilters(new InputFilter[]{new EmojiFilter(context)});
    }

    public static void setFilter(Context context, EditText editText, int max) {
        editText.setFilters(new InputFilter[]{new EmojiFilter(context), new InputFilter.LengthFilter(max)});
    }
}
