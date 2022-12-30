package com.ixuea.courses.mymusic;

import android.app.Application;
import android.util.Log;

import com.ixuea.courses.mymusic.superui.toast.SuperToast;
import com.tencent.mmkv.MMKV;

/**
 * 全局Application
 */
public class AppContext extends Application {
    private static final String TAG = "AppContext";
    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    /**
     * 初始化 腾讯开源的高性能keyValue存储，用来替代系统的SharedPreferences
     */
    private void initMMKV() {
        String rootDir = MMKV.initialize(this);
        Log.d(TAG, "initMMKV: " + rootDir);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initMMKV();

        //初始化toast工具类
        SuperToast.init(getApplicationContext());
    }

    public void logout() {
    }
}
