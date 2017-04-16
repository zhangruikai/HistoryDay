package com.baway.project.historyday.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.baway.library.glide.GlideUtils;
import com.baway.project.historyday.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import uk.co.senab.photoview.PhotoView;
public class ImageViewShow extends Activity implements View.OnClickListener {
    private PhotoView puotoView;
    private ImageView save;
    private ImageView backButton;
    private String img;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_show);
        init();
    }
    private void init() {
        puotoView = (PhotoView) findViewById(R.id.puotoView);
        backButton = (ImageView) findViewById(R.id.backButton);
        save = (ImageView) findViewById(R.id.save);
        Intent intent = getIntent();
        img = intent.getStringExtra("img");
        bitmap = getBitmap(img);
        GlideUtils.loadImage1(ImageViewShow.this, img,puotoView);
        backButton.setOnClickListener(this);
        save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
                case R.id.backButton:
                    new Thread() {
                        public void run() {
                            try {
                                Instrumentation inst = new Instrumentation();
                                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                            } catch (Exception e) {
                            }
                        }
                    }.start();
                    break;
                case R.id.save:

                    SavaImage(bitmap, Environment.getExternalStorageDirectory()+"/Test");

                    Toast.makeText(ImageViewShow.this,"下载成功",Toast.LENGTH_SHORT).show();


                    break;

        }


    }
    public void SavaImage(Bitmap bitmap, String path){
        File file=new File(path);
        FileOutputStream fileOutputStream=null;
        //文件夹不存在，则创建它
        if(!file.exists()){
            file.mkdir();
        }
        try {
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Bitmap getBitmap(String url) {
        Bitmap bm = null;
        try {
            URL iconUrl = new URL(url);
            URLConnection conn = iconUrl.openConnection();
            HttpURLConnection http = (HttpURLConnection) conn;

            int length = http.getContentLength();

            conn.connect();
            // 获得图像的字符流
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is, length);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();// 关闭流
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }
}
