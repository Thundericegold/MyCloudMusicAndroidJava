package com.ixuea.courses.mymusic.fragment;

import android.content.Intent;

/**
 * 通用公共Fragment
 */
public abstract class BaseCommonFragment extends BaseFragment {
    /**
     * 启动界面并关闭当前界面
     *
     * @param clazz
     */
    protected void startActivityAfterFinishThis(Class<?> clazz) {
        Intent intent = new Intent(getHostActivity(), clazz);
        startActivity(intent);
        getHostActivity().finish();
    }
}
