package com.Zijin.controller;

import com.Zijin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
/**
 * 1、@RequestMapping注解标识的位置
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求的请求路径的具体信息
 * 2、@RequestMapping注解value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的任意一个值所匹配
 * 3、@RequesMethod注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送的请求的请求方式匹配method属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和@RequestMethod注解value属性匹配但是请求方式不匹配
 * 此时页面报错：405 -Request method 'xxx' not supported
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解
 * @GetMapping，@PostMapping，@DeleteMapping，@PutMapping
 * 4、@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送到请求的请求参数必须满足params属性到的设置
 * params可以使用四种表达式
 * "param":要求请求映射所匹配的请求必须携带param请求参数
 * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 *5、@RequestMapping注解的headers属性
 * 作用：通过请求的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足headers属性的设置
 *  "header"：要求请求映射所匹配的请求必须携带header请求头信息
 * "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
 * "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
 * "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
 * 若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面 显示404错误，即资源未找到
 * 6、SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的value属性值中设置一些特殊字符
 * ？：表示任意的单个字符
 * *：表示任意的0个或多个字符
 *  **：表示任意层数的任意目录
 */
public class TestRequestMappingController {

    @RequestMapping(value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET}
            //params={"username"}
//            headers = {"referer"}
    )//表单提交用post
    //此时控制器方法匹配的映射路径为/test/hello
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
