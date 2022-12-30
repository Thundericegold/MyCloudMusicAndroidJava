package com.ixuea.courses.mymusic.model;

import java.util.Objects;

/**
 * 所有模型Id父类
 */
public class BaseId extends Base {
    /**
     * Id
     */
    private String id;

    public BaseId() {

    }

    public BaseId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId baseId = (BaseId) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
