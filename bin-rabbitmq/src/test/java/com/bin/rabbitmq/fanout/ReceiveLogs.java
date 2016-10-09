package com.bin.rabbitmq.fanout;

import com.bin.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.bin.rabbitmq.fanout.EmitLog.EXCHANGE_NAME;

/**
 * 接收日志端(消费者)
 * @Description:
 * @Author: xiaobin.liu
 * @Date: 16/10/9
 * @Time: 下午6:16
 */
public class ReceiveLogs {
    private static final Logger logger = LoggerFactory.getLogger(ReceiveLogs.class);
    @Test
    public void receiveLog() {
        try {
            Connection connection = RabbitMQUtil.createMqConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String queueName = channel.queueDeclare().getQueue();
            logger.info("queueName :" + queueName);
            channel.queueBind(queueName, EXCHANGE_NAME, "");

            logger.info(" [*] Waiting for messages. To exit press CTRL+C");

            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(queueName, true, consumer);

            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());

                logger.info(" [x] Received '" + message + "'");
            }

        } catch (Exception e) {
            logger.error("",e);
        }

    }
}
