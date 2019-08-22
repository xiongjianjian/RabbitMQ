package com.xjj.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xjj.rabbitMQ_BaseConfig.MQBaseConfig;
import com.xjj.util.RabbitMqConnection;

import java.io.IOException;

import static com.xjj.rabbitMQ_BaseConfig.MQBaseConfig.QUEUE_NAME;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 18:14
 */
public class Producer {
    private MQBaseConfig mqBaseConfig=new MQBaseConfig();
    public void sendMsg() throws IOException, InterruptedException {
        Connection connection= RabbitMqConnection.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Producer producer = new Producer();
        producer.sendMsg();
    }
}
