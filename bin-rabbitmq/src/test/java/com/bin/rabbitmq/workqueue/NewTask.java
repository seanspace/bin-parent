package com.bin.rabbitmq.workqueue;

import com.bin.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 工作队列生产者
 * Created by xiaobin on 2016/10/5.
 */
public class NewTask {
    private static final Logger logger = LoggerFactory.getLogger(NewTask.class);
    public static final String WORK_QUEUE_NAME = "WORK_QUEUE" ;

    @Test
    public void sendMsg() {
        try {
            Connection connection = RabbitMQUtil.createMqConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(WORK_QUEUE_NAME, false, false, false, null);
            String message = getMessage(new String[]{"Work Queue 队列消息5","Work Queue 队列消息6"});
            channel.basicPublish("", WORK_QUEUE_NAME, null, message.getBytes());
            logger.info(" [Work Queue] Sent '" + message + "'");
            RabbitMQUtil.clossSource(connection,channel);
        } catch (IOException e) {
            logger.error("IO异常：",e);
        }
    }

    private String getMessage(String[] strings){
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

}
