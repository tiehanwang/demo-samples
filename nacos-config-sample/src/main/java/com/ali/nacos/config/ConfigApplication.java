package com.ali.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigApplication {

    public static void main (String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
    }

    @RefreshScope
    @RestController
    class SampleController {

        @Value("${user.name}")
        String userName;

        @Value("${user.age}")
        int age;

        @GetMapping("/user")
        public String getUserNameAndAge(){
            return userName+" "+age;
        }
    }
}
