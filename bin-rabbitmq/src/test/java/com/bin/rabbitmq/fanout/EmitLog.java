package com.bin.rabbitmq.fanout;

import com.bin.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 日志生产者
 * @Description:
 * @Author: xiaobin.liu
 * @Date: 16/10/9
 * @Time: 下午5:54
 */
public class EmitLog {
    private static final Logger logger = LoggerFactory.getLogger(EmitLog.class);
    public static final String EXCHANGE_NAME = "logs";

    @Test
    public static void sendLogs() {
        try {
            Connection connection = RabbitMQUtil.createMqConnection();
            Channel channel = connection.createChannel();

            //定义交换机,名字,类型
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String message = "日志信息..." ;

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            logger.info(" [sendLogs] Sent '" + message + "'");

            RabbitMQUtil.clossSource(connection, channel);

        } catch (IOException e) {
            logger.error("", e);
        }


    }
}
