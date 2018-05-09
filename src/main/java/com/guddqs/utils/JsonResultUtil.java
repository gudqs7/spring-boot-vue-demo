package com.guddqs.utils;

import com.guddqs.common.MapBean;
import com.guddqs.common.PageEntity;

/**
 * @author wq
 * @date 2018/5/8
 */
public class JsonResultUtil {

    public static MapBean successResult() {
        MapBean map = new MapBean();
        map.put("success", true);
        map.put("data", "");
        return map;
    }

    public static MapBean successResult(Object data) {
        MapBean map = new MapBean();
        map.put("success", true);
        map.put("data", data);
        return map;
    }

    public static MapBean successPageResult(PageEntity data) {
        MapBean map = new MapBean();
        map.put("success", true);
        map.put("total", data.getTotal());
        map.put("data", data.getData());
        return map;
    }

    public static MapBean errorResult(String errDesc) {
        MapBean map = new MapBean();
        map.put("success", false);
        map.put("errDesc", errDesc);
        map.put("data", "");
        return map;
    }


}
