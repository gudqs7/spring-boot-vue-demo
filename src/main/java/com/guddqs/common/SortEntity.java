package com.guddqs.common;

/**
 * @author wq
 * @date 2018/5/8
 */
public class SortEntity {
    private String field;
    private String cast;
    private String direction;
    public String getField() {
        return field;
    }
    public void setField(String property) {
        this.field = property;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
