package com.bin.core.aop;

import com.bin.api.facade.UserFacade;
import com.bin.core.BaseTest;
import org.junit.Test;

/**
 * Created by xiaobin on 2017/1/20.
 */
public class AopTest extends BaseTest {

    @Test
    public void test() {
        UserFacade bean = applicationContext.getBean(UserFacade.class);
        bean.login("123", "wweq");
    }
}
