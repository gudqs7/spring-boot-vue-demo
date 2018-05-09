package com.guddqs.utils;

import java.util.UUID;

/**
 * @author wq
 * @date 2018/5/8
 */
public class UUIDUtils {

    public static String newID() {
        return UUID.randomUUID().toString();
    }

}
