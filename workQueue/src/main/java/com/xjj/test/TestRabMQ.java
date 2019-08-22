package com.xjj.test;

import com.xjj.consumer.ConsumerRecv1;
import com.xjj.consumer.ConsumerRecv2;
import com.xjj.producer.Producer;

/**
 * @author xiongjianjian
 * @Date 2019/8/20 - 18:46
 */
public class TestRabMQ {
    public static void main(String[] args) throws  Exception {
        Producer producer = new Producer();
        producer.sendMsg();
        ConsumerRecv1 consumerRecv1 = new ConsumerRecv1();
        consumerRecv1.getMsg1();
        ConsumerRecv2 consumerRecv2 = new ConsumerRecv2();
        consumerRecv2.getMsg2();
    }
}
