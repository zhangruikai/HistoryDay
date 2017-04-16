package com.baway.library.glide;

import android.content.Context;
import android.widget.ImageView;

import com.baway.library.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/16 10:12
 */
public class GlideUtils {
    public static void loadImage(Context context, String imageUrl, ImageView imageView){
        Glide.with(context).load(imageUrl)
                .thumbnail(0.7F)
                .override(800,600)
                .placeholder(R.drawable.aa)
                .error(R.drawable.bb)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)//跳过内存缓存
                .dontAnimate()//加载无动画
//                .centerCrop()
                .fitCenter()
//                .bitmapTransform(new CropCircleTransformation(Glide.get(context).getBitmapPool()))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
    }

    public static void loadImage1(Context context, String imageUrl, ImageView imageView){
        Glide.with(context).load(imageUrl)
                .placeholder(R.drawable.aa)
                .error(R.drawable.bb)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)//跳过内存缓存
                .dontAnimate()//加载无动画
                .centerCrop()
                .into(imageView);
    }

}
