package com.example.demo.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MqMessageController
 * @Description: MQ
 * @Author: TIEHAN WANG
 * @Date: 2022/4/29 21:33
 * @Version: v1.0
 */
@RestController
public class MqMessageController {
    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/push")
    public String pushMeg(@RequestParam("id") int id){
        rocketMQTemplate.convertAndSend("test-topic","你好"+id);
        return "helloworld";
    }
}
