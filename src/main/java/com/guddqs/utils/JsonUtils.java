package com.guddqs.utils;

/**
 * @author wq
 * @date 2018/5/8
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guddqs.common.MapBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {

    }

    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String getJsonString(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T getEntity(String jsonStr, Class<T> clazz)
            throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> getMap(String jsonStr)
            throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> getMap(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = OBJECT_MAPPER.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), getEntity(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> getEntityList(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = OBJECT_MAPPER.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(getEntity(map, clazz));
        }
        return result;
    }


    public static List<MapBean> getEntityList(String jsonArrayStr)
            throws Exception {
        return OBJECT_MAPPER.readValue(jsonArrayStr, new TypeReference<List<MapBean>>() {
        });
    }


    public static <T> T getEntity(Map map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public static List<Object> getObjectArray(String json) throws IOException {
        return OBJECT_MAPPER.readValue(json, new TypeReference<List<Object>>() {
        });
    }
}

