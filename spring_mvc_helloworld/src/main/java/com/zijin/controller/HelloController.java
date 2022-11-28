package com.zijin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        //将逻辑视图返回
        //逻辑视图就是将物理视图的前缀和后缀全部去掉 本例中也就是index
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return"success";
    }
}
