package com.ixuea.courses.mymusic.component.discover.model.ui;

import com.ixuea.courses.mymusic.component.ad.model.Ad;
import com.ixuea.courses.mymusic.model.ui.BaseMultiItemEntity;
import com.ixuea.courses.mymusic.util.Constant;

import java.util.List;

public class BannerData implements BaseMultiItemEntity {
    private List<Ad> data;

    public BannerData(List<Ad> data) {
        this.data = data;
    }

    public List<Ad> getData() {
        return data;
    }

    public void setData(List<Ad> data) {
        this.data = data;
    }

    @Override
    public int getItemType() {
        return Constant.STYLE_BANNER;
    }
}
