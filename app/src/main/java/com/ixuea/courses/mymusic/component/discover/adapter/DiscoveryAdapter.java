package com.ixuea.courses.mymusic.component.discover.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.component.ad.model.Ad;
import com.ixuea.courses.mymusic.component.discover.model.ui.BannerData;
import com.ixuea.courses.mymusic.model.ui.BaseMultiItemEntity;
import com.ixuea.courses.mymusic.superui.util.DensityUtil;
import com.ixuea.courses.mymusic.util.Constant;
import com.ixuea.courses.mymusic.util.ImageUtil;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

/**
 * 发现页面适配器
 */
public class DiscoveryAdapter extends BaseMultiItemQuickAdapter<BaseMultiItemEntity, BaseViewHolder> {

    private final Fragment fragment;
    private OnBannerListener onBannerListener;

    public DiscoveryAdapter(Fragment fragment, OnBannerListener onBannerListener) {
        super(new ArrayList<>());
        this.fragment = fragment;
        this.onBannerListener = onBannerListener;

        //添加多类型布局

        //banner类型
        addItemType(Constant.STYLE_BANNER, R.layout.item_discovery_banner);
    }

    /**
     * 绑定数据方法
     * 复用等步骤不用管
     * 框架内部自动处理
     *
     * @param holder
     * @param d
     */
    @Override
    protected void convert(@NonNull BaseViewHolder holder, BaseMultiItemEntity d) {
        switch (holder.getItemViewType()) {
            case Constant.STYLE_BANNER:
                //banner
                BannerData data = (BannerData) d;

                Banner bannerView = holder.getView(R.id.banner);

                BannerImageAdapter<Ad> bannerImageAdapter = new BannerImageAdapter<Ad>(data.getData()) {
                    @Override
                    public void onBindView(BannerImageHolder holder, Ad data, int position, int size) {
                        ImageUtil.show(getContext(), (ImageView) holder.imageView, data.getIcon());
                    }
                };

                bannerView.setAdapter(bannerImageAdapter);

                bannerView.setOnBannerListener(onBannerListener);
                bannerView.setBannerRound(DensityUtil.dip2px(getContext(), 10));

                //添加生命周期观察者
                bannerView.addBannerLifecycleObserver(fragment);

                bannerView.setIndicator(new CircleIndicator(getContext()));
                break;
        }
    }
}
