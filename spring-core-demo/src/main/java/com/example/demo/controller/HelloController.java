package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @ClassName: HelloController
 * @Description: Hello
 * @Author: TIEHAN WANG
 * @Date: 2022/4/19 14:05
 * @Version: v1.0
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    // http://localhost:8085/hello 报warning 没有number http://localhost:8085/hello?number=123321 ok
    @ModelAttribute
    public void model(@RequestParam String number, Model model){
        System.out.println("hello");
        model.addAttribute("hello","modelHello");
    }
}
