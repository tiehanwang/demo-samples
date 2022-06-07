package com.example.demo.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: HttpsConfig
 * @Description: Config
 * @Author: TIEHAN WANG
 * @Date: 2022/5/25 21:05
 * @Version: v1.0
 */
@Configuration
public class HttpsConfig{
	@Bean
	public ServletWebServerFactory servletContainer() {

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			//后置处理
			@Override
			protected void postProcessContext(Context context) {
				// 该方法主要进行请求处理的上下文配置， 定义新的安全访问策略
				SecurityConstraint securityConstraint = new SecurityConstraint();
				//此安全约束的用户数据约束。必须为无、完整或机密。
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				//添加映射集合
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				//加入
				context.addConstraint(securityConstraint);
			}
		};
		//主要用于添加Connectors 可用于添加监听端口
		tomcat.addAdditionalTomcatConnectors(createHTTPConnector());

		return tomcat;

	}

	private Connector createHTTPConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		//同时启用http（8086）、https（8085）两个端口 设置重定向
		connector.setScheme("http");
		connector.setSecure(false);
		connector.setPort(8086);
		connector.setRedirectPort(8085);

		return connector;

	}
}
