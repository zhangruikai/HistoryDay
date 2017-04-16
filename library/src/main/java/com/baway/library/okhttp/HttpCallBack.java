package com.baway.library.okhttp;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/17 10:56
 */

import java.io.IOException;

/**
 * 响应的回调接口
 * @param <T>
 */
public interface HttpCallBack<T>{
    void success(T t);
    void error(IOException e);
}