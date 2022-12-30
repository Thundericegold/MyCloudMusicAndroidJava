package com.ixuea.courses.mymusic.util;

import android.content.Context;

import com.tencent.mmkv.MMKV;

/**
 * 偏好设置工具类
 * 是否登录了，是否显示引导界面，用户Id
 */
public class PreferenceUtil {

    /**
     * 是否显示引导界面key
     */
    private static final String SHOW_GUIDE = "SHOW_GUIDE";
    private static PreferenceUtil instance;
    private final Context context;
    private final MMKV preference;

    /**
     * 构造方法
     *
     * @param context
     */
    public PreferenceUtil(Context context) {
        //保存上下文
        this.context = context.getApplicationContext();

        //初始化腾讯开源的高性能key,value存储，可以写到单独的类中
        preference = MMKV.defaultMMKV();
    }

    /**
     * 获取偏好设置单例
     *
     * @param context
     * @return
     */
    public synchronized static PreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance = new PreferenceUtil(context);
        }
        return instance;
    }

    /**
     * 是否显示引导界面
     *
     * @return
     */
    public boolean isShowGuide() {
        return getBoolean(SHOW_GUIDE, true);
    }

    /**
     * 设置是否显示引导界面
     *
     * @param value
     */
    public void setShowGuide(boolean value) {
        putBoolean(SHOW_GUIDE, value);
    }

    //region 辅助方法

    /**
     * 获取boolean
     *
     * @param key
     * @param defaultValue
     * @return
     */
    private boolean getBoolean(String key, boolean defaultValue) {
        return preference.getBoolean(key, defaultValue);
    }

    /**
     * 保存boolean
     *
     * @param key
     * @param value
     */
    private void putBoolean(String key, boolean value) {
        preference.edit().putBoolean(key, value).apply();
    }
    //endregion

}
