package com.rocketmq.sample.provide.provide.controller;


import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.apache.rocketmq.client.producer.SendStatus.SEND_OK;

/**
 * @ClassName: MqMessageController
 * @Description: MQ
 * @Author: TIEHAN WANG
 * @Date: 2022/4/30 13:28
 * @Version: v1.0
 */
@RestController
public class MqMessageController {

    @Resource
    RocketMQTemplate rocketMQTemplate;

    //简单消息
    @GetMapping("/push")
    public String pushMeg(){
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.convertAndSend("test-topic","rocketmq"+i);
        }
        return "发送成功!";
    }

    //同步消息
    @GetMapping("/pushSync")
    public String pushSync(){
        for (int i = 0; i < 10; i++) {
            SendResult sendResult = rocketMQTemplate.syncSend("test-topic", "同步信息" + i);
            //输出 or 逻辑处理
            System.out.println(sendResult);
        }
        Date date = new Date();
        return date + " "+"成功";
    }
    //异步消息
    @GetMapping("/pushAsync")
    public String pushAsync(){
        for (int i = 0; i < 10; i++) {
            //可以去consume看看 接受到消息的时候 同步消息和异步都是非顺序的 这和负载均衡策略有关
            rocketMQTemplate.asyncSend("test-topic", "异步消息" + i, new SendCallback() {
                //sendResult有个枚举表示状态 SendStatus 可以看看源码
                @Override
                public void onSuccess (SendResult sendResult) {
                    if(sendResult.getSendStatus() == SEND_OK){
                        System.out.println("发送成功!");
                    }
                }

                @Override
                public void onException (Throwable e) {
                    System.out.println("发送失败!");
                }
            });
        }
        return "发送完成";
    }
    //单向消息 发到broker就不管了
    @GetMapping("/pushOneWay")
    public String pushOneWay(){
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.sendOneWay("test-topic","单向消息"+i);
        }
        return "发送完成";
    }
    //消费者广播模式和负载均衡模式
    //默认负载均衡@RocketMQMessageListener(messageModel = MessageModel.BROADCASTING) 广播需要设置消费者messageModel

    //顺序消息rocketmq默认发送的消息是进入多个消息队列，然后消费端多线程并发消费，所以默认情况，不是顺序的.
    @GetMapping("/pushOrder")
    public String sendOrder(){
        //template实现了三种顺序消息 单向同步异步 可以查看结果可知是顺序的.
        for (int i = 0; i < 10; i++) {
            //hashKey – use this key to select queue. for example: orderId, productId ...第三个参数hashKey 可以用订单id等等进行计算即可
            rocketMQTemplate.syncSendOrderly("test-topic","789456 同步消息"+i,"789456");
        }
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.syncSendOrderly("test-topic","789457 同步消息"+i,"789457");
        }
