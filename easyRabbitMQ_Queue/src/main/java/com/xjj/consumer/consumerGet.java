package com.xjj.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.xjj.rabbitMQ_Base_Config.rabbitMQ_Base_Config;
import com.xjj.util.MqConnectionUtil;

import static com.xjj.rabbitMQ_Base_Config.rabbitMQ_Base_Config.QUEUE_NAME;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 16:23
 */
class ConsumerGet {
    private rabbitMQ_Base_Config rabbitMQBaseConfig=new rabbitMQ_Base_Config();
    public void getMsg() throws Exception {
        // 获取到连接以及mq通道
        Connection connection = MqConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(rabbitMQBaseConfig.QUEUE_NAME, false, false, false, null);
        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(rabbitMQBaseConfig.QUEUE_NAME,true,consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery=consumer.nextDelivery();
            String msg=new String(delivery.getBody());
            System.out.println("msg = " + msg);
        }
    }

    public static void main(String[] args) {
        ConsumerGet consumerGet=new ConsumerGet();
        try {
            consumerGet.getMsg();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
