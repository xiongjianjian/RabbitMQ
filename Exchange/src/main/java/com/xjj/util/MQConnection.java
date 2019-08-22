package com.xjj.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author xiongjianjian
 * @Date 2019/8/21 - 15:22
 */
public class MQConnection {
    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("testRabbitMQ");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        return connection;
    }
}