//        rocketMQTemplate.asyncSendOrderly();
//        rocketMQTemplate.sendOneWayOrderly();
        return "成功发送";
    }
    //延迟消息对于消息中间件来说，producer 将消息发送到mq的服务器上，但并不希望这条消息马上被消费，
    //而是推迟到当前时间节点之后的某个时间点，再将消息投递到 queue 中让 consumer 进行消费。
    //RocketMQ 支持定时的延迟消息，但是不支持任意时间精度，仅支持特定的 level，例如定时 5s，10s， 1m 等。
    //其中，level=0 级表示不延时，level=1 表示 1 级延时，level=2 表示 2 级延时，以此类推.
    //messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
    @GetMapping("/pushDelaySync")
    public String sendDelaySync(){
        //发送完可以看消费端的消费
        rocketMQTemplate.syncSend("test-topic", MessageBuilder.withPayload("延迟1s消息").build(),3000,1);
        rocketMQTemplate.syncSend("test-topic", MessageBuilder.withPayload("延迟5s消息").build(),3000,2);
        rocketMQTemplate.syncSend("test-topic", MessageBuilder.withPayload("延迟10s消息").build(),3000,3);
        return "成功发送";
    }
    //事务消息 需要本地事务处理类
    //1. 应用模块遇到要发送事务消息的场景时，先发送prepare消息给MQ。
    //2. prepare消息发送成功后，应用模块执行数据库事务（本地事务）。
    //3. 根据数据库事务执行的结果，再返回Commit或Rollback给MQ。
    //4. 如果是Commit，MQ把消息下发给Consumer端，如果是Rollback，直接删掉prepare消息。
    //5. 第3步的执行结果如果没响应，或是超时的，启动定时任务回查事务状态（最多重试15次，超过了默认丢弃此消息），处理结果同第4步。
    //6. MQ消费的成功机制由MQ自己保证。
    @GetMapping("/pushTran")
    public String sendTransactionMessage() {
        Message<String> msg = MessageBuilder.withPayload("事务消息").build();
        rocketMQTemplate.sendMessageInTransaction("test-topic", msg, null);
        return "发送成功";
    }
    //本地事务处理类 RocketMQLocalTransactionState表事务三状态 未知提交和rollback回滚
    //生产者端发送half消息到MQ-SERVER，然后异步执行executeLocalTransaction方法，返回unknown，
    //MQ-SERVER接收到unknown后，继续等待，然后再执行checkLocalTransaction确认，返回commit，
    //MQ-SERVER得到commit后，消费端才可以消费消息；
    @RocketMQTransactionListener
    class TransactionListenerImpl implements RocketMQLocalTransactionListener {
        //executeLocalTransaction 当执行业务完成后根据处理情况返回,如果是rollback直接丢弃消息commit则消费
        // unknown则继续等待一定时间后,调用checkLocalTransaction最多重试15次，超过了默认丢弃此消息
        @Override
        public RocketMQLocalTransactionState executeLocalTransaction (Message msg, Object arg) {
            System.out.println("executeLocalTransaction");
            //返回unknown测试
            return RocketMQLocalTransactionState.UNKNOWN;
        }
        //checkLocalTransaction 方法，是当MQ Server未得到MQ发送方应答，或者超时的情况，或者应答是unknown的情况，调用此方法进行检查确认
        @Override
        public RocketMQLocalTransactionState checkLocalTransaction (Message msg) {
            System.out.println("checkLocalTransaction");
            return RocketMQLocalTransactionState.COMMIT;
        }
    }
    //过滤消息
    //同过查看消费者后 TAG3消息没有被消费 一个TAG只能有一个标签 且仅仅支持||方式 对于复杂情况需要使用SQL92分配
    @GetMapping("/pushTag")
    public String sendTag(){
        Message<String> msg1 = MessageBuilder.withPayload("测试Tag1").build();
        Message<String> msg2 = MessageBuilder.withPayload("测试Tag2").build();
        Message<String> msg3 = MessageBuilder.withPayload("测试Tag3").build();
        //destination本来的格式就是topic:tag 其中tag可省略 本次过滤使用tag
        rocketMQTemplate.convertAndSend("filter-topic"+":"+"TAG1",msg1);
        rocketMQTemplate.convertAndSend("filter-topic"+":"+"TAG2",msg2);
        rocketMQTemplate.convertAndSend("filter-topic"+":"+"TAG3",msg3);
        return "成功发送";
    }
    //SQL "type = 'user' or a < 7" 收到2和3 成功.
    @GetMapping("/pushSQL")
    public String sendSQL(){
        Message<String> msg1 = MessageBuilder.withPayload("测试1").build();
        Map<String,Object> headers1 = new HashMap<>();
        headers1.put("type","pay");
        headers1.put("a",10);
        Message<String> msg2 = MessageBuilder.withPayload("测试2").build();
        Map<String,Object> headers2 = new HashMap<>();
        headers2.put("type","store");
        headers2.put("a",4);
        Message<String> msg3 = MessageBuilder.withPayload("测试3").build();
        Map<String,Object> headers3 = new HashMap<>();
        headers3.put("type","user");
        headers3.put("a",7);
        rocketMQTemplate.convertAndSend("sql-topic",msg1,headers1);
        rocketMQTemplate.convertAndSend("sql-topic",msg2,headers2);
        rocketMQTemplate.convertAndSend("sql-topic",msg3,headers3);
        return "发送成功";
    }
}
