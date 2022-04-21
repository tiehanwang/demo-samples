package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
