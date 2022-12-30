package com.ixuea.courses.mymusic.activity;

import android.content.Intent;


/**
 * 通用界面逻辑
 */
public class BaseCommonActivity extends BaseActivity {
    /**
     * 启动界面并关闭当前界面
     *
     * @param clazz
     */
    protected void startActivityAfterFinishThis(Class<?> clazz) {
        startActivity(clazz);
        finish();
    }

    /**
     * 启动界面
     *
     * @param clazz
     */
    protected void startActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }

}
