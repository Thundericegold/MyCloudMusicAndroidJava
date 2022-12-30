package com.ixuea.courses.mymusic.fragment;

import android.view.View;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.view.PlaceholderView;

/**
 * 项目中特有逻辑
 */
public abstract class BaseLogicFragment extends BaseCommonFragment {
    private PlaceholderView placeholderView;

    /**
     * 加载数据方法
     *
     * @param isPlaceholder 是否是通过placeholder控件触发的
     */
    protected void loadData(boolean isPlaceholder) {

    }

    /**
     * 加载数据方法
     */
    protected void loadData() {
        loadData(false);
    }

    /**
     * 获取当前界面占位view
     *
     * @return
     */
    public PlaceholderView getPlaceholderView() {
        if (placeholderView == null) {
            placeholderView = findViewById(R.id.placeholder);
            placeholderView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadData(true);
                }
            });
        }
        return placeholderView;
    }
}
