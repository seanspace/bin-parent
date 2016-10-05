package com.bin.rabbitmq;

import com.bin.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
            Connection connection = RabbitMQUtil.createMqConnection() ;
            Channel channel = connection.createChannel();
            /*创建消息队列，并且发送消息*/
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            logger.info(" [x] Sent '" + message + "'");
            RabbitMQUtil.clossSource(connection,channel);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

}
