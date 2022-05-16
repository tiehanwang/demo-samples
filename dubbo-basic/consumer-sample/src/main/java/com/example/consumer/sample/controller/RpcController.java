package com.example.consumer.sample.controller;

import com.example.common.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RpcController
 * @Description: 测试dubbo远程调用
 * @Author: TIEHAN WANG
 * @Date: 2022/5/16 16:24
 * @Version: v1.0
 */
@RestController
public class RpcController {
	@DubboReference(interfaceClass = DemoService.class,version = "1.0",check = false)
	private DemoService demoService;
	@GetMapping("/hello")
	public String hello(){
		return demoService.sayHello("hello World");
	}
}
