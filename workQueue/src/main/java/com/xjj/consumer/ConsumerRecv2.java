package com.xjj.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.xjj.rabbitMQ_BaseConfig.MQBaseConfig;
import com.xjj.util.RabbitMqConnection;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 18:29
 */
public class ConsumerRecv2 {
    private MQBaseConfig mqBaseConfig = new MQBaseConfig();
    public void getMsg2() throws  Exception{
        Connection connection = RabbitMqConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(mqBaseConfig.QUEUE_NAME,false,false,false,null);
        //同一时刻服务器只会发一条消息给消费者
        //channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(mqBaseConfig.QUEUE_NAME,true,consumer);
        //获取消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [y] Received '" + message + "'");
            //休眠
            Thread.sleep(10);
            // 返回确认状态，注释掉表示使用自动确认模式
            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
    public static void main(String[] args) throws Exception {
        ConsumerRecv2 consumerRecv2 = new ConsumerRecv2();
        consumerRecv2.getMsg2();
    }
}
