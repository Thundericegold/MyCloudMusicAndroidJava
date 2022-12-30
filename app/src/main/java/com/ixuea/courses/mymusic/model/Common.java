package com.ixuea.courses.mymusic.model;

/**
 * 所有模型父类
 * <p>
 * 这里时间不参与比较，所以不重写equals，hashCode
 * 如果项目中需要参数比较，要重写
 */
public class Common extends BaseId {
    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 更新时间
     */
    private String updatedAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
