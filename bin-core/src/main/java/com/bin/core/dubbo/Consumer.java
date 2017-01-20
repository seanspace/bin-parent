package com.bin.core.dubbo;

import com.bin.api.facade.DubboDemoFacade;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Consumer {
 
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/SpringContext/remote-consumer.xml"});
        context.start();
 
        DubboDemoFacade demoService = (DubboDemoFacade)context.getBean("dubboDemoFacade"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
 
        System.out.println( hello ); // 显示调用结果
    }
 
}