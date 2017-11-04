package com.wisdudu.lib_common.http.client.subscribers.exception;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/11/4.
 */

public class ApiException extends RuntimeException {

    private String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
