package com.ixuea.courses.mymusic;

import android.util.Log;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;
import com.ixuea.courses.mymusic.adapter.OnPageChangeListenerAdapter;
import com.ixuea.courses.mymusic.component.ad.model.Ad;
import com.ixuea.courses.mymusic.component.login.activity.LoginHomeActivity;
import com.ixuea.courses.mymusic.component.main.adapter.MainAdapter;
import com.ixuea.courses.mymusic.component.main.tab.TabEntity;
import com.ixuea.courses.mymusic.databinding.ActivityMainBinding;
import com.ixuea.courses.mymusic.util.Constant;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 主界面
 */
public class MainActivity extends BaseViewModelActivity<ActivityMainBinding> {

    private static final int[] indicatorTitles = new int[]{R.string.discovery, R.string.video, R.string.me, R.string.feed, R.string.live};
    private static final int[] indicatorIcons = new int[]{R.drawable.discovery, R.drawable.video, R.drawable.me, R.drawable.feed, R.drawable.live};
    private static final int[] indicatorSelectedIcons = new int[]{R.drawable.discovery_selected, R.drawable.video_selected, R.drawable.me_selected, R.drawable.feed_selected, R.drawable.live_selected};
    private static final String TAG = "MainActivity";
    MainAdapter adapter;

    @Override
    protected void initViews() {
        super.initViews();
        //状态栏透明，内容显示到状态栏
        QMUIStatusBarHelper.translucent(this);

        //缓存页面数量
        //默认是缓存一个
        binding.list.setOffscreenPageLimit(5);

        //指示器
        ArrayList<CustomTabEntity> indicatorTabs = new ArrayList<>();
        for (int i = 0; i < indicatorTitles.length; i++) {
            indicatorTabs.add(
                    new TabEntity(getString(indicatorTitles[i]),
                            indicatorSelectedIcons[i],
                            indicatorIcons[i])
            );
        }
        binding.indicator.setTabData(indicatorTabs);

        //动态tab显示消息提醒
        binding.indicator.showDot(3);
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        adapter = new MainAdapter(getHostActivity(), getSupportFragmentManager());
        binding.list.setAdapter(adapter);

        adapter.setDatum(Arrays.asList(0, 1, 2, 3, 4));

        String action = getIntent().getAction();
        if (Constant.ACTION_LOGIN.equals(action)) {
            //跳转到启动界面
            startActivity(LoginHomeActivity.class);
        }
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        //设置指示器切换监听器
        binding.indicator.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                binding.list.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        binding.list.addOnPageChangeListener(new OnPageChangeListenerAdapter() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.indicator.setCurrentTab(position);
            }
        });
    }

    public void processAdClick(Ad data) {
        Log.d(TAG, "processAdClick: " + data.getIcon());
    }
}