package com.ixuea.courses.mymusic.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ixuea.courses.mymusic.R;

public class ImageUtil {
    /**
     * 显示相对路径图片
     *
     * @param context
     * @param view
     * @param data
     */
    public static void show(Context context, ImageView view, String data) {
        if (TextUtils.isEmpty(data)) {
            //没有图片

            //显示默认图片
            view.setImageResource(R.drawable.placeholder);
            return;
        }

        //将图片地址转为绝对路径
        data = ResourceUtil.resourceUri(data);

        showFull(context, view, data);
    }

    /**
     * 显示绝对路径图片
     *
     * @param context
     * @param view
     * @param data
     */
    private static void showFull(Context context, ImageView view, String data) {
        //获取功能配置
        RequestOptions options = getCommonRequestOptions();

        //显示图片
        Glide.with(context)
                .load(data)
                .apply(options)
                .into(view);
    }

    /**
     * 获取公共配置
     *
     * @return
     */
    public static RequestOptions getCommonRequestOptions() {
        //创建配置选项
        RequestOptions options = new RequestOptions();

        //占位图
//        options.placeholder(R.drawable.placeholder);

        //出错后显示的图片
        //包括：图片不存在等情况
        options.error(R.drawable.placeholder_error);

        //从中心裁剪
//        options.centerCrop()

        return options;
    }


}
