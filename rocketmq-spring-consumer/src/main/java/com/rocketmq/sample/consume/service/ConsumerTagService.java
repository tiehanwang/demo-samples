package com.rocketmq.sample.consume.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ConsumerTagService
 * @Description: Tag
 * @Author: TIEHAN WANG
 * @Date: 2022/4/30 17:23
 * @Version: v1.0
 */
//按照TAG进行注册 正常要求一个组内不应该对应两个不同的topic selectType默认是TAG查找注意不一定非要是TAG开头 也可以使用SQL 但需要开启broker时额外配置
@Service
@RocketMQMessageListener(topic = "filter-topic",consumerGroup = "${demo.consumer.group1}",selectorExpression = "TAG1||TAG2",selectorType = SelectorType.TAG)
public class ConsumerTagService implements RocketMQListener<String> {
    @Override
    public void onMessage (String message) {
        System.out.println("收到MSG: "+ message);
    }
}
