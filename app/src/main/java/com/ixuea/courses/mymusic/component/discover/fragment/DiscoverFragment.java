package com.ixuea.courses.mymusic.component.discover.fragment;

import static autodispose2.AutoDispose.autoDisposable;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.mymusic.MainActivity;
import com.ixuea.courses.mymusic.component.ad.model.Ad;
import com.ixuea.courses.mymusic.component.api.HttpObserver;
import com.ixuea.courses.mymusic.component.discover.adapter.DiscoveryAdapter;
import com.ixuea.courses.mymusic.component.discover.model.ui.BannerData;
import com.ixuea.courses.mymusic.databinding.FragmentDiscoveryBinding;
import com.ixuea.courses.mymusic.fragment.BaseViewModelFragment;
import com.ixuea.courses.mymusic.model.response.ListResponse;
import com.ixuea.courses.mymusic.model.ui.BaseMultiItemEntity;
import com.ixuea.courses.mymusic.repository.DefaultRepository;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.rxjava3.core.Observable;

/**
 * 首页-发现界面
 */
public class DiscoverFragment extends BaseViewModelFragment<FragmentDiscoveryBinding> implements OnBannerListener {

    private LinearLayoutManager layoutManager;
    /**
     * 列表数据集合
     */
    private List<BaseMultiItemEntity> datum;
    private DiscoveryAdapter adapter;

    public static DiscoverFragment newInstance() {

        Bundle args = new Bundle();

        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        super.initViews();
        //高度固定
        //可以提高性能
        binding.list.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getHostActivity());
        binding.list.setLayoutManager(layoutManager);

        //分隔线
        DividerItemDecoration decoration = new DividerItemDecoration(binding.list.getContext(), RecyclerView.VERTICAL);
        binding.list.addItemDecoration(decoration);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        //创建适配器
        adapter = new DiscoveryAdapter(this, this);

        //设置适配器
        binding.list.setAdapter(adapter);

        loadData();
    }

    @Override
    protected void loadData(boolean isPlaceholder) {
        super.loadData(isPlaceholder);

        datum = new ArrayList<>();

        //广告API
        Observable<ListResponse<Ad>> ads = DefaultRepository.getInstance().bannerAd();

        ads
                .to(autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new HttpObserver<ListResponse<Ad>>(this) {
                    @Override
                    public void onSucceeded(ListResponse<Ad> data) {
                        //添加轮播图
                        datum.add(new BannerData(
                                data.getData().getData()
                        ));

                        //设置数据到适配器
                        adapter.setNewInstance(datum);
                    }
                });
    }

    /**
     * 轮播图点击
     *
     * @param data
     * @param position
     */
    @Override
    public void OnBannerClick(Object data, int position) {
        ((MainActivity) getHostActivity()).processAdClick((Ad) data);
    }
}
