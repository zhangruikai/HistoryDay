package com.baway.library.okhttp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/16 15:50
 */
public class NetHttpUtils {
    //状态  handler what
    private static final int SUCCESS_CODE = 1;
    private static final int ERROR_CODE = 2;
    private static NetHttpUtils sInstance;
    private OkHttpClient mOkHttpClient;




    /**
     * 通过Handler 来由子线程切换主线程
     */
    private Handler mHandler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case SUCCESS_CODE:
                   ((HandlerData)msg.obj).success();
                   break;
               case ERROR_CODE:
                   ((HandlerData)msg.obj).error();
                   break;
           }
        }
    };
    private Gson mGson;

    private NetHttpUtils(){
        //初始化OkHttp
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();

        mGson=new Gson();
    }

    public static NetHttpUtils getInstance(){
        if(sInstance==null){
            NetHttpUtils netHttpUtils=null;
            synchronized (NetHttpUtils.class){
                if(sInstance==null){
                    netHttpUtils=new NetHttpUtils();
                    sInstance=netHttpUtils;
                }
            }
        }
        return sInstance;
    }

    public <T> void get(Context context, String urlPath, Map<String,Object> map
            ,HttpCallBack httpCallBack){
        if(NetUtils.checkNet(context)){
            String url= makeUrl(urlPath,map);
            _get(url,httpCallBack);
        }else{
            Toast.makeText(context, "没有网络！！！", Toast.LENGTH_SHORT).show();
        }
    }

    private <T>void _get(String url, HttpCallBack<T> httpCallBack) {
        Request request=getRequest(url);
        enqueue(request,httpCallBack);
    }

    private <T> void enqueue(Request request, final HttpCallBack<T> httpCallBack) {
        Call call = mOkHttpClient.newCall(request);

        final HandlerData<T> hn=new HandlerData<T>(httpCallBack);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                hn.e=e;
                mHandler.sendMessage(getMessage(ERROR_CODE,hn));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if(result!=null){
                    Class<T> returnType = getType(httpCallBack);
                    T t = mGson.fromJson(result,returnType);
                    hn.t=t;
                    mHandler.sendMessage(getMessage(SUCCESS_CODE,hn));
                }else {
                    hn.e=new IOException("没有数据");
                    mHandler.sendMessage(getMessage(ERROR_CODE,hn));
                }
            }
        });
    }

    private <T> Class<T> getType(HttpCallBack<T> httpCallBack) {
        Type type=httpCallBack.getClass().getGenericSuperclass();
        if(!(type instanceof ParameterizedType)){
            Type[] genType = httpCallBack.getClass().getGenericInterfaces();
            if(genType!=null&&genType.length>0)
                type=genType[0];
        }

        if(type instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType)type;
            Type [] types = parameterizedType.getActualTypeArguments();
            if(types!=null&&types.length>0)
                return (Class<T>) types[0];
            else {
                Log.e("Okhttp","return解析出错！！！");
                return  null;
            }
        }else {
            Log.e("Okhttp","return解析出错！！！");
            return  null;
        }

    }

    private Request getRequest(String url) {
        return new Request.Builder()
                .url(url)
                .build();
    }

    /**
     * get 对URL和请求参数的拼接
     * @param urlPath
     * @param map
     * @return
     */
    private String makeUrl(String urlPath, Map<String, Object> map) {
        if(map==null||map.size()==0)
            return urlPath;
        StringBuffer sb=new StringBuffer();
        for(String key:map.keySet()){
            sb.append(key+"="+map.get(key)+"&");
        }
        return urlPath+"?"+sb.substring(0,sb.length()-1);
    }


    /**
     * 构造Message对象
     * @param what
     * @param obj
     * @return
     */
    private Message getMessage(int what,Object obj){
        Message msg=Message.obtain();
        msg.what=what;
        msg.obj=obj;
        return msg;
    }
}
