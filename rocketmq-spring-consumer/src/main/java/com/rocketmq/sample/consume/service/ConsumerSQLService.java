package com.rocketmq.sample.consume.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ConsumerSQLService
 * @Description: SQL
 * @Author: TIEHAN WANG
 * @Date: 2022/4/30 19:47
 * @Version: v1.0
 */
@Service
@RocketMQMessageListener(topic = "sql-topic",consumerGroup = "${demo.consumer.group2}",selectorExpression = "type = 'user' or a < 7",selectorType = SelectorType.SQL92)
public class ConsumerSQLService implements RocketMQListener<String> {
    @Override
    public void onMessage (String message) {
        System.out.println("收到MSG: "+ message);
    }
}
