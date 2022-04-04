package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: MainController
 * @Description: 主控制类
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 16:53
 * @Version: v1.0
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "logoutSuccess";
    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    /**
     * 找不到页面
     */
    @GetMapping("/404")
    public String notFoundPage() {
        return "/error/404";
    }
    /**
     * 未授权
     */
    @GetMapping("/403")
    public String accessError() {
        return "/error/403";
    }
    /**
     * 服务器错误
     */
    @GetMapping("/500")
    public String internalError() {
        return "/error/500";
    }
}
