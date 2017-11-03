package com.wisdudu.lib_common.http.client.subscribers.func;

import com.google.gson.annotations.SerializedName;

/**
 * 文件描述：Response通用Model
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class Abs<T> {

    @SerializedName(value = "errCode", alternate = {"return_num", "errcode"})
    private int errCode;
    @SerializedName(value = "message", alternate = {"return_msg", "errmsg"})
    private String message;
    @SerializedName(value = "result", alternate = {"return_result"})
    private T result;

    public String getMessage() {
        return message;
    }

    public int getErrCode() {
        return errCode;
    }

    public boolean isSuccess() {
        return errCode == 1;
    }

    public T getResult() {
        return result;
    }

}
