package com.bin.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * RabbitMQ
 * Created by xiaobin on 2016/9/28.
 */
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    private final static String QUEUE_NAME = "hello_queen";
    public static void main(String[] args) {
        try {
            /*使用工厂类建立Connection和Channel，并且设置参数*/
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.163.129");//MQ的IP
            factory.setPort(5672);//MQ端口
            factory.setUsername("guest");//MQ用户名
            factory.setPassword("guest");//MQ密码
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            /*创建消息队列，并且发送消息*/
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            logger.info(" [x] Sent '" + message + "'");

            /*关闭连接*/
            channel.close();
            connection.close();
        } catch (IOException e) {
            logger.error("", e);
        }
    }

}
