package ioc_annotation.controller;

import ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller("Controller")//设置bean的自定义id
@Controller
public class Usercontroller {
    @Autowired
    private UserService userService;
    public void saveUser(){
        userService.saveUser();
    }
}
