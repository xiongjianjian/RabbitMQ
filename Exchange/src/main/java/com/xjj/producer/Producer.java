package com.xjj.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xjj.util.MQConnection;

/**
 * @author xiongjianjian
 * @Date 2019/8/21 - 15:26
 */
public class Producer {
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception{
        Connection connection = MQConnection.getConnection();
        Channel channel=connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //消息内容
        String message = "HelloWord!";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
