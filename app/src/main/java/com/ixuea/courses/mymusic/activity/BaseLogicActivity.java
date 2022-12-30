package com.ixuea.courses.mymusic.activity;

import android.view.View;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.superui.loading.SuperRoundLoadingDialogFragment;
import com.ixuea.courses.mymusic.util.PreferenceUtil;
import com.ixuea.courses.mymusic.view.PlaceholderView;

import java.lang.ref.WeakReference;

/**
 * 项目中特有逻辑
 * <p>
 * 例如:显示迷你控制栏播放状态
 */
public class BaseLogicActivity extends BaseCommonActivity {

    protected PreferenceUtil sp;
    private WeakReference<SuperRoundLoadingDialogFragment> loadingWeakReference;
    private PlaceholderView placeholderView;

    @Override
    protected void initDatum() {
        super.initDatum();
        sp = PreferenceUtil.getInstance(getHostActivity());
    }

    /**
     * 获取界面方法
     *
     * @return
     */
    protected BaseLogicActivity getHostActivity() {
        return this;
    }

    /**
     * 显示加载对话框
     */
    public void showLoading() {
        showLoading(getString(R.string.loading));
    }

    /**
     * 显示加载对话框
     */
    public void showLoading(int data) {
        showLoading(getString(data));
    }

    /**
     * 显示加载对话框
     */
    public void showLoading(String message) {
        if (loadingWeakReference == null || loadingWeakReference.get() == null) {
            loadingWeakReference = new WeakReference<>(
                    SuperRoundLoadingDialogFragment.newInstance(message)
            );
        }

        SuperRoundLoadingDialogFragment dialog = loadingWeakReference.get();
        if (dialog.getDialog() == null || !dialog.getDialog().isShowing()) {
            dialog.show(getSupportFragmentManager(), "SuperRoundLoadingDialogFragment");
        }
    }

    /**
     * 隐藏加载对话框
     */
    public void hideLoading() {
        SuperRoundLoadingDialogFragment dialog = loadingWeakReference.get();
        if (dialog != null) {
            dialog.dismiss();
            loadingWeakReference.clear();
        }
        loadingWeakReference = null;
    }

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
