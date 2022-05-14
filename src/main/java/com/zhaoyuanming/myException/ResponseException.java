package com.zhaoyuanming.myException;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>响应异常</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-13 18:48
 * @Version : 1.0
 **/
public class ResponseException extends Exception {
    public ResponseException(String message) {
        super(message);
    }
}
