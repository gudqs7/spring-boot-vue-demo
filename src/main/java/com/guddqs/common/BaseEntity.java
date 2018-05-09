package com.guddqs.common;

import com.guddqs.utils.JsonUtils;

/**
 * @author wq
 * @date 2018/5/8
 */
public class BaseEntity {

    private String lastUpdateUserId;
    private String lastUpdateDate;
    private String firstCreateDate;
    private String firstCreateUserId;

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getFirstCreateDate() {
        return firstCreateDate;
    }

    public void setFirstCreateDate(String firstCreateDate) {
        this.firstCreateDate = firstCreateDate;
    }

    public String getFirstCreateUserId() {
        return firstCreateUserId;
    }

    public void setFirstCreateUserId(String firstCreateUserId) {
        this.firstCreateUserId = firstCreateUserId;
    }

    @Override
    public String toString() {
        return JsonUtils.getJsonString(this);
    }
}
