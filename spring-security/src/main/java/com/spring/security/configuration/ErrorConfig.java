package com.spring.security.configuration;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @ClassName: ErrorConfig
 * @Description: 错误页配置
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 16:49
 * @Version: v1.0
 */
@Configuration
public class ErrorConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize (ConfigurableWebServerFactory factory) {
                ErrorPage[] errorPages = new ErrorPage[]{
                        new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
                        new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
                        new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"),
                };
                factory.addErrorPages(errorPages);
            }
        };
    }
}
