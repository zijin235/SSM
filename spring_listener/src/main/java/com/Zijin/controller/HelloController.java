package com.Zijin.controller;

import com.Zijin.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    @Autowired
    private HelloServiceImpl helloServiceImpl;

}
