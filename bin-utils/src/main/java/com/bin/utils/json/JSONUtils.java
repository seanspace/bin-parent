package com.bin.utils.json;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 * Created by xiaobin on 2016/12/31.
 */
public class JSONUtils {

    /**
     * 转换为json字符串
     * @return
     */
    public String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static void main(String args[]) {

    }

}
