package com.rocketmq.sample.consume.service;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConsumerService
 * @Description: 消费者
 * @Author: TIEHAN WANG
 * @Date: 2022/4/30 14:07
 * @Version: v1.0
 */
@Component
//messageModel=MessageModel.BROADCASTING广播
@RocketMQMessageListener(topic = "test-topic",consumerGroup = "${rocketmq.consumer.group}")
public class ConsumerService implements RocketMQListener<String> {
    @Override
    public void onMessage (String message) {
        System.out.println("收到MSG: "+ message);
    }
}
