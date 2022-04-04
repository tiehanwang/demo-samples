package com.spring.security.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: User控制类
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 15:29
 * @Version: v1.0
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    @Secured("ROLE_hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user/hello")
    public String helloAuth(){
        return "/user/hello! helloAuth()";
    }
    @GetMapping("/user/helloworld")
    public String helloWorld(){
        return "/user/helloworld"+"helloWorld()";
    }
    @GetMapping("/user/world")
    public String world(){
        return "/user/world"+"world()";
    }
    @GetMapping("/user/anyWorld")
    public String anyWorld(){
        return "/user/anyWorld";
    }


}
