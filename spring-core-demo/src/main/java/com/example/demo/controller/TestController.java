package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: Test
 * @Description: TestController
 * @Author: TIEHAN WANG
 * @Date: 2022/4/20 13:22
 * @Version: v1.0
 */
@Controller
public class TestController {
    @RequestMapping("/testModel")
    public String testModelAttribute(Model model){
        return (String) model.getAttribute("hello");
    }

    @ResponseBody
    @RequestMapping("/test/selectOne")
    public String testOne(Integer i){
        return "helloWorld"+i;
    }

    @ResponseBody
    @GetMapping("/test/getOne")
    public String getOne(@RequestParam Integer num){
        return "getOne"+num;
    }
}
