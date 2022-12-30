package com.ixuea.courses.mymusic.component.ad.model;

import com.ixuea.courses.mymusic.model.Common;

/**
 * 广告模型
 */
public class Ad extends Common {
    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    private String icon;

    /**
     * 点击广告后跳转的地址
     */
    private String uri;

    /**
     * 类型，0:图片;10:视频;20:应用
     */
    private byte style;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public byte getStyle() {
        return style;
    }

    public void setStyle(byte style) {
        this.style = style;
    }
}
