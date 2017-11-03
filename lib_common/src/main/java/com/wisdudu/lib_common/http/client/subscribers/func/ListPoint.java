package com.wisdudu.lib_common.http.client.subscribers.func;

/**
 * 文件描述：带List节点的通用Model
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */

public class ListPoint<T> {

    private T list;

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
