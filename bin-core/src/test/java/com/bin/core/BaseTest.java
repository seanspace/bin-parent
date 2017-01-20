package com.bin.core;


import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@DirtiesContext
//@ContextConfiguration({"/applicationContext.xml"}) //加载配置文件
public class BaseTest {
    protected static ApplicationContext applicationContext;

    @BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("/SpringContext/applicationContext.xml");
    }


}
