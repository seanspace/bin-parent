package com.bin.core.entity;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaobin on 2017/1/1.
 */
public class ToStringTest {
    private static final Logger logger = LoggerFactory.getLogger(ToStringTest.class);

    @Test
    public void testToString() {
        UserEntity userEntity = new UserEntity();
        userEntity.setBankCardNo("1234567890123442334");
        userEntity.setEmail("123456@163.com");
        userEntity.setIdCardNo("12345678901235467");
        userEntity.setName("张三");
        userEntity.setPassword("123456");
        logger.info("掩码：" + userEntity);
    }

}
