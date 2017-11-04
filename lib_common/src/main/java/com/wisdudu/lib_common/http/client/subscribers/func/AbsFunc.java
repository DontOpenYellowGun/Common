package com.wisdudu.lib_common.http.client.subscribers.func;

import com.wisdudu.lib_common.http.client.subscribers.exception.ApiException;

import io.reactivex.functions.Function;

/**
 * Created by qyf on 2016/8/18.
 * API返回结果经过map异常处理后直接拿到result
 */

public class AbsFunc<T> implements Function<Abs<T>, T> {

    @Override
    public T apply(Abs<T> tAbs) throws Exception {
        if (tAbs.getErrCode() != 1) {
            throw new ApiException(tAbs.getMessage());
        }
        return tAbs.getResult();
    }
}
