package com.ixuea.courses.mymusic.component.sheet.model;

import com.ixuea.courses.mymusic.model.Common;

/**
 * 歌单模型
 */
public class Sheet extends Common {
    /**
     * 歌单标题
     */
    private String title;

    /**
     * 歌单封面
     */
    private String icon;

    /**
     * 描述
     */
    private String detail;

    /**
     * 点击数
     */
    private int clicksCount;

    /**
     * 收藏数
     */
    private int collectsCount;

    /**
     * 评论数
     */
    private int commentsCount;

    /**
     * 音乐数量
     */
    private int songsCount;


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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getClicksCount() {
        return clicksCount;
    }

    public void setClicksCount(int clicksCount) {
        this.clicksCount = clicksCount;
    }

    public int getCollectsCount() {
        return collectsCount;
    }

    public void setCollectsCount(int collectsCount) {
        this.collectsCount = collectsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getSongsCount() {
        return songsCount;
    }

    public void setSongsCount(int songsCount) {
        this.songsCount = songsCount;
    }


}
