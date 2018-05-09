package com.guddqs.common;

import com.guddqs.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
public class PageEntity<T> {

    private List<T> data = new ArrayList<T>();
    private int total;

    private Map<String, ?> map;

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();

        map.put("success", true);
        map.put("total", total);
        map.put("data", data);
        if (this.map != null) {
            map.putAll(this.map);
        }

        return JsonUtils.getJsonString(map);
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<String, ?> getMap() {
        return map;
    }

    public void setMap(Map<String, ?> map) {
        this.map = map;
    }
}
