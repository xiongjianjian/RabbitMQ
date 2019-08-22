package com.xjj.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 18:07
 */
public class RabbitMqConnection {
    public static Connection getConnection() throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("testRabbitMQ");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection=factory.newConnection();
        return connection;
    }
}
