package com.bin.rabbitmq.workqueue;

import com.bin.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 工作者，多个工作者，协同完成一个队列的任务。
 * Created by xiaobin on 2016/10/5.
 */
public class Worker {
    private static final Logger logger = LoggerFactory.getLogger(Worker.class);

    @Test
    public void doWork() {
        try {
            Connection connection = RabbitMQUtil.createMqConnection();
            Channel channel = connection.createChannel();
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(NewTask.WORK_QUEUE_NAME, true, consumer);
            while (true) {
                try {
                    QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                    String message = new String(delivery.getBody());
                    logger.info(" [Worker] Received '" + message + "'");
                    doWork(message);
                    logger.info(" [Worker] Done");
                    doWork(message);
                } catch (InterruptedException e) {
                    logger.error("InterruptedException:  ",e);
                }
            }
        } catch (IOException e) {
            logger.error(" ",e);
        }

    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
