package com.baway.library.okhttp;

import android.content.Context;
import android.net.ConnectivityManager;

import java.io.InputStream;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/16 16:02
 */
public class NetUtils {


    public static boolean checkNet(Context context){
        if(isNetworkAvailable(context)){
            return ping();
        }else {
            return false;
        }
    }
    /**
     * 检测网络是否连接
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        // 得到网络连接信息
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            return manager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    /**
     * 判断网络是否可用
     * @category 判断是否有外网连接（普通方法不能判断外网的网络是否连接，比如连接上局域网）
     * * @return
     */
    public static boolean ping() {
        try {
            String ip = "www.baidu.com";// ping 的地址，可以换成任何一种可靠的外网
            Process p = Runtime.getRuntime().exec("ping -c 1 -w 100 " + ip);// ping网址3次
            // 读取ping的内容，可以不加
            InputStream input = p.getInputStream();
            // ping的状态
            int status = p.waitFor();
            return status==0?true:false;
        } catch (Exception e) {
            return false;
        }
    }
}
