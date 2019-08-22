package com.xjj.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 16:00
 */
public class MqConnectionUtil {
    public static Connection getConnection() throws  Exception{
        //定义连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //设置账号信息，用户名，密码，vhost
        factory.setVirtualHost("testRabbitMQ");
        factory.setUsername("admin");
        factory.setPassword("admin");
        //通过工程获取连接
        Connection connection=factory.newConnection();
        return connection;
    }
}
