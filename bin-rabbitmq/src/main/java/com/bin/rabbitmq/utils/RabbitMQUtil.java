package com.bin.rabbitmq.utils;

import com.bin.rabbitmq.HelloWorld;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 获取连接
 * Created by xiaobin on 2016/10/2.
 */
public class RabbitMQUtil {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    /**
     * 获取mq连接
     * @return  Connection
     */
    public static Connection createMqConnection() throws IOException {
        /*使用工厂类建立Connection和Channel，并且设置参数*/
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.163.129");//MQ的IP
            factory.setPort(5672);//MQ端口
            factory.setUsername("guest");//MQ用户名
            factory.setPassword("guest");//MQ密码
            return factory.newConnection();
        } catch (IOException e) {
            logger.error("获取连接失败");
            throw e ;
        }
    }

    /**
     * 关闭资源
     * @param connection  connection
     * @param channel       channel
     */
    public static void clossSource(Connection connection ,Channel channel) {
        /*关闭连接*/
        try {
            channel.close();
            connection.close();
        } catch (IOException e) {
            logger.error("",e);
        }
    }
}
