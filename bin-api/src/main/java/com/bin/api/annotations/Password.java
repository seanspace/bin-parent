package com.bin.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 密码
 * @Author: xiaobin.liu
 * @Date: 16/12/29
 * @Time: 上午11:39
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    public boolean encryption() default false;
}
