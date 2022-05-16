package com.example.provider.sample.service;

import com.example.common.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName: DefaultDemoService
 * @Description: DemoService默认实现
 * @Author: TIEHAN WANG
 * @Date: 2022/5/16 16:10
 * @Version: v1.0
 */
@DubboService(interfaceClass = DemoService.class,version = "1.0")
public class DefaultDemoService implements DemoService {

	@Value("${dubbo.application.name}")
	private String serviceName;

	@Override
	public String sayHello (String name) {
		return String.format("[%s] : Hello, %s", serviceName, name);
	}
}
