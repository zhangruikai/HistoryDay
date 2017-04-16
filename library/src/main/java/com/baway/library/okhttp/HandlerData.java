package com.baway.library.okhttp;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/17 10:55
 * 构造一个Handler事件的处理机制
 * @param <T>
 */
import java.io.IOException;

public class HandlerData<T> {
    HttpCallBack<T> httpCallBack;
    T t;
    IOException e;

    public HandlerData(HttpCallBack<T> httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

    public void success(){
        if(httpCallBack!=null)
            httpCallBack.success(t);
    }

    public void error(){
        if(httpCallBack!=null)
            httpCallBack.error(e);
    }
}