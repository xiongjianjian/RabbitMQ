package com.xjj.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xjj.rabbitMQ_Base_Config.rabbitMQ_Base_Config;
import com.xjj.util.MqConnectionUtil;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 16:06
 */
class Producer {
    private rabbitMQ_Base_Config rabbitMQBaseConfig=new rabbitMQ_Base_Config();
    public void sendMsg() throws  Exception{
        //获取到连接以及MQ通道
        Connection connection= MqConnectionUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();
        //声明(创建)队列
        channel.queueDeclare(rabbitMQBaseConfig.QUEUE_NAME,false,false,false,null);
        //消息内容(发送到队列)
        String msg = "Hello,Nice to meet you! tomas";
        channel.basicPublish("",rabbitMQBaseConfig.QUEUE_NAME,null,msg.getBytes());
        //关闭通道和连接
        channel.close();
        connection.close();
    }
    public static void main(String[] args){
        Producer producer = new Producer();
        try {
            producer.sendMsg();
        }catch (Exception e){

        }
    }
}
