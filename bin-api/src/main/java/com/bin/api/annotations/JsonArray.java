package com.bin.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: Json类型的数据
 * @Author: xiaobin.liu
 * @Date: 16/12/29
 * @Time: 下午1:56
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonArray {
    public boolean encryption() default false;

    /**
     * 指定需要加密的key
     * @return
     */
    String[] maskKey();
}
