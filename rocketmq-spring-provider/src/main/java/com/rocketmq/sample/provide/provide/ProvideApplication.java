package com.rocketmq.sample.provide.provide;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
public class ProvideApplication {

    public static void main (String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
    }
    //生产者
    @ResponseBody
    @GetMapping("/help")
    public String help() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //  1.创建消息生产者，并设置生产组名
        DefaultMQProducer producer = new DefaultMQProducer("product-group");
        // 2.为生产者设置NameServer的地址
        producer.setNamesrvAddr("192.168.100.84:9876");
        // 3.启动生产者
        producer.start();
        // 4.构建消息对象，主要是设置消息的主题 标签 内容
        Message message = new Message("topic", "tag", ("i am message".getBytes()));
        // 5.发送消息，超时时间
        SendResult result = producer.send(message, 10000);
        System.out.println(result);
        // 6.关闭生产者 注意关闭后无法监控
        producer.shutdown();
//        //  1.创建消息消费者，并设置生产组名
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group");
//        // 2.为消费者设置NameServer的地址
//        consumer.setNamesrvAddr("192.168.100.84:9876");
//
//        // 3.指定消费者订阅的主题和标签
//        consumer.subscribe("topic","*");
//        // 4.设置一个回调函数，并在函数中编写接收到的消息之后的处理办法
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                // 消费逻辑
//                System.out.println("message=====> " + list);
//                // 返回消费成功状态
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//        // 3.启动生产者
//        consumer.start();
//        System.out.println("启动消费者成功了");
//        // 6.关闭生产者
////        consumer.shutdown();

        return "help";
    }
}
