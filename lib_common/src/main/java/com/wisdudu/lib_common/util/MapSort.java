package com.wisdudu.lib_common.util;


import com.wisdudu.lib_common.util.MD5Util;

import org.json.JSONObject;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 文件描述：参数排序
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public class MapSort {

    static String str = null;

    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    public static String getLoginMD5PostMap(Map<String, Object> map) {
        map.put("temptime", System.currentTimeMillis() / 1000);
        map = sortMapByKey(map);
        str = "";
        for (String key : map.keySet()) {
            str += map.get(key);
        }
        map.put("sign", MD5Util.getMD5(str));
        return new JSONObject(map).toString();
    }

    public static class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }
}
